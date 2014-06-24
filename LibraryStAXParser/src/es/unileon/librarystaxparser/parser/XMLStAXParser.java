package es.unileon.librarystaxparser.parser;

import es.unileon.librarystaxparser.exceptions.ErrorOpenningFileException;
import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import java.io.FileInputStream;
import javax.xml.stream.XMLInputFactory;
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
public class XMLStAXParser implements XMLParser {
    
    /**
     * Stream que gestiona el puntero al XML y sus operaciones de I/O.
     */
    private XMLStreamReader m_xmlStreamReader;
    
    /**
     * Constructor de la clase. Toma el fichero pasado por parámetro y lo abre
     * a través de la API de StAX.
     * 
     * @param fileName ruta completa del fichero a procesar.
     */
    public XMLStAXParser (String fileName) throws ErrorOpenningFileException, FileNotFoundException {
        
        try {

            m_xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(
                new FileInputStream(fileName)
            );
         
        } catch (XMLStreamException ex) {
            throw new ErrorOpenningFileException("El fichero no pudo abrirse. ¿Posible problema de permisos?.");
        } catch (java.io.FileNotFoundException ex) {
            throw new FileNotFoundException("El fichero introducido no existe.");
        }
        
    }
    
    @Override
    public XMLIterator createBookIterator() {
        return new XMLBookIterator(m_xmlStreamReader);
    }
    
}
