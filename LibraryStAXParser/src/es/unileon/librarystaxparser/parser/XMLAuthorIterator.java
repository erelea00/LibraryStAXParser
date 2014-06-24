package es.unileon.librarystaxparser.parser;

import es.unileon.librarystaxparser.data.Author;
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
 * Iterador utilizado para iterar sobre el documento xml gestionando los autores
 */
public class XMLAuthorIterator implements XMLIterator{

    /**
     * Stream que gestiona el puntero al XML y sus operaciones de I/O.
     */
    private XMLStreamReader m_xmlStreamReader;
    
    /**
     * Pila en la que almacenar los nodos abiertos (para saber en que nodo
     * nos encontramos para cada instante del bucle).
     */
    private Stack<String> m_stNodeStack;
    
    /**
     * Constructor del iterador. <br/>
     * Este iterador avanza el puntero del XMLStreamReader. Por lo tanto, cuando
     * finalizan las iteraciones, el XMLStreamReader original apuntará a la 
     * etiqueta 
     * @param xmlStreamReader Stream conteniendo el puntero al XML.
     */
    public XMLAuthorIterator(XMLStreamReader xmlStreamReader) {
        m_xmlStreamReader = xmlStreamReader;
        m_stNodeStack = new Stack<String>();
    }
    
    /**
     * Determina si el autor actual tiene siguiente
     * @return verdadero si hay siguiente
     */
    @Override
    public boolean hasNext(){
        
        boolean result = false;
        
        movePointerToNextStartAuthorTag();
        
        try{           
            result = m_xmlStreamReader.hasNext() && isAnAuthorStartTag();          
        } catch (XMLStreamException ex) {           
            result = false;
        }
        
        return result;
    }
    
    /**
     * Operación de borrar elemento no soportada
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operación no soportada");
    }
    
    /**
     * Mueve el puntero a la siguiente etiqueta "autor"
     */
    public void movePointerToNextStartAuthorTag(){
        
       try {
            while (m_xmlStreamReader.hasNext() && !isAnAuthorStartTag() && !isAnAuthorsEndTag()) {
                m_xmlStreamReader.nextTag();
            }
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        } 
        
    }
    
    /**
     * Comprueba si el elemento actual es una etiqueta de apertura de autor
     * @return verdadero si la etiqueta es de apertura
     */
    private boolean isAnAuthorStartTag() {
        
        return m_xmlStreamReader.isStartElement() && 
                m_xmlStreamReader.getLocalName().equals("autor");
        
    }
    
    /**
     * Comprueba si el elemento actual es una etiqueta de final de autor
     * @return verdadero si la etiqueta es de final
     */
    private boolean isAnAuthorEndTag() {
        
        return m_xmlStreamReader.isEndElement() && 
                m_xmlStreamReader.getLocalName().equals("autor");
 
    }
    
    /**
     * Comprueba si el elemento actual es una etiqueta de apertura de autores
     * @return verdadero si la etiqueta es de apertura
     */
    private boolean isAnAuthorsEndTag() {
        
        return m_xmlStreamReader.isEndElement() && 
                m_xmlStreamReader.getLocalName().equals("autores");
 
    }
    
    /**
     * Desplaza el puntero al siguiente elemento del fichero XML
     * @return Un autor con sus datos correspondientes
     */
    @Override
    public Author next(){
        
        movePointerToNextStartAuthorTag();
        
        Author author = null;
        
        if(isAnAuthorStartTag()){
            
           try{
               author = extractAuthorInfoFromXML(); 
            }catch (XMLStreamException ex) {
                ex.printStackTrace();
            }
            
        }
        
        return author;
        
    }
    
    /**
     * Extrae la información de los autores del fichero XML
     * @return El autor con sus datos
     * @throws XMLStreamException 
     */
    private Author extractAuthorInfoFromXML() throws XMLStreamException{
        
        Author author = new Author();
        
        while (m_xmlStreamReader.hasNext() && !isAnAuthorEndTag()){
            
            switch (m_xmlStreamReader.getEventType()) {
                
                case XMLStreamConstants.START_ELEMENT:
                    m_stNodeStack.push(m_xmlStreamReader.getLocalName());
                    break;
                
                case XMLStreamConstants.CHARACTERS:
                    if (m_stNodeStack.peek().equals("nombre")) {
                        
                        author.setName(author.getName() + m_xmlStreamReader.getText().trim());
                        
                    }else if (m_stNodeStack.peek().equals("primerApellido")){
                        
                        author.setFirstSurname(m_xmlStreamReader.getText().trim());
                        
                    }else if(m_stNodeStack.peek().equals("segundoApellido")){
                        
                         author.setSecondSurname(m_xmlStreamReader.getText().trim());
                        
                    }else if(m_stNodeStack.peek().equals("titulo")){
                        
                        String nodo = m_stNodeStack.pop();
                        
                        if (m_stNodeStack.peek().equals("tituloNobiliario")) {
                            
                            author.setTitle(m_xmlStreamReader.getText().trim());
                        }
                        
                        m_stNodeStack.push(nodo);
                        
                    }else if(m_stNodeStack.peek().equals("fechaConcesion")){
                        
                       String nodo = m_stNodeStack.pop();
                       
                        if (m_stNodeStack.peek().equals("tituloNobiliario")) {
                            
                            author.setTitleDate(m_xmlStreamReader.getText().trim()); 
                        }
                        
                        m_stNodeStack.push(nodo);
                    }
                
                    break;
                    
                case XMLStreamConstants.END_ELEMENT:
                    m_stNodeStack.pop();
                    break;
            }
            
            m_xmlStreamReader.next();
            
        }
        
        m_stNodeStack.clear();
        
        return author;
        
    }
    
}
