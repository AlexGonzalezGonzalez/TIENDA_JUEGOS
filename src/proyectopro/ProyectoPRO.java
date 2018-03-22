
package proyectopro;

import tienda.Juegos;
import ficheros.Relleno;
import grafica.Sesion;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author estudios
 */
public class ProyectoPRO {
    static Relleno r= new Relleno();
    static File fichero=new File("juegos.txt");
    static Sesion s= new Sesion();

    /**
     *
     */
    public static ArrayList <Juegos> listaJuegos=new ArrayList();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        listaJuegos=r.rellenar(new File("juegos.txt"));
        
        
        Proceso hilo= new Proceso();
        hilo.start();
        
        s.setVisible(true);
    }
    
}
