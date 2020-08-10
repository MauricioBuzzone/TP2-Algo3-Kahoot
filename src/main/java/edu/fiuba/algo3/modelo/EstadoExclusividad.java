package edu.fiuba.algo3.modelo;

import java.util.List;

public interface EstadoExclusividad {
    public void aplicar(List<Respuesta> respuestas);
    public EstadoExclusividad upgrade();
}
