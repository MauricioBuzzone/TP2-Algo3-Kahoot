package edu.fiuba.algo3.modelo;

public interface TipoDeRespuestas {
    public void responder(Evaluador evaluador);
    public TipoDeRespuestas mejorarExclusividad();
    public void agregarRespuesta(Respuesta respuesta);
}