package edu.fiuba.algo3.modelo;

import java.util.List;

public class Exclusividad {

    private EstadoExclusividad estado;

    public Exclusividad(){
        this.estado = new ExclusividadInactiva();
    }

    public void asignarPuntos(List<Respuesta> respuestas){
        estado.asignarPuntos(respuestas);
    }

    public void mejorarExclusividad(){
        estado = estado.actualizarEstado();
    }
}
