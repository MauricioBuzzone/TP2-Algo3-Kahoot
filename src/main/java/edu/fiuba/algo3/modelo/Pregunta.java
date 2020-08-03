package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Pregunta {

    protected Criterio criterio;
    protected String enunciado;

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responderConCriterio(criterio);
        }
    }
}
