package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico implements Pregunta {

    private CriterioMultipleChoiceClasico criterioMultipleChoiceClasico;
    private String enunciado;

    public MultipleChoiceClasico(String enunciado, Eleccion eleccion) {
        this.criterioMultipleChoiceClasico = new CriterioMultipleChoiceClasico(eleccion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioMultipleChoiceClasico);
        }
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}
