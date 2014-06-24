package es.unileon.librarystaxparser.parser;

import es.unileon.librarystaxparser.data.Book;
import java.util.Stack;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 24/06/2014
 * @version 1 
 * 
 * 
 */
public class XMLBookIterator implements XMLIterator {

    /**
     * Stream que gestiona el puntero al XML y sus operaciones de I/O.
     */
    private final XMLStreamReader m_xmlStreamReader;
    
    /**
     * Pila en la que almacenar los nodos abiertos (para saber en que nodo
     * nos encontramos para cada instante del bucle).
     */
    private final Stack<String> m_stNodeStack;  
    
    
    
    /**
     * Constructor del iterador. <br/>
     * Este iterador avanza el puntero del XMLStreamReader. Por lo tanto, cuando
     * finalizan las iteraciones, el XMLStreamReader original apuntará al final 
     * del documento XML.
     * @param xmlStreamReader Stream conteniendo el puntero al XML.
     */
    XMLBookIterator(XMLStreamReader xmlStreamReader) {
        m_xmlStreamReader = xmlStreamReader;
        m_stNodeStack = new Stack<String>();
    }
    
    
    
    
    @Override
    public boolean hasNext() {
        boolean result = false;
        
        // Movemos el puntero al siguiente "<libro>"
        movePointerToNextStartBookTag();
        
        try {
            /*
             * Si el puntero apunta al inicio de un nuevo libro y no es el final
             * del documento, devuelve true.
             */
            result = m_xmlStreamReader.hasNext() && isABookStartTag();
        } catch (XMLStreamException ex) {
            /*
             * Llegados a este punto no deberían saltar excepciones con el 
             * stream... a no ser que se borre el fichero mientras lo estamos
             * procesando o se haga ilegible.
             */
            result = false;
        }
        
        return result;
    }

    
    
    
    
    
    /**
     * Desplaza el puntero del XMLStreamReader al siguiente "&lt;libro&gt;" que 
     * encuentre.
     */
    private void movePointerToNextStartBookTag() {
        
        try {
            while (m_xmlStreamReader.hasNext() && !isABookStartTag()) {
                m_xmlStreamReader.nextTag();
            }
        } catch (XMLStreamException ex) {
            /*Logger.getLogger(XMLBookIterator.class.getName()).log(Level.SEVERE, null, ex);*/
        }
        
    }
    
    
    
    
    
    /**
     * Comprueba si el puntero apunta al inicio de una etiqueta de libro.
     * @return true si es una etiqueta de libro. False si no.
     */
    private boolean isABookStartTag() {
        
        return m_xmlStreamReader.isStartElement() && 
                m_xmlStreamReader.getLocalName().equals("libro");
        
    }
    
    /**
     * Comprueba si el puntero apunta al cierre de una etiqueta de libro.
     * @return true si es una etiqueta de libro. False si no.
     */
    private boolean isABookEndTag() {
        
        return m_xmlStreamReader.isEndElement() && 
                m_xmlStreamReader.getLocalName().equals("libro");
 
    }
    
    
    
    
    
    @Override
    public Book next() {
        // Movemos el puntero al siguiente inicio de libro.
        movePointerToNextStartBookTag();
       
        Book book = null;
        
        if (isABookStartTag()) {
            
            try {
                // Procesamos el XML para rellenar los campos del libro.     
                book = extractBookInfoFromXML();
            } catch (XMLStreamException ex) {
                /*No hay mas libros. Error al leer.*/
            }
            
        }
        
        return book;
    }

