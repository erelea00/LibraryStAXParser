package es.unileon.librarystaxparser.main;

import es.unileon.librarystaxparser.data.Author;
import es.unileon.librarystaxparser.data.Book;
import es.unileon.librarystaxparser.exceptions.NoBookToShowException;
import java.util.Iterator;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1
 * 
 * Clase que muestra por pantalla información formateada. 
 */
public class ConsoleDisplay {
    
    /**
     * Muestra por consola (stdout) el texto especificado.
     * @param text 
     */
    public void displayText(String text) {
        System.out.println(text);
    }
    
    /**
     * Muestra por consola (stderr) el texto especificado
     * @param errorText 
     */
    public void displayErrorText(String errorText) {
        System.err.println(errorText);
    }
    
    /**
     * Muestra por consola el libro especificado, siguiendo el siguiente 
     * formato:. <br/><br/>
     * 
     *  Los autores: Pedro Pérez, Juan Gómez y Carmen Fernández publicaron el libro "Introducción a SAX" en la editorial Planeta. Cuesta 18 euros <br/><br/>
     *  Los autores: Juan García y María Guerra publicaron el libro "Aprenda JDOM como si estuviese en el Pirineo" en la editorial Anaya. Cuesta 21 euros <br/><br/>
     *  ...
     * @param book
     * @throws NoBookToShowException 
     */
    public void displayBookInfo(Book book) throws NoBookToShowException {
        
        if (book == null)
            throw new NoBookToShowException("No se puede mostrar un libro sin título ni autores.");
        
        String textLine = "Los autores: ";
                
        String authorsText = "";
        
        // Guardamos los autores uno por uno en 'textLine'
        for (Iterator<Author> authors = book.getAuthors().iterator(); authors.hasNext();){
            Author author = authors.next();
            
            // Con este if comprobamos si tenemos que añadir ',' ó una 'y' ó no añadir nada.
            if (!authorsText.isEmpty()) {
                if (authors.hasNext()) {
                    authorsText += ", ";
                } else {
                    authorsText +=" y ";
                }
            }
            
            authorsText += author.getName() + " " + author.getFirstSurname();

            
        }
        textLine += authorsText;
        
        // Guardamos el título del libro.
        textLine += " publicaron el libro \"" + book.getTitle() + "\"";

        // Guardamos la editorial del libro.
        textLine += " en la editorial " + book.getEditorial() + ".";
        
        // Guardamos el precio del libro.
        textLine += " Cuesta " +Double.toString(book.getPrice()) + " euros";
                
        // Lo mostramos por pantalla.
        System.out.println(textLine);
    }
}
