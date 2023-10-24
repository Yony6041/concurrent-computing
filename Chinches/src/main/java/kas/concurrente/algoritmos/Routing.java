package kas.concurrente.algoritmos;

import kas.concurrente.modelos.Arista;
import kas.concurrente.modelos.Grafica;
import kas.concurrente.modelos.Vertice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Routing {

    private Grafica grafo;

    public Routing(Grafica grafo) {
        this.grafo = grafo;
    }

    public Map<Vertice, Integer> dijkstra(Vertice origen) {
        Map<Vertice, Integer> distancias = new HashMap<>();
        Map<Vertice, Boolean> visitados = new HashMap<>();
        Queue<Vertice> colaPrioridad = new PriorityQueue<>((v1, v2) -> distancias.get(v1) - distancias.get(v2));

        for (Vertice vertice : grafo.getVertices()) {
            distancias.put(vertice, Integer.MAX_VALUE);
            visitados.put(vertice, false);
        }

        distancias.put(origen, 0);
        colaPrioridad.offer(origen);

        while (!colaPrioridad.isEmpty()) {
            Vertice actual = colaPrioridad.poll();
            if (visitados.get(actual)) continue;
            visitados.put(actual, true);

            for (Arista arista : grafo.obtenerAristasSalientes(actual)) {
                Vertice vecino = arista.getVerticeDos();
                int nuevaDistancia = distancias.get(actual) + arista.getPeso();
                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    colaPrioridad.offer(vecino);
                }
            }
        }

        return distancias;
    }
}
