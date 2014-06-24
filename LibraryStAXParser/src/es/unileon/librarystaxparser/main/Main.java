package es.unileon.librarystaxparser.main;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import es.unileon.librarystaxparser.exceptions.NoParametersException;

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
        
        try {
            processor.checkParameters();
        } catch (NoParametersException ex) {
            ex.printStackTrace(); //imprimir mensaje en vez de stack en la entrega final
        }
               
    }
    
}
