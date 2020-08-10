package edu.fiuba.algo3.modelo;

public class Respuesta {

    private static final int PUNTAJE_NULO = 0;
    private Jugador jugador;
    private Eleccion eleccion;
    private Bonificador bonificador;
    private Puntaje puntaje;

    public Respuesta(Jugador jugador, Eleccion eleccion, Bonificador bonificador) {

        this.eleccion = eleccion;
        this.jugador = jugador;
        this.bonificador = bonificador;
        this.puntaje = Puntaje.crearPuntajeFavorable(PUNTAJE_NULO);
    }

    public void responderSegunEvaluador(Evaluador unEvaluador){
        this.puntaje = unEvaluador.evaluarEleccion(eleccion);
    }

    public void actualizarPuntaje(){
        jugador.responder(puntaje, bonificador);
    }

    public void cambiarBonificador(int factor){
        bonificador.cambiarFactor(factor);
    }

    public boolean respuestaCorrecta(){
        return puntaje.esPositivo();
    }
}