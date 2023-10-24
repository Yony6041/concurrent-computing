package kas.concurrente.modelos;

import java.util.LinkedList;

/**
 * Clase que representa un vértice en una gráfica.
 */
public class Vertice {

    // Atributos que representan el vértice
    protected int id;
    protected LinkedList<Objeto> objetos;
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
     * Agrega un objeto al vértice.
     * 
     * @param objeto Objeto a agregar al vértice.
     */
    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    /**
     * Obtiene la facultad o asentamiento asociado al vértice.
     * 
     * @return Facultad o asentamiento del vértice.
     */
    public String getFacultad() {
        return facultad;
    }

    public LinkedList<Objeto> getObjetos(){
        return objetos; 
    }
}
