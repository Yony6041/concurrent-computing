package kas.concurrente.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafica {

    // Atributos para almacenar los vértices y aristas de la gráfica
    protected volatile Vertice[] vertices;
    protected volatile ArrayList<Arista> aristas;

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
    public Arista[] getAristas() {
        return aristas;
    }

    /**
     * Agrega un vértice a la gráfica en la posición especificada por el índice.
     * 
     * @param vertice Vértice a agregar.
     * @param indice Índice donde se agrega el vértice.
     */
    public void agregaVertice(Vertice vertice, int indice) {
        vertices[indice] = vertice;
    }

    /**
     * Agrega una arista a la gráfica en la posición especificada por el índice.
     * 
     * @param arista Arista a agregar.
     * @param indice Índice donde se agrega la arista.
     */
    public void agregaArista(Arista arista, int indice) {
        aristas.add(arista);
    }

    // Mapa que asocia cada vértice con una lista de aristas salientes.
    protected Map<Vertice, List<Arista>> aristasSalientes = new HashMap<>();



    // Método para obtener las aristas salientes de un vértice
    public List<Arista> obtenerAristasSalientes(Vertice v) {
        List<Arista> aristasSalientes = new ArrayList<>();
        for (Arista arista : aristas) {
            if (arista.getVerticeUno().equals(v)) {
                aristasSalientes.add(arista);
            }
        }
        return aristasSalientes;
    }
}
