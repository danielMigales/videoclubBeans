package modelo;

import beans.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author daniel migales puertas
 *
 *
 */
public class Ficheros {

    public void guardarArchivoPeliculas(ArrayList<Pelicula> listado) {

        //******IMPORTANTE: CAMBIAR LA RUTA DE GUARDADO DEL ARCHIVO
        File archivo = new File("/home/daniel/listadoPeliculas.txt"); //esta ruta es para mi que uso linux, se debe cambiar segun el S.O
        FileWriter miArchivo;
        try {
            miArchivo = new FileWriter(archivo);
            for (Pelicula listaPelicula : listado) {
                miArchivo.write(listaPelicula.getTitulo() + "\n"
                        + listaPelicula.getDirector() + "\n"
                        + listaPelicula.getActorPrincipal() + "\n"
                        + listaPelicula.getDuracion() + "\n"
                        + listaPelicula.getAño() + "\n"
                        + listaPelicula.getNumeroEjemplar() + "\n"
                        + listaPelicula.getTotalCopias()
                        + "\n\n");
            }
            miArchivo.close();
            //System.out.println("Archivo creado correctamente.");
        } catch (IOException ex) {

        }
    }

    public void leerArchivoPeliculas() {

        File archivo = new File("/home/daniel/listadoPeliculas.txt"); //Al igual que en el caso anterior se debe cambiar esta ruta
        FileReader read;
        try {
            read = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(read);
            String linea;
            try {
                while ((linea = buffer.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException ex) {
                System.out.println("");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("");
        }
    }

}
