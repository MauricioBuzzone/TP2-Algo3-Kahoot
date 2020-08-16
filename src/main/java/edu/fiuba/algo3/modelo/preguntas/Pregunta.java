package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.FactoryTipoDePregunta;
import edu.fiuba.algo3.modelo.FactoryOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuestas;

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

    public List<Opcion> getOpciones() {
        return opciones;
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

        FactoryTipoDePregunta factoryTipoDePregunta= new FactoryTipoDePregunta();
        TipoDePregunta tipo = factoryTipoDePregunta.crearTipoDePregunta(tipoDePregunta, jsonObjectPregunta);


        JsonArray arrayOpciones = jsonObjectPregunta.getAsJsonArray("opciones");
        FactoryOpciones factoryOpciones = new FactoryOpciones();
        List<Opcion> opciones = factoryOpciones.crearOpciones(tipoDePregunta ,arrayOpciones);

        Pregunta pregunta = new Pregunta(enunciado, opciones, tipo);
        return pregunta;
    }
}