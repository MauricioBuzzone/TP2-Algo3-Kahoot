package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial extends Pregunta {

    public MultipleChoicePuntajeParcial(String enunciado, Eleccion eleccion) {

        this.criterio = new CriterioMultipleChoiceParcial(eleccion);
        if(!(eleccion.esValidaParaElCriterio(criterio))){
            throw new SolucionInvalidaException();
        }
        this.enunciado = enunciado;
    }
}