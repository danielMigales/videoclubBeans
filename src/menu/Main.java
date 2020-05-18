package menu;

import beans.Alquiler;
import beans.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Ficheros;

/**
 *
 * @author daniel migales puertas
 *
 */
public class Main {

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {

        Scanner entrada = new Scanner(System.in);
        int seleccion;
        boolean salir = true;

        do {
            System.out.println("\n*************MENU PRINCIPAL *************\n");
            System.out.println("1. VER PELICULAS DISPONIBLES");
            System.out.println("2. ALQUILAR PELICULA");
            System.out.println("3. DARSE DE ALTA COMO SOCIO");
            System.out.println("4. SALIR DEL PROGRAMA");
            System.out.println("\n******************************************\n");
            System.out.println("Seleccione una opcion:");
            seleccion = entrada.nextInt();
            System.out.println("\n");
            System.out.println("\n******************************************\n");

            switch (seleccion) {

                case 1:
                    listarPeliculas();
                    break;
                case 2:
                    alquilarPelicula();
                    break;
                case 3:
                    break;
                case 4:
                    salir = false;
                    break;
            }
        } while (salir);

    }

    public static void listarPeliculas() {

        //Introduzco tres peliculas creando objetos y guardandolos en arraylist
        //titulo, director, actorPrincipal, duracion, año, numeroEjemplar, totalCopias
        ArrayList<Pelicula> listadoPeliculas = new ArrayList<Pelicula>();

        Pelicula pelicula1 = new Pelicula("A Score to Settler", "Shawn Ku", "Nicholas Cage", 103, "2019", 1, 3);
        listadoPeliculas.add(pelicula1);
        Pelicula pelicula2 = new Pelicula("Te quiero, imbécil", "Laura Mañá", "Quim Gutiérrez", 86, "2020", 1, 2);
        listadoPeliculas.add(pelicula2);
        Pelicula pelicula3 = new Pelicula("The Grudge", "Nicolas Pesce", "Demian Bichir", 194, "2020", 1, 1);
        listadoPeliculas.add(pelicula3);

        //imprimir la lista en la consola
        //System.out.println(listadoPeliculas);
        //guardar la lista en un txt para poder usarlo en otra parte
        Ficheros txt = new Ficheros();
        txt.guardarArchivoPeliculas(listadoPeliculas);
        //leer el fichero creado y mostrarlo
        System.out.println("Los datos que se muestran son titulo, director, actor principal, duracion, año, numero de ejemplar "
                + "y total de copias. \n\n ");
        txt.leerArchivoPeliculas();

        System.out.println("\n******************************************\n");

    }

    public static void alquilarPelicula() {

        //Para iniciar todo este bloque se requiere un objeto pelicula. 
        //Formas de obtenerlo: pidiendo al usuario que lo introduzca parametro a parametro, leerlo de una bd o un fichero o crearlo
        //dos buffers para que no de problemas al cambiar de int a string
        Scanner entradaLetra = new Scanner(System.in);
        Scanner entradaNumero = new Scanner(System.in);

        System.out.println("Escriba el titulo de la pelicula");
        String titulo = entradaLetra.nextLine();
        System.out.println("Escriba el director de la pelicula");
        String director = entradaLetra.nextLine();
        System.out.println("Escriba el actorPrincipal de la pelicula");
        String actorPrincipal = entradaLetra.nextLine();
        System.out.println("Escriba la duracion de la pelicula");
        int duracion = entradaNumero.nextInt();
        System.out.println("Escriba el año de la pelicula");
        String año = entradaLetra.nextLine();
        System.out.println("Escriba el numero de copia de la pelicula");
        int numeroEjemplar = entradaNumero.nextInt();
        System.out.println("Escriba el total de copias de la pelicula");
        int totalCopias = entradaNumero.nextInt();

        //este es el objeto que interesa crear para poder operar con el bean. Da igual como se obtenga
        Pelicula pelicula = new Pelicula(titulo, director, actorPrincipal, duracion, año, numeroEjemplar, totalCopias);

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
                cantidadOK = false;
            } else {
                System.out.println("No esta disponible esa cifra de copias. Introduzca otra cantidad.");
                numeroCopiasAlquiladas = sc.nextInt();
            }
        }
    }

}
