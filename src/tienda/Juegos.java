package tienda;

/**
 *
 * @author Andrea y Javi
 */
public class Juegos{

    private String nombre, consola;
    private float precio;
    private int unidades;

    /**
     *Constructor por defecto de la clase Juegos
     */
    public Juegos() {
    }

    /**
     *Constructor con parametros
     * @param nombre
     * @param consola
     * @param precio
     * @param unidades
     */
    public Juegos(String nombre, String consola, float precio, int unidades) {
        this.nombre = nombre;
        this.consola = consola;
        this.precio = precio;
        this.unidades = unidades;
    }

    /**
     *Getter de nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Setter nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Getter consola
     * @return
     */
    public String getConsola() {
        return consola;
    }

    /**
     *Setter de consola
     * @param consola
     */
    public void setConsola(String consola) {
        this.consola = consola;
    }

    /**
     *Getter de precio
     * @return
     */
    public float getPrecio() {
        return precio;
    }

    /**
     *Setter de precio
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     *Getter unidades
     * @return
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     *Setter unidades
     * @param unidades
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    /**
     *toString de la clase Juegos
     * @return
     */
    @Override
    public String toString() {
        return nombre + "," + consola + "," + precio + "," + unidades;
    }


}
