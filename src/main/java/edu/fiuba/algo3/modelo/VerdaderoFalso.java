package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso implements Pregunta{

    private CriterioVerdaderoFalso criterioVerdaderoFalso;
    private String enunciado;

    public VerdaderoFalso(String enunciado, Eleccion eleccion) {
        this.criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioVerdaderoFalso);
        }
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}