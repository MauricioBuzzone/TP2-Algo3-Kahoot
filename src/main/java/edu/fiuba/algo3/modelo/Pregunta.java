package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.*;

public class Pregunta {
    private TipoDePregunta tipo;
    private String enunciado;
    private List<Opcion> opciones;

    public Pregunta(String enunciado, List<Opcion> opciones, TipoDePregunta tipo){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
    }

    public void responderPregunta(Respuestas respuestas) {
        respuestas.responder(tipo);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getOpciones() {
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }

    public static Pregunta recuperar(JsonObject jsonObjectPregunta){


        String enunciado = jsonObjectPregunta.get("enunciado").getAsString();

        String tipoDePregunta = jsonObjectPregunta.get("tipo").getAsString();

        List<Opcion> opciones = new ArrayList<Opcion>();
        TipoDePregunta tipo=null;

        System.out.println(tipoDePregunta);

        if(tipoDePregunta == "VerdaderoFalso"){
            tipo = VerdaderoFalso.recuperar(jsonObjectPregunta.get("solucion").getAsJsonObject());
        }
        if(tipoDePregunta == "VerdaderoFalsoConPenalidad"){
            tipo = VerdaderoFalsoConPenalidad.recuperar(jsonObjectPregunta.get("solucion").getAsJsonObject());
        }
        if(tipoDePregunta == "MultipleChoiceClasico"){
            tipo = MultipleChoiceClasico.recuperar(jsonObjectPregunta.get("solucion").getAsJsonObject());
        }
        if(tipoDePregunta == "MultipleChoiceConPenalidad"){
            tipo = MultipleChoiceConPenalidad.recuperar(jsonObjectPregunta.get("solucion").getAsJsonObject());
        }
        if(tipoDePregunta == "MultipleChoicePuntajeParcial"){
            tipo = MultipleChoicePuntajeParcial.recuperar(jsonObjectPregunta.get("solucion").getAsJsonObject());
        }
        if(tipoDePregunta == "GroupChoice"){
            tipo = GroupChoice.recuperar(jsonObjectPregunta.get("solucion").getAsJsonObject());
        }
        if(tipoDePregunta == "OrderedChoice"){
            tipo = OrderedChoice.recuperar(jsonObjectPregunta.get("solucion").getAsJsonObject());
        }


        JsonArray arrayOpciones = jsonObjectPregunta.getAsJsonArray("opciones");
        for (JsonElement jsonOpcion : arrayOpciones) {
            Opcion opcion = OpcionComun.recuperar(jsonOpcion.getAsJsonObject());
            opciones.add(opcion);
        }

        Pregunta pregunta = new Pregunta(enunciado, opciones, tipo);

        return pregunta;
    }
}
