package edu.fiuba.algo3.modelo;

import java.util.List;

public interface EstadoExclusividad {

    public void asignarPuntos(List<Respuesta> respuestas);

    public EstadoExclusividad actualizarEstado();
}
