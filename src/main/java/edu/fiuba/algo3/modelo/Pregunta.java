package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Pregunta {
    void evaluarRespuestas(List<Respuesta> respuestas);
    void responderPregunta(List<Respuesta> respuestas);
}
