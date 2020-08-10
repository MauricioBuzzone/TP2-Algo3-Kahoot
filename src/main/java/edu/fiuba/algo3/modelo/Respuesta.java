package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Eleccion eleccion;
    private Bonificador bonificador;
    private Puntaje puntaje;

    public Respuesta(Jugador jugador, Eleccion eleccion, Bonificador bonificador) {

        this.eleccion = eleccion;
        this.jugador = jugador;
        this.bonificador = bonificador;
    }

    public void responderSegunEvaluador(Evaluador unEvaluador){

        this.puntaje = unEvaluador.evaluarEleccion(eleccion);
    }

    public void actualizarPuntaje(){
        jugador.responder(puntaje, bonificador);
    }

    public void aplicarBonificador(int factor){
        bonificador.cambiarFactor(factor);
    }

    public boolean respuestaCorrecta(){
        return puntaje.esPositivo();
    }
}