package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso {
    private Criterio criterio;
    private String enunciado;
}
public VerdaderoFalso(String enunciado, Opcion opcion){
    this.criterio= new Criterio(opcion);
    this.enunciado=enunciado;
}

public void evaluarRespuestas(ArrayList<Respuesta> respuestas){
    for (Respuesta respuesta: respuestas){
        respuesta.evaluarConCriterio(criterio);
    }
}

public void responderPregunta(ArrayList<Respuesta> respuestas){
    for(Respuesta respuesta:respuestas){
        respuesta.responder();
    }
}

