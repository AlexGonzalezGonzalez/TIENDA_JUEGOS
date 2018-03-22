/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import ficheros.Escribir;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author estudios
 */
public class Metodos {

    PrintWriter pw;
    Escribir e = new Escribir();
    String completo = "";
    String linea = "";
    Scanner sc;
    String[] lista = new String[4];
    Juegos j1 = new Juegos();

    /**
     * Metodo nuevoJuego que pide valores y retorna un objeto de tipo Juegos
     *
     * @return
     */
    public Juegos nuevoJuego() {

        j1.setNombre(JOptionPane.showInputDialog("Nombre del Juego"));
        j1.setConsola(JOptionPane.showInputDialog("Consola"));
        j1.setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Precio")));
        j1.setUnidades(Integer.parseInt(JOptionPane.showInputDialog("Unidades")));
        return j1;
    }

    /**
     *
     * @param nombre
     * @return
     */
    public Juegos buscarJuego(String nombre) {

        try {

            sc = new Scanner(new FileInputStream("juegos.txt"));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split("\\s*,\\s*");
                j1 = new Juegos(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                if (j1.getNombre().equalsIgnoreCase(nombre)) {
                    return j1;
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nNo existe el ejemplar en la libreria .\n");
        } finally {
            sc.close();
        }
        return null;
    }

    /**
     *
     * @param nombre
     * @param precio
     */
    public void modificarPrecio(String nombre, float precio) {

        try {
            File pf2 = new File("juegos.txt");
            File tempf2 = new File(pf2.getAbsolutePath() + ".tmp");
            sc = new Scanner(new FileInputStream("juegos.txt"));
            pw = new PrintWriter(new FileWriter(tempf2));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split("\\s*,\\s*");
                j1 = new Juegos(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                if (j1.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println(j1.getNombre() + " Precio antiguo: " + j1.getPrecio());
                    j1 = new Juegos(lista[0], lista[1], precio, Integer.parseInt(lista[3]));
                    System.out.println(j1.getNombre() + " Precio nuevo: " + j1.getPrecio());
                    pw.println(j1.toString());
                } else {
                    pw.println(linea);
                }
            }
            sc.close();
            pw.close();
            if (!pf2.delete()) {
                System.out.println("No es posible eliminar el fichero");
                return;
            }

            //Renombrar el nuevo fichero con el nombre del original
            if (!tempf2.renameTo(pf2)) {
                System.out.println("No se puede renombrar el fichero");

            }

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nNo existe el ejemplar en la libreria .\n");
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }

    }

    /**
     *
     * @param nombre
     * @param unidades
     */
    public void modificarUnidades(String nombre, int unidades) {
        try {
            File pf2 = new File("juegos.txt");
            File tempf2 = new File(pf2.getAbsolutePath() + ".tmp");
            sc = new Scanner(new FileInputStream("juegos.txt"));
            pw = new PrintWriter(new FileWriter(tempf2));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split("\\s*,\\s*");
                j1 = new Juegos(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                if (j1.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println(j1.getNombre() + " Unidades antiguas: " + j1.getUnidades());
                    j1 = new Juegos(lista[0], lista[1], Float.parseFloat(lista[2]), unidades);
                    System.out.println(j1.getNombre() + " Nuevas Unidades: " + j1.getUnidades());
                    pw.println(j1.toString());
                } else {
                    pw.println(linea);
                }
            }
            sc.close();
            pw.close();
            if (!pf2.delete()) {
                System.out.println("No es posible eliminar el fichero");
                return;
            }

            //Renombrar el nuevo fichero con el nombre del original
            if (!tempf2.renameTo(pf2)) {
                System.out.println("No se puede renombrar el fichero");

            }

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nNo existe el ejemplar en la libreria .\n");
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

}
