package es.unileon.librarystaxparser.main;

import es.unileon.librarystaxparser.exceptions.ErrorClosingFileException;
import es.unileon.librarystaxparser.exceptions.ErrorOpenningFileException;
import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import es.unileon.librarystaxparser.exceptions.NoBookToShowException;
import es.unileon.librarystaxparser.exceptions.NoParametersException;
import es.unileon.librarystaxparser.parser.XMLBookIterator;
import es.unileon.librarystaxparser.parser.XMLParser;
import es.unileon.librarystaxparser.parser.XMLStAXParser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1
 * 
 * Clase de entrada de la aplicación. 
 */
public class Main {

    public static void main(String[] args){ 
        ParameterProcessor processor = new ParameterProcessor(args);
        ConsoleDisplay display = new ConsoleDisplay();
        
        try {
            // Comprobamos que los parámetros son válidos.
            processor.checkParameters();
            
            // Obtenemos la ruta del fichero a procesar.
            String fileName = processor.getFileName();
            
            // Generamos el parser para el fichero
            XMLStAXParser parser = new XMLStAXParser(fileName);
            
            // Cargamos el iterador
            XMLBookIterator bookIterator = (XMLBookIterator) parser.createBookIterator();
            
            while (bookIterator.hasNext()) {
                
                display.displayBookInfo(bookIterator.next());
                
            }
            
            // Finalmente cerramos el fichero
            parser.close();
            
        } catch (NoParametersException ex) {
            
            display.displayErrorText(ex.getMessage());
            display.displayText("Modo de uso: java -jar XMLStaxParser.jar [rutaFicheroLibros.xml]");
            
        } catch (FileNotFoundException | ErrorOpenningFileException | 
                NoBookToShowException | ErrorClosingFileException ex) {
            
            display.displayErrorText(ex.getMessage());
            
        }
    }
    
}
