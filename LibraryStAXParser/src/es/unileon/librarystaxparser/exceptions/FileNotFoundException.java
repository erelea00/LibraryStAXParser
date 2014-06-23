package es.unileon.librarystaxparser.exceptions;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1 
 * 
 * Excepción que se lanza en caso de que no exista un ficher al que
 * se quiere acceder.
 */
public class FileNotFoundException extends Exception{
    
    public FileNotFoundException(String msg){
        
        super(msg);
        
    }
    
}
