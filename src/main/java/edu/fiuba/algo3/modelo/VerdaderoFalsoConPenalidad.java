package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalsoConPenalidad implements Pregunta{

    private CriterioVerdaderoFalsoConPenalidad criterioVerdaderoFalsoConPenalidad;
    private String enunciado;

    public VerdaderoFalsoConPenalidad(String enunciado, Eleccion eleccion) {
        this.criterioVerdaderoFalsoConPenalidad = new CriterioVerdaderoFalsoConPenalidad(eleccion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioVerdaderoFalsoConPenalidad);
        }
    }

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}