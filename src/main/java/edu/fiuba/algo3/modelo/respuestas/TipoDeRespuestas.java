package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.preguntas.Evaluador;

public interface TipoDeRespuestas {
    public void responder(Evaluador evaluador);
    public TipoDeRespuestas mejorarExclusividad();
    public void agregarRespuesta(Respuesta respuesta);
}