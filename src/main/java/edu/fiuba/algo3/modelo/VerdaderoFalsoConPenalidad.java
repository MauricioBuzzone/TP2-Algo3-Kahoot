package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoConPenalidad extends Pregunta{

    public VerdaderoFalsoConPenalidad(String enunciado, Eleccion eleccion) {
        if(eleccion.cantidadDeOpciones() != 1){
            throw new SolucionInvalidaException();
        }
        this.criterio = new CriterioVerdaderoFalsoConPenalidad(eleccion);
        this.enunciado = enunciado;
    }
}