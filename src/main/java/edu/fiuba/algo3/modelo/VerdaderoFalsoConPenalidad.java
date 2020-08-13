package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;

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

    public static VerdaderoFalsoConPenalidad recuperar(JsonArray jsonArraySolucion){

        List<Opcion> opciones = Factory.crearOpciones("VerdaderoFalsoConPenalidad",jsonArraySolucion);
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opciones);
        return verdaderoFalsoConPenalidad;
    }
}
