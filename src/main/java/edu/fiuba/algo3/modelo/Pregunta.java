package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Pregunta {
    void evaluarRespuestas(ArrayList<Respuesta> respuestas);
    void responderPregunta(ArrayList<Respuesta> respuestas);
}
