package kas.concurrente.algoritmos;

import kas.concurrente.modelos.Arista;
import kas.concurrente.modelos.Grafica;
import kas.concurrente.modelos.Vertice;
import kas.concurrente.modelos.Chinche;
import java.util.LinkedList;

import java.util.Random;

public class Flooding {

    private Grafica grafo;

    public Flooding(Grafica grafo) {
        this.grafo = grafo;
    }

    public void moverChinches() {
        Vertice[] vertices = grafo.getVertices();
	for (Vertice vertice : vertices){
		for (Chinche c : vertice.getChinches()){
			moverChinche(c, vertice);
		}
	}
    }

    private void moverChinche(Chinche chinche, Vertice verticeActual) {
        // Esto podría requerir una modificación en tu clase Grafica o una función adicional.

	LinkedList<Vertice> disponibles = new LinkedList<>();
	for (Arista a : grafo.getAristas()){
		if (a.getVerticeUno().equals(verticeActual))
			disponibles.add(a.getVerticeDos());
		else if (a.getVerticeDos().equals(verticeActual))
			disponibles.add(a.getVerticeUno());
	}

	if (disponibles.size() > 0){
		Random random = new Random();
		Vertice seleccion = disponibles.get(random.nextInt(disponibles.size()));
		
		verticeActual.eliminarChinche(chinche);
		seleccion.agregarChinche(chinche);

		if (random.nextDouble() < 0.33){
			Chinche nuevoChinche = new Chinche(10, 5);
			seleccion.agregarChinche(nuevoChinche);
		}
	}
    }
} 