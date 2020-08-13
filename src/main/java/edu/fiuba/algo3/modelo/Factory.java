package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import java.util.List;
import java.util.ArrayList;

public class Factory{

    public static TipoDePregunta crearTipoDePregunta(String tipoDePregunta, JsonObject jsonObjectPregunta){

        TipoDePregunta tipo=null;

        if(tipoDePregunta.equals("VerdaderoFalso")){
            tipo = VerdaderoFalso.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
        if(tipoDePregunta.equals("VerdaderoFalsoConPenalidad")){
            tipo = VerdaderoFalsoConPenalidad.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
        if(tipoDePregunta.equals("MultipleChoiceClasico")){
            tipo = MultipleChoiceClasico.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
        if(tipoDePregunta.equals("MultipleChoiceConPenalidad")){
            tipo = MultipleChoiceConPenalidad.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
        if(tipoDePregunta.equals("MultipleChoicePuntajeParcial")){
            tipo = MultipleChoicePuntajeParcial.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
        if(tipoDePregunta.equals("GroupChoice")){
            tipo = GroupChoice.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
        if(tipoDePregunta.equals("OrderedChoice")){
            tipo = OrderedChoice.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
        return tipo;
    }

    public static List<Opcion> crearOpciones(String tipoDePregunta, JsonArray arrayOpcion){

        List<Opcion> opciones = new ArrayList<Opcion>();

        if(tipoDePregunta.equals("OrderedChoice")) {
            for (JsonElement jsonOpcion : arrayOpcion) {
                Opcion opcion = OpcionOrdenada.recuperar(jsonOpcion.getAsJsonObject());
                opciones.add(opcion);
            }
        }
        else if(tipoDePregunta.equals("GroupChoice")){
            for (JsonElement jsonOpcion : arrayOpcion) {
                Opcion opcion = OpcionDeGrupo.recuperar(jsonOpcion.getAsJsonObject());
                opciones.add(opcion);
            }
        }
        else{
            for (JsonElement jsonOpcion : arrayOpcion) {
                Opcion opcion = OpcionComun.recuperar(jsonOpcion.getAsJsonObject());
                opciones.add(opcion);
            }
        }
        return opciones;
    }
}