package edu.fiuba.algo3.modelo;

import java.util.List;

public class ExclusividadInactiva implements EstadoExclusividad{

    private int factor;

    public ExclusividadInactiva(){
        this.factor = 1;
    }


    @Override
    public void asignarPuntos(List<Respuesta> respuestas, Evaluador evaluador){
        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarPuntaje();
        }
    }

    @Override
    public EstadoExclusividad actualizarEstado(){
        return new ExclusividadActiva(this.factor*2);
    }
}
