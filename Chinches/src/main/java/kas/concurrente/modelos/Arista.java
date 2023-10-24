package kas.concurrente.modelos;

/**
 * Clase que representa una Arista en un grafo.
 */
public class Arista {

    // Atributos para los dos vértices conectados por la arista
    protected Vertice uno;
    protected Vertice dos;

    /**
     * Constructor de la clase Arista.
     * 
     * @param uno Primer vértice conectado por la arista.
     * @param dos Segundo vértice conectado por la arista.
     */
    public Arista(Vertice uno, Vertice dos) {
        this.one = one;
        this.two = two;
    }

    /**
     * Obtiene el primer vértice conectado por la arista.
     * 
     * @return Primer vértice de la arista.
     */
    public Vertice getVerticeUno() {
        return uno;
    }

    /**
     * Obtiene el segundo vértice conectado por la arista.
     * 
     * @return Segundo vértice de la arista.
     */
    public Vertice getVerticeDos() {
        return dos;
    }
}
