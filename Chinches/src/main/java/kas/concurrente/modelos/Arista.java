package kas.concurrente.modelos;

public class Arista {

    protected Vertice uno;
    protected Vertice dos;
    protected int peso; // Peso de la arista

    public Arista(Vertice uno, Vertice dos, int peso) {
        this.uno = uno;
        this.dos = dos;
        this.peso = peso;
    }

    public Vertice getVerticeUno() {
        return uno;
    }

    public Vertice getVerticeDos() {
        return dos;
    }

    public int getPeso() {
        return peso;
    }
    public Vertice getDestino() {
        return dos;
    }
}
