package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.*;

public class Pregunta {

    public static final int VERDADERO_FALSO = 1;
    public static final int VERDADERO_FALSO_CON_PENALIDAD = 2;
    public static final int MULTIPLE_CHOICE_CLASICO = 3;
    public static final int MULTIPLE_CHOICE_CON_PENALIDAD = 4;
    public static final int MULTIPLE_CHOICE_PUNTAJE_PARCIAL = 5;
    public static final int ORDERED_CHOICE = 6;
    public static final int GROUP_CHOICE = 7;

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

    public int tipoDePregunta(){
        if(this.tipo.getClass() == VerdaderoFalso.class){
            return VERDADERO_FALSO;
        }else if(this.tipo.getClass() == VerdaderoFalsoConPenalidad.class){
            return VERDADERO_FALSO_CON_PENALIDAD;
        }else if(this.tipo.getClass() == MultipleChoiceClasico.class){
            return MULTIPLE_CHOICE_CLASICO;
        }else if(this.tipo.getClass() == MultipleChoicePuntajeParcial.class){
            return MULTIPLE_CHOICE_PUNTAJE_PARCIAL;
        }else if(this.tipo.getClass() == MultipleChoiceConPenalidad.class){
            return MULTIPLE_CHOICE_CON_PENALIDAD;
        }else{
            return ORDERED_CHOICE;
        }
    }
    public static Pregunta recuperar(JsonObject jsonObjectPregunta){

        String enunciado = jsonObjectPregunta.get("enunciado").getAsString();
        String tipoDePregunta = jsonObjectPregunta.get("tipo").getAsString();

        TipoDePregunta tipo = Factory.crearTipoDePregunta(tipoDePregunta, jsonObjectPregunta);

        JsonArray arrayOpciones = jsonObjectPregunta.getAsJsonArray("opciones");
        List<Opcion> opciones = Factory.crearOpciones(tipoDePregunta ,arrayOpciones);


        Pregunta pregunta = new Pregunta(enunciado, opciones, tipo);

        return pregunta;
    }
}