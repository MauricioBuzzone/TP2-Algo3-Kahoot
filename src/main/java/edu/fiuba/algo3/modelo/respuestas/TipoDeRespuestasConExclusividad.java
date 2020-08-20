package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Bonificador;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;

import java.util.List;
import java.util.ArrayList;

public class TipoDeRespuestasConExclusividad implements TipoDeRespuestas {

    private List<Respuesta> misRespuestas;
    private Bonificador miBonificador;

    public TipoDeRespuestasConExclusividad(List<Respuesta> respuestas){
        misRespuestas = respuestas;
        miBonificador = new Bonificador();
        miBonificador.cambiarFactorX2();
    }

    public TipoDeRespuestas mejorarExclusividad(){
        miBonificador.cambiarFactorX4();
        return this;
    }

    public void agregarRespuesta(Respuesta respuesta){
        misRespuestas.add(respuesta);
    }

    @Override
    public void responder(Evaluador evaluador){
        this.anularBonificadores();
        this.asignarPuntajeCon(evaluador);

        if(this.hayUnicaRespuestaCorrecta(evaluador)){
            Respuesta respuestaCorrecta = this.buscarRespuestaCorrecta(evaluador);
            respuestaCorrecta.cambiarBonificador(miBonificador);
        }
        this.actualizarPuntaje();
    }

    private boolean hayUnicaRespuestaCorrecta(Evaluador evaluador){
        int cantidadDeCorrectas = 0;
        for (Respuesta respuesta : misRespuestas) {
            if (respuesta.respuestaCorrecta(evaluador)) {
                cantidadDeCorrectas++;
            }
        }
        return cantidadDeCorrectas == 1;
    }

    private Respuesta buscarRespuestaCorrecta(Evaluador evaluador){
        Respuesta respuestaCorrecta = null;
        for(Respuesta respuesta : misRespuestas){
            if(respuesta.respuestaCorrecta(evaluador)){
                respuestaCorrecta = respuesta;
            }
        }
        return respuestaCorrecta;
    }

    private void asignarPuntajeCon(Evaluador evaluador){
        for(Respuesta respuesta : misRespuestas){
            respuesta.responderSegunEvaluador(evaluador);
        }
    }

    private void actualizarPuntaje(){
        for(Respuesta respuesta : misRespuestas){
            respuesta.actualizarPuntaje();
        }
    }

    private void anularBonificadores(){
        for(Respuesta respuesta : misRespuestas){
            Bonificador bonificadorNulo = new Bonificador();
            bonificadorNulo.anular();
            respuesta.cambiarBonificador(bonificadorNulo);
        }
    }
}