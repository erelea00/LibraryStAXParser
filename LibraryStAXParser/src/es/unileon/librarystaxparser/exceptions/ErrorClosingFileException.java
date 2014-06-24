package es.unileon.librarystaxparser.exceptions;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 24/06/2014
 * @version 1 
 * 
 * Excepción que se lanza en caso de que no pueda cerrarse un fichero que
 * ha sido previamente abierto.
 */
public class ErrorClosingFileException extends Exception {
    
    public ErrorClosingFileException(String msg){
        
        super(msg);
        
    }
}
