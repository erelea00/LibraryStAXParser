package es.unileon.librarystaxparser.exceptions;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1 
 * 
 * Excepción que se lanza en caso de que no no se haya introducido
 * la ubicación del fichero al que se quiere acceder
 */
public class NoParametersException extends Exception{
    
    public NoParametersException(String msg){
        
        super(msg);
        
    }
    
}
