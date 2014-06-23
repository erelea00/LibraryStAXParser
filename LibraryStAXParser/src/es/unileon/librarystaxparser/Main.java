package es.unileon.librarystaxparser;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import es.unileon.librarystaxparser.exceptions.NoParametersException;

/**
 * Clase de entrada de la aplicación. 
 */
public class Main {

    public static void main(String[] args) throws NoParametersException{              
        
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
