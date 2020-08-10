package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class ExclusividadActiva implements EstadoExclusividad{
    private int factor;

    public ExclusividadActiva(int factor){
        this.factor = factor;
    }

    @Override
    public void aplicar(List<Respuesta> respuestas){
        List<Respuesta> respuestasCorrectas = new ArrayList<Respuesta>();
        for(Respuesta respuesta : respuestas){
            if(respuesta.respuestaCorrecta()){
                respuestasCorrectas.add(respuesta);
            }
        }
        if(respuestasCorrectas.size() == 1){
            respuestasCorrectas.get(0).aplicarBonificador(factor);
            respuestasCorrectas.get(0).actualizarPuntaje();
        }
    }

    @Override
    public EstadoExclusividad upgrade(){

        return new ExclusividadActiva(this.factor*2);
    }
}
