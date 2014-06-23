package es.unileon.librarystaxparser.parser;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1
 * 
 * Interfaz de parser que implementaran los parsers xml concretos.
 */
public interface XMLParser {
    
    /**
     * Método que crea y devuelve un iterador para iterar sobre la colección 
     * de libros.
     * @return Iterador de colecciónes de libros.
     */
    public XMLIterator createBookIterator();
    
}
