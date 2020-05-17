package menu;

import beans.Alquiler;
import beans.Pelicula;

/**
 *
 * @author daniel migales puertas
 * 
 */
public class Main {

   
    public static void main(String[] args) {
        
         //Introduzco las peliculas creando objeto y obteniendola de alguna base de datos o fichero
         //titulo, director, actorPrincipal, duracion, año numeroEjemplar, totalCopias
        Pelicula pelicula = new Pelicula("A Score to Settler", "Shawn Ku", "Nicholas Cage", 103, "2019", 1, 3);

        //Se realiza un alquiler de pelicula
        Alquiler alquiler = new Alquiler();
        alquiler.setPelicula(pelicula);
        
        pelicula.addPropertyChangeListener(alquiler);//Aviso de que esta accion puede generar un cambio
        alquiler.setCantidadCopias(1);
        int nuevo_stock = pelicula.getTotalCopias()- alquiler.getCantidadCopias(); //Decremento el stock
        pelicula.setTotalCopias(nuevo_stock); //cambiamos el stock

        System.out.printf("PEDIDO REALIZADO -->Compro: " + pedido1.getCantidad() + " de "
                + pedido1.getProducto().getDescripcion() + "\n");
        
        
        
        
        
    }
    
}
