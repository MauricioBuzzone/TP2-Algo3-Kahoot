package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.List;

import static javafx.geometry.Pos.*;

public class FactoryEscenas {

    private static final String ENVIAR = "Enviar";
    private static final int ANCHO_LABEL_ENUNCIADO = 500;
    private static final int ALTO_LABEL_ENUNCIADO = 75;
    private static final int TAMANIO_FONT_ENUNCIADO = 20;
    private static final int TAMANIO_FONT_BOTON_ENVIAR = 20;
    private static final int MAXIMOS_CARACTERES_VISIBLES = 48;


    private Stage stage;
    private Ronda rondaActiva;
    private Reloj reloj;
    public FactoryEscenas(Stage stage, Ronda rondaActiva, Reloj reloj){
        this.stage=stage;
        this.rondaActiva= rondaActiva;
        this.reloj = reloj;
    }

    public Scene crearEscenaPregunta() {

        Pregunta pregunta = rondaActiva.getPregunta();
        String enunciado = pregunta.getEnunciado();
        String enunciadoCompleto = pregunta.getEnunciado();
        if(enunciado.length() > MAXIMOS_CARACTERES_VISIBLES){
            enunciadoCompleto = enunciado.substring(0, MAXIMOS_CARACTERES_VISIBLES) + "\n"
                                + enunciado.substring(MAXIMOS_CARACTERES_VISIBLES, enunciado.length());
        }
        List<Opcion> opciones = pregunta.getOpciones();

        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        TipoDePregunta tipo = pregunta.getTipoDePregunta();
        TipoDePreguntaColorHandler coloreador = new TipoDePreguntaColorHandler();

        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setAlignment(TOP_CENTER);
        VBox contenedorDeOpciones = this.crearContenedorDeOpciones(tipo, opciones, controlador, coloreador);

        VBox contenedorVerticalDerecho = this.contenedorVerticalDerecho(tipo, controlador);
        contenedorVerticalDerecho.setSpacing(50);

        HBox contenedorHorizontal = new HBox(contenedorDeOpciones, contenedorVerticalDerecho);
        contenedorHorizontal.setSpacing(80);
        contenedorHorizontal.setAlignment(CENTER);

        Label labelEnunciado = new Label(enunciadoCompleto);
        labelEnunciado.setPrefSize(ANCHO_LABEL_ENUNCIADO, ALTO_LABEL_ENUNCIADO);
        labelEnunciado.setFont(new Font(App.FUENTE, TAMANIO_FONT_ENUNCIADO));
        labelEnunciado.setAlignment(CENTER);
        contenedorPrincipal.getChildren().addAll(labelEnunciado, contenedorHorizontal);
        contenedorPrincipal.setSpacing(20);
        contenedorPrincipal.setStyle(coloreador.colorBackground(tipo));

        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);
    }

    private VBox crearContenedorDeOpciones(TipoDePregunta tipo, List<Opcion> opciones, ControladorRespuesta controlador, TipoDePreguntaColorHandler coloreador){
        VBox contenedorPreguntas = new VBox();
        String colorBoton = coloreador.colorBoton(tipo);
        if(esTipoVerdaderoFalso(tipo)){
            contenedorPreguntas = new  ContenedorVerdaderoFalso(controlador, colorBoton);

        }else if(esTipoMultipleChoice(tipo)){
            contenedorPreguntas = new ContenedorMultipleChoice(controlador, opciones, colorBoton);

        }else if(esTipoOrderedChoice(tipo)){
            contenedorPreguntas = new ContenedorDeOrderedChoice(controlador, opciones, colorBoton);

        }else if(esTipoGroupChoice(tipo)){
            contenedorPreguntas = new ContenedorGroupChoice(controlador, opciones ,colorBoton);
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
            botonEnviar.setStyle(TipoDePreguntaColorHandler.COLOR_BOTON_NEGRO);
            botonEnviar.setFont(new Font(App.FUENTE, TAMANIO_FONT_BOTON_ENVIAR));
            botonEnviar.setPrefSize(130,14);
            botonEnviar.setOnAction(controlador);
            return new VBox(reloj, contenedorDeBonificadores, botonEnviar);
        }

        return new VBox(reloj, contenedorDeBonificadores);
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