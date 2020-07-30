package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso extends Pregunta {


    public VerdaderoFalso(String enunciado, Eleccion eleccion) {
        if(eleccion.cantidadDeOpciones() != 1){
            throw new SolucionInvalidaException();
        }
        this.criterio = new CriterioVerdaderoFalso(eleccion);
        this.enunciado = enunciado;
    }
}