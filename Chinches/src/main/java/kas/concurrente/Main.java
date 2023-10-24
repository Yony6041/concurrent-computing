package kas.concurrente;
import kas.concurrente.modelos.Grafica;
import kas.concurrente.modelos.Vertice; 

/**
 * Clase Main
 * Integrantes:
 * Marco Antonio Garcia Arce
 * Yonathan Berith Jaramillo Ramírez
 * Diego Arturo Velázquez Trejo
 */
public class Main {

    public static String[] facultades = {"Facultad de Psicologia" , "Facultad de Filosofia y Letras", 
    "Facultad de Derecho", "Facultad de Economia", "Facultad de Odontologia", "Rectoria", "Estadio Olimpico",   
    "Facultad de Arquitectura", "Facultad de Ingenieria", "Facultad de Quimica", "Facultad de Medicina",
    "Instituto de Psiquiatria y Salud Mental", "Facultad de Veterinaria", "Instituto de Geofisica", 
    "Facultad de Ciencias", "Ciencias del Mar y Limnologia", "Anexo de Ingenieria", "Facultad de Contaduria",
    "Escuela Nacional de Trabajo Social", "Estadio de Practicas", "Facultad de Ciencias Politicas"};
    public static void main(String[] args) {
        Grafica cu = new Grafica(facultades.length);
        for(int i = 0; i < facultades.length; i++){
            Vertice v = new Vertice(i, facultades[i]); 
            cu.agregaVertice(i, v); 
        }
    }

    
}