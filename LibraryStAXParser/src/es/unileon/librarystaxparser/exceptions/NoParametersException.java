package es.unileon.librarystaxparser.exceptions;

/**
/**
 * Excepción que se lanza en caso de que no no se haya introducido
 * la ubicación del fichero al que se quiere acceder
 */
public class NoParametersException extends Exception{
    
    public NoParametersException(String msg){
        
        super(msg);
        
    }
    
}
