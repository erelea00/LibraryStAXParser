package es.unileon.librarystaxparser.exceptions;

/**
 * Excepción que se lanza en caso de que no exista un ficher al que
 * se quiere acceder.
 */
public class FileNotFoundException extends Exception{
    
    public FileNotFoundException(String msg){
        
        super(msg);
        
    }
    
}
