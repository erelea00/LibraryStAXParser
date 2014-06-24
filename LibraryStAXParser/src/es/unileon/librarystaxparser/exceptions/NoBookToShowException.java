package es.unileon.librarystaxparser.exceptions;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 24/06/2014
 * @version 1 
 * 
 * Excepción que se lanza en caso de que no pueda mostrarse por consola un libro
 */
public class NoBookToShowException extends Exception {
        
    public NoBookToShowException(String msg){
        
        super(msg);
        
    }
    
}
