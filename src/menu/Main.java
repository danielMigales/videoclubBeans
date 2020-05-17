package menu;

import beans.Alquiler;
import beans.Pelicula;
import java.util.Scanner;

/**
 *
 * @author daniel migales puertas
 *
 */
public class Main {

    public static void main(String[] args) {

        //Introduzco las peliculas creando objeto y obteniendola de alguna base de datos o fichero
        //titulo, director, actorPrincipal, duracion, año, numeroEjemplar, totalCopias
        Pelicula pelicula = new Pelicula("A Score to Settler", "Shawn Ku", "Nicholas Cage", 103, "2019", 1, 3);
        //Se realiza un alquiler de pelicula
        Alquiler alquiler = new Alquiler(); //se instancia la clase y se añade la pelicula que se alquila
        alquiler.setPelicula(pelicula);
        //se añade el metodo a pelicula para que genere cambio
        pelicula.addPropertyChangeListener(alquiler);//Aviso de que esta accion puede generar un cambio

        System.out.println("¿Cuantas copias quiere alquilar?");
        Scanner sc = new Scanner(System.in);
        int numeroCopiasAlquiladas = sc.nextInt();
        boolean cantidadOK = true;

        while (cantidadOK) {
            if (numeroCopiasAlquiladas <= pelicula.getTotalCopias()) {
                //se define cuantas copias se van a coger (tenemos para alquiler).
                alquiler.setCantidadCopias(numeroCopiasAlquiladas);//Para que salte el bean tendrian que cogerse 3  
                int nuevo_stock = pelicula.getTotalCopias() - alquiler.getCantidadCopias(); //Decremento el stock
                pelicula.setTotalCopias(nuevo_stock); //cambiamos el stock
                //imprime elaviso en la terminal informando del proceso (el alquiler completado)
                System.out.printf("ALQUILER REALIZADO --> Has alquilado: " + alquiler.getCantidadCopias() + " copia de "
                        + alquiler.getPelicula().getTitulo() + "\n");
                cantidadOK=false;
            } else {
                System.out.println("No esta disponible esa cifra de copias. Introduzca otra cantidad.");
                numeroCopiasAlquiladas = sc.nextInt();
                
            }
        }

    }

}
