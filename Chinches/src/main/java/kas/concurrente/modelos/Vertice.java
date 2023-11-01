package kas.concurrente.modelos;

import java.util.LinkedList;
import java.util.Random;

/**
 * Clase que representa un vértice en una gráfica.
 */
public class Vertice {

    // Atributos que representan el vértice
    protected int id;
    protected LinkedList<Arma> armas;
    protected LinkedList<Chinche> chinches;
    protected LinkedList<Persona> personas;
    protected String facultad;

    /**
     * Constructor de la clase Vertice que inicializa el identificador y la facultad del vértice.
     * 
     * @param i Identificador único del vértice.
     * @param facultad Facultad o asentamiento asociado al vértice.
     */
    public Vertice(int i, String facultad) {
        id = i;
        this.facultad = facultad;
        armas = new LinkedList<>();
        chinches = new LinkedList<>();
        personas = new LinkedList<>();
    }

    /**
     * Obtiene el identificador del vértice.
     * 
     * @return Identificador único del vértice.
     */
    public int getId() {
        return id;
    }

    /**
     * Agrega una persona al vértice.
     * 
     * @param p Persona a agregar al vértice.
     */
    public void agregarPersona(Persona p) {
        personas.add(p);
    }

    /**
     * Agrega una chinche al vértice.
     * 
     * @param c Chinche a agregar al vértice.
     */
    public void agregarChinche(Chinche c) {
        chinches.add(c);
    }

    /**
     * Elimina una chinche al vértice.
     * 
     * @param c Chinche a eliminar del vértice.
     */
    public void eliminarChinche(Chinche c) {
        chinches.remove(c);
    }

    /**
     * Agrega un arma al vértice.
     * 
     * @param a Arma a agregar al vértice.
     */
    public void agregarPersona(Arma a) {
        armas.add(a);
    }

    /**
     * Obtiene la facultad o asentamiento asociado al vértice.
     * 
     * @return Facultad o asentamiento del vértice.
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * Regresa la lista de armas en este vertice
     * 
     * @return La lista de armas
     */
    public LinkedList<Arma> getArmas(){
        return armas; 
    }

    /**
     * Regresa la lista de personas en este vertice
     * 
     * @return La lista de personas
     */
    public LinkedList<Persona> getPersonas(){
        return personas; 
    }

    /**
     * Regresa la lista de chinches
     * 
     * @return La lista de chinches
     */
    public LinkedList<Chinche> getChinches(){
        return chinches; 
    }

    /**
     * Obtiene la letalidad de personas ya sea en grupo o si esta solo 
     *
     * @return la letalidad de las personas en este vertice.
     */
    public int getLetalidadTotalPersonas(){
	double letalidadTotal = 0;
	for(int i = 0; i < personas.size(); i++){
		letalidadTotal = letalidadTotal + personas.get(i).getLetalidad();
	}
	if(personas.size() > 1)
		letalidadTotal = letalidadTotal * .75;

	return (int) Math.round(letalidadTotal);
    }

    /**
     * Obtiene la letalidad de chinches en este vertice. 
     *
     * @return la letalidad de las chinches en este vertice.
     */
    public int getLetalidadTotalChinches(){
	int letalidadTotal = 0;
	for(int i = 0; i < chinches.size(); i++)
		letalidadTotal = letalidadTotal + chinches.get(i).getLetalidad();
	return letalidadTotal;
    }

    /**
     * Metodo para indicar la interaccion entre chinches y humanos
     *
     */
    public void interaccionChincheHumano(){
	Random random = new Random();
	int pl = getLetalidadTotalPersonas();
	int cl = getLetalidadTotalChinches();
	if(random.nextDouble() < 1 - (pl * ((pl + cl) / 100))){
		for(Persona p : personas){
			p.reducirVida((int) Math.round(cl / personas.size()));
			if(p.getVida() < 1){
				if(!p.resureccion()){
					System.out.println(p.getNombre() + " ha muerto sin resureccion.");
					personas.remove(p);
				}
			}
		}
	}
	else{
		for(Chinche c : chinches){
			c.reducirVida((int) Math.round(pl / chinches.size()));
			if(c.getVida() < 1){
			System.out.println("Se han eliminado una chinche.");	
			chinches.remove(c);			
			}

		}
	}
    }
}
