package es.unileon.librarystaxparser.main;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import java.io.File;

/**
 * @author Adrian Diez
 * @author Emanuel Iosif
 * @author Ivan de Paz
 * @since 15/06/2014
 * @version 1
 * 
 * Clase que se encarga de verificar si el fichero xml reside en la ubicación que
 * el usuario ha introducido como argumento al lanzar el programa.
 */
public class ParameterProcessor {
    
    /**
     * Ruta del fichero xml
     */
    private String fileRoute;
    
    /**
     * Constructor de la clase. 
     * @param routes Array de argumentos(rutas) recibidos desde linea de comandos.
     */
    public ParameterProcessor(String[] routes){
        
        fileRoute = routes[0];

    }
    
    /**
     * Método que comprueba si el fichero se encuentra ubicado en la ruta introducida
     * por linea de comandos
     * @return Ruta completa del fichero xml
     * @throws FileNotFoundException Lanzada en caso de que el fichero no exista 
     */
    public String getFileName() throws FileNotFoundException{
        
        
        File file = new File(fileRoute);
 
	if(file.exists()){           
            return fileRoute; 
	}else{
            throw new FileNotFoundException("El fichero introducido no existe.");    
	}
        
    }
    
}
