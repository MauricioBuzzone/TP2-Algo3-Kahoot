package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceClasico implements Pregunta {

    private CriterioMultipleChoiceClasico criterioMultipleChoiceClasico;
    private String enunciado;

    public MultipleChoiceClasico(String enunciado, Eleccion eleccion) {
        this.criterioMultipleChoiceClasico = new CriterioMultipleChoiceClasico(eleccion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioMultipleChoiceClasico);
        }
    }

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}
