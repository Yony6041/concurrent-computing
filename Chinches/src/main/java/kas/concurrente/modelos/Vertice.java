package kas.concurrente.modelos;

import java.util.LinkedList;

/**
 * Clase que representa un vértice en una gráfica.
 */
public class Vertice {

    // Atributos que representan el vértice
    protected int id;
    protected LinkedList<Arma> armas;
    protected LinkedList<Chinche> chinches;
    protected LinkedList<Persona> personas;
    protected String facultad;

    /**
     * Constructor de la clase Vertice que inicializa el identificador y la facultad del vértice.
     * 
     * @param i Identificador único del vértice.
     * @param facultad Facultad o asentamiento asociado al vértice.
     */
    public Vertice(int i, String facultad) {
        id = i;
        this.facultad = facultad;
        objetos = new LinkedList<Objeto>();
    }

    /**
     * Obtiene el identificador del vértice.
     * 
     * @return Identificador único del vértice.
     */
    public int getId() {
        return id;
    }

    /**
     * Agrega una persona al vértice.
     * 
     * @param p Persona a agregar al vértice.
     */
    public void agregarPersona(Persona p) {
        personas.add(p);
    }

    /**
     * Agrega una chinche al vértice.
     * 
     * @param c Chinche a agregar al vértice.
     */
    public void agregarChinche(Chinche c) {
        chinches.add(c);
    }

    /**
     * Agrega un arma al vértice.
     * 
     * @param a Arma a agregar al vértice.
     */
    public void agregarPersona(Arma a) {
        armas.add(a);
    }

    /**
     * Obtiene la facultad o asentamiento asociado al vértice.
     * 
     * @return Facultad o asentamiento del vértice.
     */
    public String getFacultad() {
        return facultad;
    }
}
