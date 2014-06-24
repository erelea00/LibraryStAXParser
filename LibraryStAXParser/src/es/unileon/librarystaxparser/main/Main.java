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
            checkParameters(args);
        } catch (NoParametersException ex) {
            ex.printStackTrace();
        }
               
    }
    
    public static void checkParameters(String []args) throws NoParametersException{
            
         if (args.length == 0) {
            throw new NoParametersException("No se ha introducido la ubicación del fichero xml.");
        }else{
            
            String fileRoute = null;           
            ParameterProcessor processor = new ParameterProcessor(args);
            
            try {
                fileRoute = processor.getFileName();
            } catch (FileNotFoundException ex) {
            
                ex.printStackTrace();
                
            }
            
        }   
            
    }
    
}
