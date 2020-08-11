package edu.fiuba.algo3.modelo;

import java.util.List;


public class VerdaderoFalsoConPenalidad extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE= 1;
    private static final int PUNTAJE_DESFAVORABLE = 1;

    public VerdaderoFalsoConPenalidad(List<Opcion> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionUnica();

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        return this.evaluarEleccion(eleccion, PUNTAJE_FAVORABLE, PUNTAJE_DESFAVORABLE);
    }
}
