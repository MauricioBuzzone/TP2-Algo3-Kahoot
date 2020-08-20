package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.List;
import java.util.ArrayList;

public class FactoryTipoDePregunta{

    public TipoDePregunta crearTipoDePregunta(String tipoDePregunta, JsonObject jsonObjectPregunta){

        if(tipoDePregunta.equals("VerdaderoFalso")){
            return VerdaderoFalso.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());

        }else if(tipoDePregunta.equals("VerdaderoFalsoConPenalidad")){
            return VerdaderoFalsoConPenalidad.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());

        }else if(tipoDePregunta.equals("MultipleChoiceClasico")){
            return MultipleChoiceClasico.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());

        }else if(tipoDePregunta.equals("MultipleChoiceConPenalidad")){
            return MultipleChoiceConPenalidad.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());

        }else if(tipoDePregunta.equals("MultipleChoicePuntajeParcial")){
            return MultipleChoicePuntajeParcial.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());

        }else if(tipoDePregunta.equals("GroupChoice")){
            return GroupChoice.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());

        }else{//(tipoDePregunta.equals("OrderedChoice"))
            return OrderedChoice.recuperar(jsonObjectPregunta.get("solucion").getAsJsonArray());
        }
    }
}