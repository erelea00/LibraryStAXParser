package es.unileon.librarystaxparser.parser;

import es.unileon.librarystaxparser.exceptions.ErrorClosingFileException;
import es.unileon.librarystaxparser.exceptions.ErrorOpenningFileException;
import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * Stream que se utiliza como capa inferior del XML Stream Reader para el
     * acceso al fichero.
     */
    private FileInputStream m_fileInputStream;
    
    /**
     * Constructor de la clase. Toma el fichero pasado por parámetro y lo abre
     * a través de la API de StAX.
     * 
     * @param fileName ruta completa del fichero a procesar.
     */
    public XMLStAXParser (String fileName) throws ErrorOpenningFileException, FileNotFoundException {
        
        try {
            m_fileInputStream = new FileInputStream(fileName);
            
            m_xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(
                m_fileInputStream
            );
         
        } catch (XMLStreamException ex) {
            throw new ErrorOpenningFileException("El fichero no pudo abrirse. ¿Posible problema de permisos?.");
        } catch (java.io.FileNotFoundException ex) {
            throw new FileNotFoundException("El fichero introducido no existe.");
        }
        
    }
    
    /**
     * Trata de cerrar el fichero XML abierto para su procesamiento.
     * @throws XMLStreamException
     * @throws IOException 
     */
    public void close() throws ErrorClosingFileException {
        
        try {
            m_xmlStreamReader.close();
            m_fileInputStream.close();
        } catch (XMLStreamException ex) {
            throw new ErrorClosingFileException("Error cerrando el procesador de XML.");
        } catch (IOException ex) {
            throw new ErrorClosingFileException("Error cerrando el fichero XML.");
        }
    }
    
    @Override
    public XMLIterator createBookIterator() {
        return new XMLBookIterator(m_xmlStreamReader);
    }
    
}
