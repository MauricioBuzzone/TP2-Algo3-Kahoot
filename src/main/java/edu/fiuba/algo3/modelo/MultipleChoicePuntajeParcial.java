package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial extends Pregunta {

    public MultipleChoicePuntajeParcial(String enunciado, Eleccion eleccion) {

        if(eleccion.cantidadDeOpciones() <= 0 || eleccion.cantidadDeOpciones() > 5){
            throw new SolucionInvalidaException();
        }
        this.criterio = new CriterioMultipleChoiceParcial(eleccion);
        this.enunciado = enunciado;
    }
}