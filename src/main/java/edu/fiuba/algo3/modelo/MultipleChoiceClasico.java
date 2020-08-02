package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta {

    public MultipleChoiceClasico(String enunciado, Eleccion eleccion) {

        this.criterio = new CriterioMultipleChoiceClasico(eleccion);
        if(!(eleccion.esValidaParaElCriterio(criterio))){
            throw new SolucionInvalidaException();
        }
        this.enunciado = enunciado;
    }
}
