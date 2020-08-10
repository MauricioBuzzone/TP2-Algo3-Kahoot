package edu.fiuba.algo3.modelo;

import java.util.List;

public class Exclusividad {
    private EstadoExclusividad estado;

    public Exclusividad(){
        this.estado = new ExclusividadInactiva();
    }
    public void aplicar(List<Respuesta> respuestas){
        estado.aplicar(respuestas);
    }
    public void upgrade(){
        estado = estado.upgrade();
    }
}
