package edu.fiuba.algo3.modelo;

import java.util.List;

public class Exclusividad {

    private EstadoExclusividad estado;

    public Exclusividad(){
        this.estado = new ExclusividadInactiva();
    }

    public void asignarPuntos(List<Respuesta> respuestas, Evaluador evaluador){
        estado.asignarPuntos(respuestas, evaluador);
    }

    public void mejorarExclusividad(){
        estado = estado.actualizarEstado();
    }
}
