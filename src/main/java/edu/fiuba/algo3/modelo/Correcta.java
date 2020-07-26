package edu.fiuba.algo3.modelo;

public class Correcta implements Validez{

    private int puntos;

    public Correcta(int puntos){
        this.puntos = puntos;
    }

    @Override
    public void responder(Jugador jugador){
        jugador.responderBien(puntos);
    }
}