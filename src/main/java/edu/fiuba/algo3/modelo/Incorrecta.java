package edu.fiuba.algo3.modelo;


public class Incorrecta implements Validez{

    private int puntos;

    public Incorrecta(int puntos){
        this.puntos = puntos;
    }
    @Override
    public void responder(Jugador jugador){
        jugador.responderMal(puntos);
    }
}