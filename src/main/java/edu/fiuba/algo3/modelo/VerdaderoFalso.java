package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso {

    private CriterioVF criterioVF;
    private String enunciado;

    public VerdaderoFalso(String enunciado, Opcion opcion) {
        this.criterioVF = new CriterioVF(opcion);
        this.enunciado = enunciado;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.evaluarConCriterio(criterioVF);
        }
    }

    public void responderPregunta(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.responder();
        }
    }
}

