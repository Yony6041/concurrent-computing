package kas.concurrente;

import kas.concurrente.modelos.*;

/**
 * Clase Main
 * Equipo: Estrella
 * Integrantes:
 * Marco Antonio Garcia Arce
 * Yonathan Berith Jaramillo Ramírez
 * Diego Arturo Velázquez Trejo
 */
public class Main {

    /* La lista de nombres de los lugares considerados */
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

        agregaAristas(cu);
        
    }

    public static void agregaAristas(Grafica g){
        g.agregaArista(new Arista(g.getVertices()[0], g.getVertices()[1]));
        g.agregaArista(new Arista(g.getVertices()[0], g.getVertices()[5]));
        g.agregaArista(new Arista(g.getVertices()[1], g.getVertices()[2]));
        g.agregaArista(new Arista(g.getVertices()[2], g.getVertices()[3]));
        g.agregaArista(new Arista(g.getVertices()[3], g.getVertices()[4]));
        g.agregaArista(new Arista(g.getVertices()[4], g.getVertices()[10]));
        g.agregaArista(new Arista(g.getVertices()[5], g.getVertices()[6]));
        g.agregaArista(new Arista(g.getVertices()[5], g.getVertices()[7]));
        g.agregaArista(new Arista(g.getVertices()[7], g.getVertices()[8]));
        g.agregaArista(new Arista(g.getVertices()[7], g.getVertices()[19]));
        g.agregaArista(new Arista(g.getVertices()[8], g.getVertices()[9]));
        g.agregaArista(new Arista(g.getVertices()[9], g.getVertices()[10]));
        g.agregaArista(new Arista(g.getVertices()[9], g.getVertices()[16]));
        g.agregaArista(new Arista(g.getVertices()[10], g.getVertices()[11]));
        g.agregaArista(new Arista(g.getVertices()[11], g.getVertices()[12]));
        g.agregaArista(new Arista(g.getVertices()[12], g.getVertices()[13]));
        g.agregaArista(new Arista(g.getVertices()[13], g.getVertices()[14]));
        g.agregaArista(new Arista(g.getVertices()[14], g.getVertices()[15]));
        g.agregaArista(new Arista(g.getVertices()[14], g.getVertices()[20]));
        g.agregaArista(new Arista(g.getVertices()[15], g.getVertices()[16]));
        g.agregaArista(new Arista(g.getVertices()[16], g.getVertices()[17]));
        g.agregaArista(new Arista(g.getVertices()[17], g.getVertices()[18]));
        g.agregaArista(new Arista(g.getVertices()[18], g.getVertices()[19]));
    }
}