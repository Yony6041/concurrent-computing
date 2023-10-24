package kas.concurrente.modelos;

import java.util.ArrayList;
import java.util.List;

public class Grafica {

    protected volatile Vertice[] vertices;
    protected volatile Arista[] aristas;

    public Grafica(int capacidad) {
        vertices = new Vertice[capacidad];
    }

    public Vertice[] getVertices() {
        return vertices;
    }

    public Arista[] getAristas() {
        return aristas;
    }

    public void agregaVertice(int indice, Vertice vertice) {
        vertices[indice] = vertice;
    }

    public void agregaArista(Arista arista, int indice) {
        aristas[indice] = arista;
    }

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
