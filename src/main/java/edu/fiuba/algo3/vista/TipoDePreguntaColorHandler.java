package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.preguntas.*;


public class TipoDePreguntaColorHandler {

    private static final String COLOR_BACKGROUND_VERDADERO_FALSO = "-fx-background-color: #8BC34A; ";
    private static final String COLOR_BACKGROUND_VERDADERO_FALSO_PENALIDAD = "-fx-background-color: #689f38; ";
    private static final String COLOR_BACKGROUND_MULTIPLE_CHOICE_CLASICO = "-fx-background-color: #D6352F; ";
    private static final String COLOR_BACKGROUND_MULTIPLE_CHOICE_PENALIDAD = "-fx-background-color: #EE6E15; ";
    private static final String COLOR_BACKGROUND_MULTIPLE_CHOICE_PARCIAL = "-fx-background-color: #E3513D; ";
    private static final String COLOR_BACKGROUND_ORDERED_CHOICE = "-fx-background-color: #79A6D9; ";
    private static final String COLOR_BACKGROUND_GROUP_CHOICE = "-fx-background-color: #D48BF3; ";
    private static final String COLOR_BACKGROUND_DEFAULT = "-fx-background-color: #009688; ";

    private static final String COLOR_BOTON_VERDADERO_FALSO = "-fx-background-color: #DCEDC8; ";
    private static final String COLOR_BOTON_VERDADERO_FALSO_PENALIDAD = "-fx-background-color: #8BC34A; ";
    private static final String COLOR_BOTON_MULTIPLE_CHOICE_CLASICO = "-fx-background-color: #EB4C46; ";
    private static final String COLOR_BOTON_MULTIPLE_CHOICE_PENALIDAD = "-fx-background-color: #F9914A; ";
    private static final String COLOR_BOTON_MULTIPLE_CHOICE_PARCIAL = "-fx-background-color: #FA7E51; ";
    private static final String COLOR_BOTON_ORDERED_CHOICE = "-fx-background-color: #D2FAF5; ";
    private static final String COLOR_BOTON_GROUP_CHOICE = "-fx-background-color: #E4B4F1; ";

    private static final String COLOR_BOTON_DEFAULT = "-fx-background-color: #979A93; ";

    public static final String COLOR_BOTON_BLANCO = "-fx-background-color: #FFFFFF; ";
    public static final String COLOR_BOTON_NEGRO = "-fx-background-color: #000000; -fx-text-fill: #ffffff; ";

    public String colorBackground(TipoDePregunta tipoDePregunta){
        if(tipoDePregunta.getClass() == VerdaderoFalso.class){
            return COLOR_BACKGROUND_VERDADERO_FALSO;
        }else if(tipoDePregunta.getClass() == VerdaderoFalsoConPenalidad.class){
            return COLOR_BACKGROUND_VERDADERO_FALSO_PENALIDAD;
        }else if(tipoDePregunta.getClass() == MultipleChoiceClasico.class){
            return COLOR_BACKGROUND_MULTIPLE_CHOICE_CLASICO;
        }else if(tipoDePregunta.getClass() == MultipleChoiceConPenalidad.class) {
            return COLOR_BACKGROUND_MULTIPLE_CHOICE_PENALIDAD;
        }else if(tipoDePregunta.getClass() == MultipleChoicePuntajeParcial.class) {
            return COLOR_BACKGROUND_MULTIPLE_CHOICE_PARCIAL;
        }else if(tipoDePregunta.getClass() == OrderedChoice.class) {
            return COLOR_BACKGROUND_ORDERED_CHOICE;
        }else if (tipoDePregunta.getClass() == GroupChoice.class ) {
            return COLOR_BACKGROUND_GROUP_CHOICE;
        }else{
            return COLOR_BACKGROUND_DEFAULT;
        }
    }

    public String colorBoton(TipoDePregunta tipoDePregunta){
        if(tipoDePregunta.getClass() == VerdaderoFalso.class){
            return COLOR_BOTON_VERDADERO_FALSO;
        }else if(tipoDePregunta.getClass() == VerdaderoFalsoConPenalidad.class){
            return COLOR_BOTON_VERDADERO_FALSO_PENALIDAD;
        }else if(tipoDePregunta.getClass() == MultipleChoiceClasico.class){
            return COLOR_BOTON_MULTIPLE_CHOICE_CLASICO;
        }else if(tipoDePregunta.getClass() == MultipleChoiceConPenalidad.class) {
            return COLOR_BOTON_MULTIPLE_CHOICE_PENALIDAD;
        }else if(tipoDePregunta.getClass() == MultipleChoicePuntajeParcial.class) {
            return COLOR_BOTON_MULTIPLE_CHOICE_PARCIAL;
        }else if(tipoDePregunta.getClass() == OrderedChoice.class) {
            return COLOR_BOTON_ORDERED_CHOICE;
        }else if (tipoDePregunta.getClass() == GroupChoice.class ) {
            return COLOR_BOTON_GROUP_CHOICE;
        }else{
            return COLOR_BOTON_DEFAULT;
        }

    }

}