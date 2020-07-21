package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Validez validez;
    private Opcion opcion;

    public Respuesta(Jugador jugador, Opcion opcion) {
        this.opcion = opcion;
        this.jugador = jugador;
        this.validez = null; //Por ahora queda así, pero estaría bien refactorizar
    }

    public void evaluarConCriterio(Criterio criterio) {
        validez = criterio.validarCriterio(opcion);
    }

    public void responder() {
        validez.responder(jugador);
    }

}