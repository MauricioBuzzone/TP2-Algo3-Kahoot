package edu.fiuba.algo3.modelo;

public class Correcta implements Validez{

    private int puntos;
    public Correcta(){
        this.puntos = 1;
    }
    public Correcta(int puntos){
        this.puntos = puntos;
    }

    @Override
    public void responder(Jugador jugador){
        jugador.responderBien(puntos);
    }
}