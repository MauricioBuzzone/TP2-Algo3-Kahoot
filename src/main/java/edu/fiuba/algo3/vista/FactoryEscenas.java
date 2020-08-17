package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.vista.ContenedorVerdaderoFalso;
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

public class FactoryEscenas {

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 350;

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
        List<String> descripciones = this.descripcionesDeOpciones(opciones);

        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        TipoDePregunta tipo = pregunta.getTipoDePregunta();

        VBox contenedorPrincipal = new VBox();
        VBox contenedorDeOpciones = this.crearContenedorDeOpciones(tipo, descripciones, controlador);

        VBox contenedorDeBonificadores = this.crearContenedorDeBonificadores(tipo, controlador);
        contenedorDeBonificadores.setSpacing(15);

        HBox contenedorHorizontal = new HBox(contenedorDeOpciones, contenedorDeBonificadores);
        contenedorHorizontal.setSpacing(30);

        contenedorPrincipal.getChildren().addAll(new Label(enunciado), contenedorHorizontal);
        contenedorPrincipal.setSpacing(20);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private VBox crearContenedorDeOpciones(TipoDePregunta tipo, List<String> descripciones, ControladorRespuesta controlador){

        //if(tipo.getClass() == VerdaderoFalso.class){
        return new ContenedorVerdaderoFalso(controlador);
/*
        }else if(tipo.getClass() == VerdaderoFalsoConPenalidad.class){
            return crearEscenaDeVerdaderoFalsoConPenalidad(enunciado, descripciones);

        }else if(tipo.getClass() == MultipleChoiceClasico.class){
            return crearEscenaDeMultipleChoiceClasico(enunciado, descripciones);

        }else if(tipo.getClass() == MultipleChoicePuntajeParcial.class){
            return crearEscenaDeMultipleChoiceParcial(enunciado, descripciones);

        }else if(tipo.getClass() == MultipleChoiceConPenalidad.class){
            return crearEscenaDeMultipleChoiceConPenalidad(enunciado, descripciones);

        }else if(tipo.getClass() == OrderedChoice.class){
            return crearEscenaDeOrderedChoice(enunciado, descripciones);

        }else{//tipo.getClass() == GroupChoice.class
            return crearEscenaDeGroupChoice(enunciado, descripciones);

        }*/
    }

    private VBox crearContenedorDeBonificadores(TipoDePregunta tipo, ControladorRespuesta controlador){
        if(tipo.getClass() == VerdaderoFalsoConPenalidad.class || tipo.getClass() == MultipleChoiceConPenalidad.class) {
            return new ContenedorBonificadores(controlador);
        }else{
            return new ContenedorExclusividad(controlador, rondaActiva.getJugadorActivo());
        }
    }

    private Scene crearEscenaDeVerdaderoFalso(String enunciado, List<String> opciones){
        String titulo = "Verdadero Falso";

        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonVerdadero = new Button();
        botonVerdadero.setText(opciones.get(0));
        botonVerdadero.setOnAction(new BotonOpcionComunEventHandler(controlador, opciones.get(0)));

        Button botonFalso = new Button();
        botonFalso.setText(opciones.get(1));
        botonFalso.setOnAction(new BotonOpcionComunEventHandler(controlador, opciones.get(1)));

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        HBox contenedorBotones = new HBox(botonVerdadero, botonFalso);
        contenedorBotones.setSpacing(20);
        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), contenedorBotones, botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private Scene crearEscenaDeVerdaderoFalsoConPenalidad(String enunciado, List<String> opciones){
        String titulo = "Verdadero Falso con Penalidad";
        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private Scene crearEscenaDeMultipleChoiceClasico(String enunciado, List<String> opciones){
        String titulo = "Múltiple choice clásico";
        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private Scene crearEscenaDeMultipleChoiceParcial(String enunciado, List<String> opciones) {
        String titulo = "Múltiple choice de puntaje parcial";
        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private Scene crearEscenaDeMultipleChoiceConPenalidad(String enunciado, List<String> opciones) {
        String titulo = "Múltiple choice con penalidad";
        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private Scene crearEscenaDeOrderedChoice(String enunciado, List<String> opciones) {
        String titulo = "Ordered choice";
        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private Scene crearEscenaDeGroupChoice(String enunciado, List<String> opciones) {
        String titulo = "Group choice";
        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private List<String> descripcionesDeOpciones(List<Opcion> opciones){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }

}