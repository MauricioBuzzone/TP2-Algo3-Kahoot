package edu.fiuba.algo3.modelo;

import java.util.List;

abstract class Pregunta {

    protected Criterio criterio;
    protected String enunciado;


    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterio);
        }
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}
