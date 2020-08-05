package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Eleccion eleccion;
    private Bonificador bonificador;

    public Respuesta(Jugador jugador, Eleccion eleccion, Bonificador bonificador) {

        this.eleccion = eleccion;
        this.jugador = jugador;
        this.bonificador = bonificador;
    }

    public void responderSegunEvaluador(Evaluador unEvaluador){

        Puntaje puntaje = unEvaluador.evaluarEleccion(eleccion);
        jugador.responder(puntaje, bonificador);
    }
}