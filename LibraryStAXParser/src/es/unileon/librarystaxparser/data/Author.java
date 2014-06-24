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
    
    /** Fecha concesión titulo */
    private String m_sTitleDate;
    
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
     * Getter para la fecha de concesión de titulo
     * @return fecha de concesión de titulo
     */
    public String getTitleDate(){
        return this.m_sTitleDate;
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
    
    /**
     * Setter para la fecha de concesión del titulo
     * 
     * @param titleDate titleDate String
     */
    public void setTitleDate(String titleDate){
        this.m_sTitleDate = titleDate;
    }
    

}