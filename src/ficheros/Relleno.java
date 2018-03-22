package ficheros;

import tienda.Juegos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudios
 */
public class Relleno {

    ArrayList rellenado;
    Leer l = new Leer();
    File fichero = new File("juegos.txt");

    /**
     *
     * @param fichero
     * @return
     */
    public ArrayList rellenar(File fichero) {
        String line = "";
        Juegos j = new Juegos();
        ArrayList<Juegos> lista = new ArrayList();
        try {

            try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
                while ((line = reader.readLine()) != null) {
                    String[] sep = line.split(",");
                    j.setNombre(sep[0]);
                    j.setConsola(sep[1]);
                    j.setPrecio(Float.parseFloat(sep[2]));
                    j.setUnidades(Integer.parseInt(sep[3]));
                    
                    Juegos j1 = new Juegos(j.getNombre(), j.getConsola(), j.getPrecio(), j.getUnidades());
                    lista.add(j1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Relleno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
