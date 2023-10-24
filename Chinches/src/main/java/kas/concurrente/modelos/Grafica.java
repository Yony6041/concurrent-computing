package kas.concurrente.modelos;

import java.util.LinkedList;

/**
 * Clase que representa una gráfica con vértices y aristas.
 */
public class Grafica{

    // Atributos para almacenar los vértices y aristas de la gráfica
    protected volatile Vertice[] vertices;
    protected volatile LinkedList<Arista> aristas;

    /**
     * Constructor de la clase Grafica que inicializa el arreglo de vértices con una capacidad dada.
     * 
     * @param capacidad Capacidad máxima de la gráfica (número máximo de vértices).
     */
    public Grafica(int capacidad) {
        vertices = new Vertice[capacidad];
    }

    /**
     * Obtiene el arreglo de vértices de la gráfica.
     * 
     * @return Arreglo de vértices de la gráfica.
     */
    public Vertice[] getVertices() {
        return vertices;
    }

    /**
     * Obtiene el arreglo de aristas de la gráfica.
     * 
     * @return Arreglo de aristas de la gráfica.
     */
    public LinkedList<Arista> getAristas() {
        return aristas;
    }

    /**
     * Agrega un vértice a la gráfica en la posición especificada por el índice.
     * 
     * @param vertice Vértice a agregar.
     * @param indice Índice donde se agrega el vértice.
     */
    public void agregaVertice(int indice, Vertice vertice) {
        vertices[indice] = vertice;
    }

    /**
     * Agrega una arista a la gráfica
     * 
     * @param arista Arista a agregar.
     */
    public void agregaArista(Arista arista) {
        aristas.add(arista);
    }
}

