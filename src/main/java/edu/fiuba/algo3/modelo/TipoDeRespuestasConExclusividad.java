package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class TipoDeRespuestasConExclusividad implements TipoDeRespuestas {

    private List<Respuesta> misRespuestas;
    private int factor;

    public TipoDeRespuestasConExclusividad(List<Respuesta> respuestas){
        misRespuestas = respuestas;
        factor = 2;
    }

    public TipoDeRespuestas mejorarExclusividad(){
        factor = factor * 2;
        return this;
    }

    public void agregarRespuesta(Respuesta respuesta){
        misRespuestas.add(respuesta);
    }



    @Override
    public void responder(Evaluador evaluador){
        this.evaluarSegunEvaluador(evaluador);
        this.reestablecerBonificadores();
        List<Respuesta> respuestasCorrectas = this.respuestasCorrectas(evaluador);
        if(respuestasCorrectas.size() == 1){
            Respuesta respuestaCorrecta = respuestasCorrectas.get(0);
            respuestaCorrecta.cambiarBonificador(factor);
        }
        this.actualizarPuntaje();
    }

    private void evaluarSegunEvaluador(Evaluador evaluador){
        for(Respuesta respuesta : misRespuestas){
            respuesta.responderSegunEvaluador(evaluador);
        }
    }
    private void reestablecerBonificadores(){
        for(Respuesta respuesta : misRespuestas){
            respuesta.cambiarBonificador(0);
        }
    }
    private List<Respuesta> respuestasCorrectas(Evaluador evaluador){
        List<Respuesta> respuestasCorrectas =  new ArrayList<Respuesta>();

        for(Respuesta respuesta : misRespuestas){
            if(respuesta.respuestaCorrecta(evaluador)){
                respuestasCorrectas.add(respuesta);
            }
        }
        return respuestasCorrectas;
    }
    private void actualizarPuntaje(){
        for(Respuesta respuesta : misRespuestas){
            respuesta.actualizarPuntaje();
        }
    }
}