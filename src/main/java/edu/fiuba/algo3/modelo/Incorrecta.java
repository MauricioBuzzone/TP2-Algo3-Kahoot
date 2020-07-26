package edu.fiuba.algo3.modelo;


public class Incorrecta implements Validez{

    private int puntos;

    public Incorrecta(){
        this.puntos = 0;
    }
    public Incorrecta(int puntos){
        this.puntos = puntos;
    }
    @Override
    public void responder(Jugador jugador){
        jugador.responderMal(puntos);
    }
}