package edu.fiuba.algo3.vista;

public class VistaJugador {

    private String nombre;
    private int puntos;
    public VistaJugador(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public int getPuntos(){
        return puntos;
    }
    public String getNombre(){
        return this.nombre;
    }
}
