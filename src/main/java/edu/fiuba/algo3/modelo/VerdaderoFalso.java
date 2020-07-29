package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(String enunciado, Eleccion eleccion) {
        this.criterio = new CriterioVerdaderoFalso(eleccion);
        this.enunciado = enunciado;
    }
}