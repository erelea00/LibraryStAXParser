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
    public void displayText(String text) {
        System.out.println(text);
    }
    
    public void displayErrorText(String errorText) {
        System.err.println(errorText);
    }
    
    public void displayBookInfo(Book book) throws NoBookToShowException {
        
        if (book == null)
            throw new NoBookToShowException("No se puede mostrar un libro sin título ni autores.");
        
        String textLine = "Los autores: ";
                
        // Guardamos los autores uno por uno en 'textLine'
        for (Iterator<Author> authors = book.getAuthors().iterator(); authors.hasNext();){
            Author author = authors.next();
           
            textLine += author.getName() + " " + author.getFirstSurname();

            if (authors.hasNext()) {
               textLine += ", ";
            }
        }

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
