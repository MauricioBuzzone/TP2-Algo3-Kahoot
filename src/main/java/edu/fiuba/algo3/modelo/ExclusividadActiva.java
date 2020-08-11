package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class ExclusividadActiva implements EstadoExclusividad{

    private static final int BONIFICADOR_NULO = 0;
    private int factor;

    public ExclusividadActiva(int factor){
        this.factor = factor;
    }

    @Override
    public void asignarPuntos(List<Respuesta> respuestas, Evaluador evaluador){

        this.anularBonificadores(respuestas);

        List<Respuesta> respuestasCorrectas = this.buscarRespuestasCorrectas(respuestas, evaluador);

        if(respuestasCorrectas.size() == 1 ){
            this.cambiarBonificador(respuestasCorrectas);
        }

        this.actualizarPuntaje(respuestas);
    }

    private void anularBonificadores(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas){
            respuesta.cambiarBonificador(BONIFICADOR_NULO);
        }
    }

    private void cambiarBonificador(List<Respuesta> respuestasCorrectas){
        respuestasCorrectas.get(0).cambiarBonificador(factor);
    }

    private List<Respuesta> buscarRespuestasCorrectas(List<Respuesta> respuestas, Evaluador evaluador){

        List<Respuesta> respuestasCorrectas =  new ArrayList<Respuesta>();

        for(Respuesta respuesta : respuestas){
            if(respuesta.respuestaCorrecta(evaluador)){
                respuestasCorrectas.add(respuesta);
            }
        }
        return respuestasCorrectas;
    }

    private void actualizarPuntaje(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas){
            respuesta.actualizarPuntaje();
        }
    }

    @Override
    public EstadoExclusividad actualizarEstado(){

        return new ExclusividadActiva(this.factor*2);
    }
}
