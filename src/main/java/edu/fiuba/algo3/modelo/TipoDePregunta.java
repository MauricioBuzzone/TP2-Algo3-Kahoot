package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.VistaPreguntaClasica;

import java.util.List;

public abstract class TipoDePregunta implements Evaluador{
    protected Eleccion eleccionCorrecta;

    public void responderPregunta(Respuesta respuesta) {
        respuesta.responderSegunEvaluador(this);
    }

    @Override
    public boolean sonOpcionesCorrectas(List<String> unasOpciones){
        Eleccion eleccion = new Eleccion(unasOpciones);
        return eleccion.igualA(this.eleccionCorrecta);
    }


    public void mostrar(String enunciado, List<String> opciones){
        VistaPreguntaClasica vista = new VistaPreguntaClasica(enunciado, opciones);
        vista.mostrar();
    }

}
