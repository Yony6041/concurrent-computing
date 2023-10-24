package kas.concurrente.modelos;

import kas.concurrente.modelos.Objeto; 
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una wey junta de que?
 * 
 * 
 * Persona en la simulación.
 */
public class Persona extends Objeto {

    // Atributos que representan la persona
    protected String nombre;
    protected List<Objeto> objetos;
    protected int letalidad;
    protected int vida;  // Asumiendo que una persona también tiene vida como una chinche

    /**
     * Constructor de la clase Persona que inicializa el nombre y la letalidad de la persona.
     * 
     * @param nombre Nombre de la persona.
     * @param letalidad Letalidad inicial de la persona.
     */
    public Persona(String nombre, int letalidad) {
        this.nombre = nombre;
        this.letalidad = letalidad;
        this.objetos = new ArrayList<>();
        this.vida = 100;  // Asumiendo una vida inicial de 100
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega un objeto a la lista de objetos de la persona.
     * 
     * @param objeto Objeto a agregar.
     */
    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    /**
     * Obtiene la letalidad de la persona.
     * 
     * @return Letalidad de la persona.
     */
    public int getLetalidad() {
        return letalidad;
    }

    /**
     * Establece una nueva letalidad para la persona.
     * 
     * @param letalidad Nueva letalidad de la persona.
     */
    public void setLetalidad(int letalidad) {
        this.letalidad = letalidad;
    }

    /**
     * Obtiene la vida de la persona.
     * 
     * @return Vida de la persona.
     */
    public int getVida() {
        return vida;
    }

    /**
     * Reduce la vida de la persona en una cantidad especificada.
     * 
     * @param cantidad Cantidad de vida a reducir.
     */
    public void reducirVida(int cantidad) {
        vida -= cantidad;
    }
}
