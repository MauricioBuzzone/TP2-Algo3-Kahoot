package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


public class Respuestas{
    private List<Respuesta> respuestas;
    private int factor;

    public Respuestas(){
        respuestas = new ArrayList<Respuesta>();
        factor = 1;
    }

    // Interfaz pública

    public void agregarRespuesta(Respuesta respuesta){
        respuestas.add(respuesta);
    }

    public void responder(Evaluador evaluador){
        if(factor == 1){
            this.responderSinExclusividad(this, evaluador);
        }else {
            this.responderConExclusividad(this, evaluador);
        }
    }
    public void activarExclusividad(){
        factor *= 2;
    }


    // Métodos privados

    private void evaluarSegunEvaluador(Evaluador evaluador){
        for(Respuesta respuesta : respuestas){
            respuesta.responderSegunEvaluador(evaluador);
        }
    }
    private void reestablecerBonificadores(){
        for(Respuesta respuesta : respuestas){
            respuesta.cambiarBonificador(0);
        }
    }
    private Respuestas respuestasCorrectas(Evaluador evaluador){
        Respuestas respuestasCorrectas =  new Respuestas();

        for(Respuesta respuesta : respuestas){
            if(respuesta.respuestaCorrecta(evaluador)){
                respuestasCorrectas.agregarRespuesta(respuesta);
            }
        }
        return respuestasCorrectas;
    }
    private Respuesta obtenerRespuesta(int indice){
        return respuestas.get(indice);
    }
    private void actualizarPuntaje(){
        for(Respuesta respuesta : respuestas){
            respuesta.actualizarPuntaje();
        }
    }
    private int cantidadDeRespuestas(){
        return respuestas.size();
    }

    private void responderConExclusividad(Respuestas respuestas, Evaluador evaluador){

        respuestas.evaluarSegunEvaluador(evaluador);
        respuestas.reestablecerBonificadores();
        Respuestas respuestasCorrectas = respuestas.respuestasCorrectas(evaluador);
        if(respuestasCorrectas.cantidadDeRespuestas() == 1){
            Respuesta respuestaCorrecta = respuestasCorrectas.obtenerRespuesta(0);
            respuestaCorrecta.cambiarBonificador(factor);
        }
        respuestas.actualizarPuntaje();
    }
    private void responderSinExclusividad(Respuestas respuestas,Evaluador evaluador){
        respuestas.evaluarSegunEvaluador(evaluador);
        respuestas.actualizarPuntaje();
    }
}