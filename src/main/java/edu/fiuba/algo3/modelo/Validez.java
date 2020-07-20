package edu.fiuba.algo3.modelo;

interface Validez{
    public void responder(Jugador jugador);
}

public class Correcta implements Validez{

    @Override
    public void responder(Jugador jugador){
        jugador.responderBien();
    }
}

public class Incorrecta implements Validez{

    @Override
    public void responder(Jugador jugador){
        jugador.responderMal();
    }
}