package es.unileon.librarystaxparser.main;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import es.unileon.librarystaxparser.exceptions.NoParametersException;
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
        try {
            ParameterProcessor processor = new ParameterProcessor(args);
            
            try {
                processor.checkParameters();
            } catch (NoParametersException ex) {
                ex.printStackTrace(); //imprimir mensaje en vez de stack en la entrega final
            }
            
        String fileName = processor.getFileName();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
