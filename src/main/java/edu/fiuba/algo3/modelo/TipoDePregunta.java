package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class TipoDePregunta implements Evaluador,Mostrable{
    protected Eleccion eleccionCorrecta;

    public void responderPregunta(Respuesta respuesta) {
        respuesta.responderSegunEvaluador(this);
    }

    @Override
    public boolean sonOpcionesCorrectas(List<String> unasOpciones){
        Eleccion eleccion = new Eleccion(unasOpciones);
        return eleccion.igualA(this.eleccionCorrecta);
    }

}
