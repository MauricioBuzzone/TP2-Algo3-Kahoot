package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Eleccion eleccion;

    public Respuesta(Jugador jugador, Eleccion eleccion) {

        this.eleccion = eleccion;
        this.jugador = jugador;
    }

    public void responderConCriterio(Criterio unCriterio) {

        Certificado certificado = unCriterio.validarCriterio(eleccion);
        certificado.responder(jugador);
    }

    public void responderConEvaluador(Evaluador unEvaluador){
        Certificado certificado = unEvaluador.evaluarEleccion(eleccion);
        certificado.responder(jugador);
    }
}