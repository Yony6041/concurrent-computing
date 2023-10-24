package kas.concurrente.modelos;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que representa una Chinche en la simulación.
 */
public class Chinche {

    /* Atributos que representan la vida y letalidad de la chinche. */
    protected AtomicInteger vida;
    protected int letalidad;

    /**
     * Constructor de la clase Chinche que inicializa los atributos de vida y letalidad.
     * 
     * @param vidaInicial Vida inicial de la chinche.
     * @param letalidad Letalidad de la chinche.
     */
    public Chinche(int vidaInicial, int letalidad) {
        this.vida = new AtomicInteger(vidaInicial);
        this.letalidad = letalidad;
    }

    /**
     * Obtiene la vida actual de la chinche.
     * 
     * @return Vida actual de la chinche.
     */
    public int getVida() {
        return vida.get();
    }

    /**
     * Reduce la vida de la chinche en una cantidad especificada.
     * 
     * @param cantidad Cantidad de vida a reducir.
     */
    public void reducirVida(int cantidad) {
        vida.addAndGet(-cantidad);
    }

    /**
     * Obtiene la letalidad de la chinche.
     * 
     * @return Letalidad de la chinche.
     */
    public int getLetalidad() {
        return letalidad;
    }

    /**
     * Establece una nueva letalidad para la chinche.
     * 
     * @param letalidad Nueva letalidad de la chinche.
     */
    public void setLetalidad(int letalidad) {
        this.letalidad = letalidad;
    }
}
