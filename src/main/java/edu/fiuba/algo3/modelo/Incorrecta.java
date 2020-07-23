package edu.fiuba.algo3.modelo;


public class Incorrecta implements Validez{

    @Override
    public void responder(Jugador jugador){
        jugador.responderMal();
    }
}