package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class TipoDeRespuestasSinExclusividad implements TipoDeRespuestas {
    private List<Respuesta> misRespuestas;

    public TipoDeRespuestasSinExclusividad(){
        misRespuestas = new ArrayList<Respuesta>();
    }


    public void agregarRespuesta(Respuesta respuesta){
        misRespuestas.add(respuesta);
    }

    public void responder(Evaluador evaluador){
        this.evaluarSegunEvaluador(evaluador);
        this.actualizarPuntaje();
    }

    private void actualizarPuntaje(){
        for(Respuesta respuesta : misRespuestas){
            respuesta.actualizarPuntaje();
        }
    }

    public TipoDeRespuestas mejorarExclusividad(){
        return new TipoDeRespuestasConExclusividad(misRespuestas);
    }

    private void evaluarSegunEvaluador(Evaluador evaluador){
        for(Respuesta respuesta : misRespuestas){
            respuesta.responderSegunEvaluador(evaluador);
        }
    }

}