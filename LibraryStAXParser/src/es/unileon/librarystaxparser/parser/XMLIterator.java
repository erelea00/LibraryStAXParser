package es.unileon.librarystaxparser.parser;

import java.util.Iterator;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1
 * 
 * Interfaz que implementarán los iteradores xml concretos
 * @param <T> generic type
 */
public interface XMLIterator<T>{
    
    /**
     * Método que determina si hay elemento siguiente en la colección.
     * @return verdadero si hay elemento siguente, falso en caso contrario.
     */

    public boolean hasNext();
    
    /**
     * Método que devuelve el siguiente objeto de la colección.
     * @return el siguiente objeto de la colección.
     */

    public T next();
    
}
