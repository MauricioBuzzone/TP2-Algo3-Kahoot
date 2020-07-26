package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso implements Pregunta{

    private CriterioVerdaderoFalso criterioVerdaderoFalso;
    private String enunciado;

    public VerdaderoFalso(String enunciado, Opcion opcion) {
        this.criterioVerdaderoFalso = new CriterioVerdaderoFalso(opcion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioVerdaderoFalso);
        }
    }

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}

