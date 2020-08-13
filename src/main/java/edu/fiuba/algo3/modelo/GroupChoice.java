package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;

public class GroupChoice extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE = 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public GroupChoice(List<Opcion> solucion){
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
  
    @Override
    public boolean esCorrecta(Eleccion eleccion){return this.esUnaEleccionCorrecta(eleccion);}

    public static GroupChoice recuperar(JsonObject jsonObjectSolucion){

        List<Opcion> opciones = new ArrayList<Opcion>();
        JsonArray arrayOpciones = jsonObjectSolucion.getAsJsonArray("solucion");
        for (JsonElement jsonOpcion : arrayOpciones) {
            Opcion opcion = OpcionDeGrupo.recuperar(jsonOpcion.getAsJsonObject());
            opciones.add(opcion);
        }
        GroupChoice groupChoice = new GroupChoice(opciones);
        return groupChoice;
    }
}
