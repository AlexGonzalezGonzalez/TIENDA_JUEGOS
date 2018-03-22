
package ficheros;

import tienda.Juegos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudios
 */
public class Escribir {
    
    /**
     *
     * @param fichero
     * @param j1
     * @param lista
     * @return
     */
    public ArrayList<Juegos> escribirJuego(File fichero,Juegos j1,ArrayList<Juegos> lista){
        
        try {
            try (PrintWriter writer = new PrintWriter(new FileWriter(fichero,true))) {
                writer.println(j1.toString());
                lista.add(j1);
            }
        } catch (IOException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
         return lista;  
    }
    
        
    }

