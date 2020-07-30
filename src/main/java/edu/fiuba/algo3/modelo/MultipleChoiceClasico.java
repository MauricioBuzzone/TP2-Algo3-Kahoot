package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta {

    public MultipleChoiceClasico(String enunciado, Eleccion eleccion) {

        if(eleccion.cantidadDeOpciones() <= 0 || eleccion.cantidadDeOpciones() > 5){
            throw new SolucionInvalidaException();
        }
        this.criterio = new CriterioMultipleChoiceClasico(eleccion);
        this.enunciado = enunciado;
    }
}
