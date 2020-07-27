package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Validez validez;
    private Eleccion eleccion;

    public Respuesta(Jugador jugador, Eleccion eleccion) {

        this.eleccion = eleccion;
        this.jugador = jugador;
        this.validez = null; //Por ahora queda así, pero estaría bien refactorizar
    }

    public void evaluarConCriterio(Criterio unCriterio) {

        validez = unCriterio.validarCriterio(eleccion);
    }

    public void responder() {

        validez.responder(jugador);
    }

}