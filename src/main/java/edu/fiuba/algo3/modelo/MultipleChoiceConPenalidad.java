package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;

public class MultipleChoiceConPenalidad extends TipoDePregunta {

    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public MultipleChoiceConPenalidad(List<Opcion> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionesMultiples(CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS,CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);

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

    public static MultipleChoiceConPenalidad recuperar(JsonObject jsonObjectSolucion){

        List<Opcion> opciones = new ArrayList<Opcion>();
        JsonArray arrayOpciones = jsonObjectSolucion.getAsJsonArray("solucion");
        for (JsonElement jsonOpcion : arrayOpciones) {
            Opcion opcion = OpcionComun.recuperar(jsonOpcion.getAsJsonObject());
            opciones.add(opcion);
        }
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(opciones);
        return multipleChoiceConPenalidad;
    }
}
