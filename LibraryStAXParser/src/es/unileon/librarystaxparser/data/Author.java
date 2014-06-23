package es.unileon.librarystaxparser.data;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1
 *
 * Clase que almacena los datos de un autor.
 */
public class Author {

    /** Nombre del autor **/
    private String m_sName;

    /** Primer apellido del autor **/
    private String m_sSurname_1;

    /** Segundo apellido del autor **/
    private String m_sSurname_2;

    /** Titulo que pertenece al autor **/
    private String m_sTitle;
    
    /**
     * Constructor de la clase
     * @param m_sName nombre
     * @param m_sFirstName primer apellido
     * @param m_sSecondName segundo apellido
     * @param m_sTitle titulo perteneciente al autor
     */
    public Author (String m_sName, String m_sFirstName, 
                    String m_sSecondName, String m_sTitle){
        
        this.m_sName = m_sName;
        this.m_sSurname_1 = m_sFirstName;
        this.m_sSurname_2 = m_sSecondName;
        this.m_sTitle = m_sTitle;
        
    }
    
    /**
     * Getter para el nombre.
     *
     * @return el nombre
     */
    public String getName() {
        return this.m_sName;
    }

    /**
     * Getter para el primer apellido.
     *
     * @return el primer apellido
     */
    public String getFirstSurname() {
        return this.m_sSurname_1;
    }

    /**
     * Getter para el segundo apellido.
     *
     * @return el segundo apellido
     */
    public String getSecondSurname() {
        return this.m_sSurname_2;
    }

    /**
     * Getter para el titulo
     *
     * @return el titulo ó ""
     */
    public String getTitle() {
        return this.m_sTitle;
    }

    /**
     * Setter para el nombre.
     *
     * @param name String
     */
    public void setName(String name) {
        this.m_sName = name;
    }

    /**
     * Setter para el primer apellido.
     *
     * @param firstSurname String
     */
    public void setFirstSurname(String firstSurname) {
        this.m_sSurname_1 = firstSurname;
    }

    /**
     * Setter para el segundo apellido.
     *
     * @param secondSurname String
     */
    public void setSecondSurname(String secondSurname) {
        this.m_sSurname_2 = secondSurname;
    }

    /**
     * Setter para el titulo.
     *
     * @param title String
     */
    public void setTitle(String title) {
        this.m_sTitle = title;
    }

}