package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoConPenalidad implements Pregunta{

    private CriterioVerdaderoFalsoConPenalidad criterioVerdaderoFalsoConPenalidad;
    private String enunciado;

    public VerdaderoFalsoConPenalidad(String enunciado, Eleccion eleccion) {
        this.criterioVerdaderoFalsoConPenalidad = new CriterioVerdaderoFalsoConPenalidad(eleccion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioVerdaderoFalsoConPenalidad);
        }
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}