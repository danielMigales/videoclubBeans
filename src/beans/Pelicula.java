package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel migales puertas
 *
 */
public class Pelicula implements Serializable { //BEAN FUENTE implementa serializable

    private String titulo;
    private String director;
    private String actorPrincipal;
    private int duracion;
    private String año;
    private int numeroEjemplar;
    int totalCopias;//propiedad compartida que si cambia lanza un evento

    private PropertyChangeSupport propertySupport;//añadir este atributo

    //añadir a los constructores el propertysupport = new PropertySupport
    public Pelicula() {
        propertySupport = new PropertyChangeSupport(this); //se añade
    }

    public Pelicula(String titulo, String director, String actorPrincipal, int duracion, String año, int numeroEjemplar, int totalCopias) {
        this.titulo = titulo;
        this.director = director;
        this.actorPrincipal = actorPrincipal;
        this.duracion = duracion;
        this.año = año;
        this.numeroEjemplar = numeroEjemplar;
        this.totalCopias = totalCopias;
        //se añade
        propertySupport = new PropertyChangeSupport(this); 
    }

    //se añaden estos dos metodos
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNumeroEjemplar() {
        return numeroEjemplar;
    }

    public void setNumeroEjemplar(int numeroEjemplar) {
        this.numeroEjemplar = numeroEjemplar;
    }

    public int getTotalCopias() {
        return totalCopias;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    

    public void setTotalCopias(int valorNuevo) { //modificar este setter y el parametro ponerlo a valorNuevo

        //this.totalCopias = totalCopias; esto ya no sirve
        int valorAnterior = this.totalCopias; //se crea la variable valorAnterior y se iguala a la variable 
        this.totalCopias = valorNuevo; //la variable ahora vale el parametro nuevo

        //aqui se comparan los valores que hacen saltar la alerta
        if (this.totalCopias <= 0) {//ya no se pueden seguir alquilando peliculas
            //entonces se lanza una alerta escrita a la terminal o un dialogo
            System.out.println("PELICULA: Se han agotado las copias.");
            JOptionPane.showMessageDialog(null, "Alerta copia no disponible", "Esta pelicula no se encuentra disponible.", JOptionPane.WARNING_MESSAGE);

            propertySupport.firePropertyChange("copias disponibles",//LANZAMOS EL EVENTO AL RECEPTOR ENVIANDOLE DATOS
                    valorAnterior, this.totalCopias);
        }
    }

}
