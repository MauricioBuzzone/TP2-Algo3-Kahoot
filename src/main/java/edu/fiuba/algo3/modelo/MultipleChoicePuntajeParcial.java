package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial implements Pregunta {

    private CriterioMultipleChoiceParcial criterioMultipleChoiceParcial;
    private String enunciado;

    public MultipleChoicePuntajeParcial(String enunciado, Eleccion eleccion) {
        this.criterioMultipleChoiceParcial = new CriterioMultipleChoiceParcial(eleccion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioMultipleChoiceParcial);
        }
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}