    /**
     * Extrae la información del libro al que apunta el puntero XML.<br/><br/>
     * 
     * Precondicion: el puntero debe apuntar a &lt;libro&gt;
     * Postcondicion: el puntero debe apuntar a &lt;/libro&gt;
     * 
     * @return Libro con todos los campos rellenos.
     * @throws XMLStreamException 
     */
    private Book extractBookInfoFromXML() throws XMLStreamException {
        Book book = new Book();
            
        // Todos los libros tienen el ISBN como atributo en la etiqueta:
        book.setISBN(m_xmlStreamReader.getAttributeValue(0));

        while (m_xmlStreamReader.hasNext() && !isABookEndTag()) {
            
            
            switch (m_xmlStreamReader.getEventType()) {

                case XMLStreamConstants.START_ELEMENT:
                    
                    // Metemos en la pila la etiqueta que inicia
                    m_stNodeStack.push(m_xmlStreamReader.getLocalName());
                        
                    // Caso especial: nodo <autores>
                    if (m_xmlStreamReader.getLocalName().equals("autores")) {
                        
                        // Delegamos al iterador de autores:
                        /*
                        * Para el bucle que continua se da el siguiente 
                        * contrato:
                        * -> Precondición: el puntero debe apuntar al nodo 
                                "<autores>"
                        * -> Postcondición: el puntero debe apuntar al fin del
                                nodo "</autores>"
                        */
                        
                        XMLAuthorIterator authorIterator = createAuthorIterator();
                        
                        while (authorIterator.hasNext()) {
                            book.addAuthor(authorIterator.next());
                        }
                        
                        // Sacamos el nodo autores de la pila.
                        m_stNodeStack.pop();
                    } 
                    
                    break;
                    
                    
                case XMLStreamConstants.CHARACTERS:
                    // Comprobamos a qué nodo corresponde el contenido de 
                    // este texto:
                    if (m_stNodeStack.peek().equals("titulo")) {
                        
                        // Verificamos si el título pertenece al libro:
                        
                        // Sacamos el nodo "<titulo>" del stack
                        String nodo = m_stNodeStack.pop();

                        if (m_stNodeStack.peek().equals("libro")) {
                            //Pertenece a libro. Perfect:
                            book.setTitle(book.getTitle() + m_xmlStreamReader.getText().trim());
                        }

                        // Dejamos el stack como estaba
                        m_stNodeStack.push(nodo);
                        
                    } else if (m_stNodeStack.peek().equals("nombre")) {
                        
                        // Verificamos si el nombre pertenece a la editorial:
                        
                        // Sacamos el nodo "<nombre>" del stack
                        String nodo = m_stNodeStack.pop();

                        if (m_stNodeStack.peek().equals("editorial")) {
                            //Pertenece a editorial. Perfect:
                            book.setEditorial(book.getEditorial() + m_xmlStreamReader.getText().trim());
                        }

                        // Dejamos el stack como estaba
                        m_stNodeStack.push(nodo);
                        
                    } else if (m_stNodeStack.peek().equals("precio")) {
                        // Verificamos si el precio pertenece al libro:
                        
                        // Sacamos el nodo "<precio>" del stack
                        String nodo = m_stNodeStack.pop();

                        if (m_stNodeStack.peek().equals("libro")) {
                            //Pertenece a libro. Perfect:
                            String price = m_xmlStreamReader.getText().trim();
                            if (price.isEmpty()) {
                                book.setPrice(book.getPrice() + 0);
                            } else {
                                book.setPrice(Double.valueOf(m_xmlStreamReader.getText().trim()));
                            }
                        }

                        // Dejamos el stack como estaba
                        m_stNodeStack.push(nodo);
                        
                        
                    }
                    break;
                    
                    
                case XMLStreamConstants.END_ELEMENT:
                    // Sacamos de la pila la última etiqueta (suponiendo 
                    // que el xml es correcto).
                    m_stNodeStack.pop();
                    break;
                    

            }

            
            // Avanzamos el puntero una posición.
            m_xmlStreamReader.next();
            
        }
        
        //Limpiamos la pila
        m_stNodeStack.clear();
        
        return book;
    }
    
    /**
     * Genera y devuelve un iterador de autores.
     * 
     * @return iterador de autores.
     */
    private XMLAuthorIterator createAuthorIterator() {
        return new XMLAuthorIterator(m_xmlStreamReader);
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operación no soportada.");
    }
    
}
