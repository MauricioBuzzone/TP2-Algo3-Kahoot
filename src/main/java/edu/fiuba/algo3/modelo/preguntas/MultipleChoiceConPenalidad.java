package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.SolucionInvalidaException;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.validadores.ValidadorOpcionesMultiples;
import edu.fiuba.algo3.modelo.FactoryOpciones;

public class MultipleChoiceConPenalidad extends TipoDePregunta {

    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public MultipleChoiceConPenalidad(List<Opcion> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionesMultiples(CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS, CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        int cantidadCorrectas = eleccionCorrecta.cantidadCoincidencias(eleccion);
        int cantidadIncorrectas = eleccionCorrecta.cantidadDeNoCoincidentes(eleccion);
        return this.evaluarEleccion(eleccion, cantidadCorrectas - cantidadIncorrectas, cantidadIncorrectas - cantidadCorrectas);
    }

    @Override
    protected boolean esUnaEleccionCorrecta(Eleccion eleccion){
        int cantidadCorrectas = eleccionCorrecta.cantidadCoincidencias(eleccion);
        int cantidadIncorrectas = eleccionCorrecta.cantidadDeNoCoincidentes(eleccion);
        return(cantidadCorrectas > cantidadIncorrectas);
    }

    public static MultipleChoiceConPenalidad recuperar(JsonArray jsonArraySolucion){

        FactoryOpciones factoryOpciones = new FactoryOpciones();
        List<Opcion> opciones = factoryOpciones.crearOpciones("MultipleChoiceClasico", jsonArraySolucion);
        return new MultipleChoiceConPenalidad(opciones);
    }
}
