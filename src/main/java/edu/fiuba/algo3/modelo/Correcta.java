package edu.fiuba.algo3.modelo;

public class Correcta implements Certificado {

    private int puntos;

    public Correcta(int puntos){
        if(puntos < 0){
            throw new PuntosInvalidosException();
        }
        this.puntos = puntos;
    }

    @Override
    public void responder(Jugador jugador){
        jugador.responderBien(puntos);
    }
}