package kas.concurrente.modelos;

public interface Objeto {

    /**
     * Obtiene el nombre del objeto.
     * 
     * @return Nombre del objeto.
     */
    String getNombre();

    /**
     * Obtiene la letalidad del objeto.
     * 
     * @return Letalidad del objeto.
     */
    int getLetalidad();

    /**
     * Establece una nueva letalidad para el objeto.
     * 
     * @param letalidad Nueva letalidad del objeto.
     */
    void setLetalidad(int letalidad);

    /**
     * Obtiene la vida del objeto.
     * 
     * @return Vida del objeto.
     */
    int getVida();

    /**
     * Reduce la vida del objeto en una cantidad especificada.
     * 
     * @param cantidad Cantidad de vida a reducir.
     */
    void reducirVida(int cantidad);
}
