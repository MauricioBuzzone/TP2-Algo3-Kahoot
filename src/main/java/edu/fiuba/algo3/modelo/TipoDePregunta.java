package edu.fiuba.algo3.modelo;

public abstract class TipoDePregunta implements Evaluador{
    protected Eleccion eleccionCorrecta;

    public void responderPregunta(Respuesta respuesta){
        respuesta.responderConEvaluador(this);
    }

}
