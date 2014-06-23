/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.librarystaxparser;

import es.unileon.librarystaxparser.exceptions.FileNotFoundException;
import es.unileon.librarystaxparser.exceptions.NoParametersException;
import java.io.IOException;

/**
 *
 * @author EmanuelIosif
 */
public class Main {

    public static void main(String[] args) throws NoParametersException{              
        
        if (args.length == 0) {
            throw new NoParametersException("No se ha introducido la ubicación del fichero xml.");
        }else{
            
            String fileRoute = null;           
            ParameterProcessor processor = new ParameterProcessor(args);
            
            try {
                fileRoute = processor.getFileName();
            } catch (FileNotFoundException ex) {
            
                ex.printStackTrace();
                
            }
            
        }
    }
    
}
