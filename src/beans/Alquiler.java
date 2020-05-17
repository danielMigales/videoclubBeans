package beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author daniel migales puertas
 *
 */
public class Alquiler implements Serializable, PropertyChangeListener {//bean receptor implementa serializable y listener

    private int numeroSocio;

    //en vez de crear nuevos atributos de la pelicula se incluye un objeto pelicula
    //String titulo;
    //int numeroEjemplar;
    private Pelicula pelicula;
    private Date fechaAlquiler;
    private Date fechaDevolucion;
    private int cantidadCopias;

    //se insertan todos los constructores y getters-setters
    public Alquiler() {
    }

    public Alquiler(int numeroSocio, Pelicula pelicula, Date fechaAlquiler, Date fechaDevolucion, int cantidadCopias) {
        this.numeroSocio = numeroSocio;
        this.pelicula = pelicula;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.cantidadCopias = cantidadCopias;
    }

   

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }
    
    

    //se implementan los metodos de la clase abstracta. Dentro de este metodo se ponen los avisos y la accion a realizar
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        //en caso de que se produzca un evento aqui procederé a actuar (aviso de evento)
        System.out.println("ALQUILER: Se han agotado las copias de la pelicula en alquiler");

        //se imprimen los valores anterior y nuevo (informacion extra)
        System.out.printf("Copias anteriores: %d%n", evt.getOldValue());
        System.out.printf("Copias disponibles: %d%n", evt.getNewValue());

        //se imprime mensaje indicando la accion que va a tomar como medida
        System.out.println("ALQUILER: Se debe esperar a que haya una devolucion de la pelicula: "
                + pelicula.getTitulo() + "\n");

        //insertar alguna solucion o guardar datos   
    }

}
