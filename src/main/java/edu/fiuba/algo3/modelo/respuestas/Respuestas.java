package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.preguntas.Evaluador;

public class Respuestas{

    TipoDeRespuestas tipoDeRespuestas;

    public Respuestas(){
        tipoDeRespuestas = new TipoDeRespuestasSinExclusividad();
    }

    public void agregarRespuesta(Respuesta respuesta){
        tipoDeRespuestas.agregarRespuesta(respuesta);
    }

    public void responder(Evaluador evaluador){
        tipoDeRespuestas.responder(evaluador);
    }
    public void activarExclusividad(){
        tipoDeRespuestas = tipoDeRespuestas.mejorarExclusividad();
    }
}