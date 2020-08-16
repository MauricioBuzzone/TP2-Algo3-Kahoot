package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.List;
import java.util.ArrayList;

public class FactoryTipoDePregunta{

    public TipoDePregunta crearTipoDePregunta(String tipoDePregunta, JsonObject jsonObjectPregunta){

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
}