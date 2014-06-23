/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.librarystaxparser;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import java.io.File;

/**
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
