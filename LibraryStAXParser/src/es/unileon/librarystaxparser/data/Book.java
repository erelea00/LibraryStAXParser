package es.unileon.librarystaxparser.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1
 *
 * Clase que guarda la información de un libro.
 */
public class Book {

    /** ISBN del libro **/
    private String m_sISBN;

    /** Titulo del libro **/
    private String m_sTitle;

    /** Autores del libro **/
    private List<Author> m_lAuthors;

    /** Editorial del libro **/
    private String m_sEditorial;

    /** Precio del libro **/
    private double m_dPrice;

    /**
     * Contructor clase
     */
    public Book() {
        m_lAuthors = new ArrayList<Author>();
    }

    /**
     * Getter para el ISBN.
     *
     * @return el ISBN
     */
    public String getISBN() {
        return m_sISBN;
    }

    /**
     * Getter para el titulo.
     *
     * @return el titulo
     */
    public String getTitle() {
        return m_sTitle;
    }

    /**
     * Getter para los autores.
     *
     * @return los autores
     */
    public List<Author> getAuthors() {
        return m_lAuthors;
    }

    /**
     * Getter para la editorial.
     *
     * @return la editorial
     */
    public String getEditorial() {
        return m_sEditorial;
    }

    /**
     * Getter para el precio.
     *
     * @return el precio
     */
    public double getPrice() {
        return m_dPrice;
    }

    /**
     * Setter para el ISBN.
     *
     * @param ISBN String
     */
    public void setISBN(String ISBN) {
        this.m_sISBN = ISBN;
    }

    /**
     * Setter para el titulo.
     *
     * @param title String
     */
    public void setTitle(String title) {
        this.m_sTitle = title;
    }

    /**
     * Setter para los autores.
     *
     * @param authors List<Author>
     */
    public void setAuthors(List<Author> authors) {
        this.m_lAuthors = authors;
    }

    /**
     * Setter para la editorial.
     *
     * @param editorial String
     */
    public void setEditorial(String editorial) {
        this.m_sEditorial = editorial;
    }

    /**
     * Setter para el precio.
     *
     * @param price double
     */
    public void setPrice(double price) {
        this.m_dPrice = price;
    }

    /**
     * Añade un autor a la lista de autores
     *
     * @param author el autor a añadir.
     */
    public void addAuthor(Author author) {
        this.getAuthors().add(author);
    }

}
        
