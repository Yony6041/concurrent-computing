package kas.concurrente.algoritmos;

import kas.concurrente.modelos.Arista;
import kas.concurrente.modelos.Grafica;
import kas.concurrente.modelos.Vertice;
import kas.concurrente.modelos.Chinche;
import kas.concurrente.modelos.Objeto;

import java.util.Random;

public class Flooding {

    private Grafica grafo;

    public Flooding(Grafica grafo) {
        this.grafo = grafo;
    }

    public void moverChinches() {
        Vertice[] vertices = grafo.getVertices();
        for (Vertice vertice : vertices) {
            // Suponiendo que Chinche es un tipo de Objeto, puedes obtener todos los objetos en un vértice y filtrar las chinches.
            for (Objeto objeto : vertice.getObjetos()) {
                if (objeto instanceof Chinche) {
                    moverChinche((Chinche) objeto, vertice);
                }
            }
        }
    }

    private void moverChinche(Chinche chinche, Vertice verticeActual) {
        // Aquí necesitarás una manera de obtener las aristas salientes de un vértice. 
        // Esto podría requerir una modificación en tu clase Grafica o una función adicional.
        Arista[] aristasSalientes = obtenerAristasSalientes(verticeActual);  
        if (aristasSalientes.length > 0) {
            Random random = new Random();
            Arista aristaSeleccionada = aristasSalientes[random.nextInt(aristasSalientes.length)];
            Vertice nuevoVertice = aristaSeleccionada.getVerticeDos();  // Asumiendo que verticeActual es verticeUno

            verticeActual.objetos.remove(chinche);
            nuevoVertice.agregarObjeto(chinche);

            // Posibilidad de reproducción
            if (random.nextDouble() < 0.33) {
                Chinche nuevaChinche = new Chinche(10, 0.7);
                nuevoVertice.agregarObjeto(nuevaChinche);
            }
        }
    }

    // Suponiendo que esta función pueda obtener las aristas salientes de un vértice.
    private Arista[] obtenerAristasSalientes(Vertice vertice) {
        // Implementar la lógica para obtener las aristas salientes.
        // Esto podría requerir una modificación en tu clase Grafica o una función adicional.
        return new Arista[0];  // Retorno dummy, reemplazar con la lógica apropiada.
    }
}
