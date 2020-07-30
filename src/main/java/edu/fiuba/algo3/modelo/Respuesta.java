package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Certificado certificado;
    private Eleccion eleccion;

    public Respuesta(Jugador jugador, Eleccion eleccion) {

        this.eleccion = eleccion;
        this.jugador = jugador;
        this.certificado = null; //Por ahora queda así, pero estaría bien refactorizar
    }

    public void evaluarConCriterio(Criterio unCriterio) {

        certificado = unCriterio.validarCriterio(eleccion);
    }

    public void responder() {

        certificado.responder(jugador);
    }

}