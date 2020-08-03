package edu.fiuba.algo3.modelo;

public abstract class TipoDePregunta implements Evaluador,Mostrable{
    protected Eleccion eleccionCorrecta;

    public void responderPregunta(Respuesta respuesta) {
        respuesta.responderSegunEvaluador(this);
    }
}
