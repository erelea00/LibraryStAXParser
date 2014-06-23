/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.librarystaxparser;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author EmanuelIosif
 */
public class ParameterProcessor {
    
    private String fileRoute;
    
    public ParameterProcessor(String[] routes){
        
        fileRoute = routes[0];

    }
    
    public String getFileName() throws FileNotFoundException{
        
        
        File file = new File(fileRoute);
 
	if(file.exists()){           
            return fileRoute; 
	}else{
            throw new FileNotFoundException("El fichero introducido no existe.");    
	}
        
    }
    
}
