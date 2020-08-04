package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class TipoDePregunta implements Evaluador,Mostrable{
    protected Eleccion eleccionCorrecta;

    public void responderPregunta(Respuesta respuesta) {
        respuesta.responderSegunEvaluador(this);
    }

    public Eleccion crearEleccion(List<String> opciones) {
        return new Eleccion(opciones);
    }
}
