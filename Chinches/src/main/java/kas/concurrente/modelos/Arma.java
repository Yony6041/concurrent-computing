package kas.concurrente.modelos;

/**
 * Clase que representa una Arma en la simulación.
 */
public class Arma{

    /* Atributo que representa el aumento en letalidad que proporciona el arma */
    protected int aumentoLetalidad;

    /* Atributo que representa la cantidad de usos restantes */
    protected int usosRestantes;

    /* Atributo que representa el nombre */
    protected String nombre;

    /**
     * Constructor de la clase Arma que inicializa el nombre, los usos restantes y el aumento en letalidad del arma.
     * 
     * @param nombre Nombre del arma.
     * @param usosRestantes Número de usos restantes del arma.
     * @param aumentoLetalidad Aumento en letalidad que proporciona el arma.
     */
    public Arma(String nombre, int usosRestantes, int aumentoLetalidad) {
        this.aumentoLetalidad = aumentoLetalidad;
        this.nombre = nombre;
        this.usosRestantes = usosRestantes;
    }

    /**
     * Obtiene el aumento en letalidad que proporciona el arma.
     * 
     * @return El aumento de letalidad del arma.
     */
    public int getAumentoLetalidad() {
        return aumentoLetalidad;
    }

    /**
     * Obtiene el aumento en letalidad que proporciona el arma.
     * 
     * @return La cantidad restante de usos del arma.
     */
    public int getUsosRestantes() {
        return usosRestantes;
    }

    /**
     * Obtiene el nombre del arma.
     * 
     * @return El nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Utiliza el arma, reduciendo el número de usos restantes en uno.
     * Si el arma aún tiene usos restantes, devuelve el aumento en letalidad que proporciona;
     * de lo contrario, devuelve 0.
     * 
     * @return Aumento en letalidad proporcionado por el arma, o 0 si el arma ya no tiene usos restantes.
     */
    public int usar() {
        if (usosRestantes < 2){
            return 0;
        }
        else{
            usosRestantes--;
            return usosRestantes;
        } 
    }
}
