package es.unileon.librarystaxparser.main;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import es.unileon.librarystaxparser.exceptions.NoParametersException;
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
    private String[] fileRoutes;
    
    /**
     * Constructor de la clase. 
     * @param routes Array de argumentos(rutas) recibidos desde linea de comandos.
     */
    public ParameterProcessor(String[] routes){
        
        fileRoutes = routes;

    }
    
    /**
     * Método que comprueba si el fichero se encuentra ubicado en la ruta introducida
     * por linea de comandos
     * @return Ruta completa del fichero xml
     * @throws FileNotFoundException Lanzada en caso de que el fichero no exista 
     */
    public String getFileName() throws FileNotFoundException{
        
        String route = fileRoutes[0];
        File file = new File(route);
 
	if(file.exists()){           
            return route; 
	}else{
            throw new FileNotFoundException("El fichero introducido no existe.");    
	}
        
    }
    
    /**
     * Comprueba si se han introducido los parametros correctamente por consola
     * @throws NoParametersException En caso de que no se hayan introducido parametros
     * @throws FileNotFoundException En caso de que el fichero no se encuentra en la ruta introducida como parametro
     */
    public void checkParameters() throws NoParametersException, FileNotFoundException{
        
        if (fileRoutes.length == 0) {
            throw new NoParametersException("No se ha introducido la ubicación del fichero xml.");
        }else{                                  
            
            try {
                getFileName();
            } catch (FileNotFoundException ex) {
                throw new FileNotFoundException("El fichero introducido no existe");
            }
            
        }
        
        
    }
    
}
