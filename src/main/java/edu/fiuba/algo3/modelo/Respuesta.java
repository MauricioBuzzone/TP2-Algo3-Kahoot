package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Eleccion eleccion;

    public Respuesta(Jugador jugador, Eleccion eleccion) {

        this.eleccion = eleccion;
        this.jugador = jugador;
    }

    public void responderSegunEvaluador(Evaluador unEvaluador){

        Puntaje puntaje = unEvaluador.evaluarEleccion(eleccion);
        jugador.responder(puntaje);
    }
}