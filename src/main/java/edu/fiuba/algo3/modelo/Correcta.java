package edu.fiuba.algo3.modelo;

public class Correcta implements Validez{

    @Override
    public void responder(Jugador jugador){
        jugador.responderBien();
    }
}