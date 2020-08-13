package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;

public class OrderedChoice extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE= 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 2;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public OrderedChoice(List<Opcion> solucion){

        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionesMultiples(CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS,CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        return this.evaluarEleccion(eleccion, PUNTAJE_FAVORABLE, PUNTAJE_DESFAVORABLE);
    }

    public static OrderedChoice recuperar(JsonObject jsonObjectSolucion){

        List<Opcion> opciones = new ArrayList<Opcion>();
        JsonArray arrayOpciones = jsonObjectSolucion.getAsJsonArray("solucion");
        for (JsonElement jsonOpcion : arrayOpciones) {
            Opcion opcion = OpcionOrdenada.recuperar(jsonOpcion.getAsJsonObject());
            opciones.add(opcion);
        }
        OrderedChoice orderedChoice = new OrderedChoice(opciones);
        return orderedChoice;
    }
}