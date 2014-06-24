package es.unileon.librarystaxparser.exceptions;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 24/06/2014
 * @version 1 
 * 
 * Excepción que se lanza en caso de que no pueda abrirse un fichero al que
 * se quiere acceder.
 */
public class ErrorOpenningFileException extends Exception {
    
    public ErrorOpenningFileException(String msg){
        
        super(msg);
        
    }
}
