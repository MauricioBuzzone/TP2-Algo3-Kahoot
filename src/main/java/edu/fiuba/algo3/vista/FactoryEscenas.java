package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.vista.ContenedorVerdaderoFalso;
import edu.fiuba.algo3.vista.ContenedorMultipleChoice;
import edu.fiuba.algo3.vista.ContenedorBonificadores;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;

import static javafx.geometry.Pos.*;

public class FactoryEscenas {

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 350;
    private static final String ENVIAR = "Enviar";

    private Stage stage;
    private Ronda rondaActiva;
    public FactoryEscenas(Stage stage, Ronda rondaActiva){
        this.stage=stage;
        this.rondaActiva= rondaActiva;
    }

    public Scene crearEscenaPregunta() {

        Pregunta pregunta = rondaActiva.getPregunta();
        String enunciado = pregunta.getEnunciado();
        List<Opcion> opciones = pregunta.getOpciones();

        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        TipoDePregunta tipo = pregunta.getTipoDePregunta();

        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setAlignment(TOP_CENTER);
        VBox contenedorDeOpciones = this.crearContenedorDeOpciones(tipo, opciones, controlador);

        VBox contenedorVerticalDerecho = this.contenedorVerticalDerecho(tipo, controlador);
        contenedorVerticalDerecho.setSpacing(250);

        HBox contenedorHorizontal = new HBox(contenedorDeOpciones, contenedorVerticalDerecho);
        contenedorHorizontal.setSpacing(150);
        contenedorHorizontal.setAlignment(CENTER);

        contenedorPrincipal.getChildren().addAll(new Label(enunciado), contenedorHorizontal);
        contenedorPrincipal.setSpacing(20);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private VBox crearContenedorDeOpciones(TipoDePregunta tipo, List<Opcion> opciones, ControladorRespuesta controlador){
        VBox contenedorPreguntas = new VBox();
        if(esTipoVerdaderoFalso(tipo)){
            contenedorPreguntas = new  ContenedorVerdaderoFalso(controlador);

        }else if(esTipoMultipleChoice(tipo)){
            contenedorPreguntas = new ContenedorMultipleChoice(controlador, opciones);
/*
        }else if(esTipoOrderedChoice(tipo)){
            return crearEscenaDeOrderedChoice(enunciado, descripciones);
*/
        }else{//esTipoGroupChoice(tipo)
            contenedorPreguntas = new ContenedorGroupChoice(controlador, opciones);
        }
        return contenedorPreguntas;
    }

    private HBox crearContenedorDeBonificadores(TipoDePregunta tipo, ControladorRespuesta controlador){
        if(esTipoConPenalidad(tipo)) {
            return new ContenedorBonificadores(controlador, rondaActiva.getJugadorActivo());
        }else{
            return new ContenedorExclusividad(controlador, rondaActiva.getJugadorActivo());
        }
    }


    private VBox contenedorVerticalDerecho(TipoDePregunta tipo, ControladorRespuesta controlador){
        HBox contenedorDeBonificadores = this.crearContenedorDeBonificadores(tipo, controlador);
        contenedorDeBonificadores.setSpacing(15);

        if(tipo.getClass() != VerdaderoFalso.class && tipo.getClass() != VerdaderoFalsoConPenalidad.class) {
            Button botonEnviar = new Button(ENVIAR);
            botonEnviar.setOnAction(controlador);
            return new VBox(contenedorDeBonificadores, botonEnviar);
        }

        return new VBox(contenedorDeBonificadores);
    }

    private boolean esTipoVerdaderoFalso(TipoDePregunta tipo){
        return (tipo.getClass() == VerdaderoFalso.class || tipo.getClass() == VerdaderoFalsoConPenalidad.class);
    }

    private boolean esTipoMultipleChoice(TipoDePregunta tipo){
        return (tipo.getClass() == MultipleChoiceClasico.class ||
                tipo.getClass() == MultipleChoicePuntajeParcial.class ||
                tipo.getClass() == MultipleChoiceConPenalidad.class);
    }

    private boolean esTipoOrderedChoice(TipoDePregunta tipo) {
        return tipo.getClass() == OrderedChoice.class;
    }

    private boolean esTipoGroupChoice(TipoDePregunta tipo){
        return tipo.getClass() == GroupChoice.class;
    }

    private boolean esTipoConPenalidad(TipoDePregunta tipo){
        return (tipo.getClass() == VerdaderoFalsoConPenalidad.class || tipo.getClass() == MultipleChoiceConPenalidad.class);
    }
}