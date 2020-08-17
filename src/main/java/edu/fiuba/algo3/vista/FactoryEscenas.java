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
        List<String> descripciones = this.descripcionesDeOpciones(opciones);

        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        TipoDePregunta tipo = pregunta.getTipoDePregunta();

        VBox contenedorPrincipal = new VBox();
        VBox contenedorDeOpciones = this.crearContenedorDeOpciones(tipo, descripciones, controlador);

        VBox contenedorVerticalDerecho = this.contenedorVerticalDerecho(tipo, controlador);
        contenedorVerticalDerecho.setSpacing(200);

        HBox contenedorHorizontal = new HBox(contenedorDeOpciones, contenedorVerticalDerecho);
        contenedorHorizontal.setSpacing(200);

        contenedorPrincipal.getChildren().addAll(new Label(enunciado), contenedorHorizontal);
        contenedorPrincipal.setSpacing(20);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private VBox crearContenedorDeOpciones(TipoDePregunta tipo, List<String> descripciones, ControladorRespuesta controlador){

        if(tipo.getClass() == VerdaderoFalso.class || tipo.getClass() == VerdaderoFalsoConPenalidad.class){
        return new ContenedorVerdaderoFalso(controlador);

        }else if(tipo.getClass() == MultipleChoiceClasico.class || tipo.getClass() == MultipleChoicePuntajeParcial.class || tipo.getClass() == MultipleChoiceConPenalidad.class){
            return new ContenedorMultipleChoice(controlador, descripciones);}
/*
        }else if(tipo.getClass() == OrderedChoice.class){
            return crearEscenaDeOrderedChoice(enunciado, descripciones);

        }else{//tipo.getClass() == GroupChoice.class
            return crearEscenaDeGroupChoice(enunciado, descripciones);

        }*/
        return null; //<-- a borrar
    }

    private VBox crearContenedorDeBonificadores(TipoDePregunta tipo, ControladorRespuesta controlador){
        if(tipo.getClass() == VerdaderoFalsoConPenalidad.class || tipo.getClass() == MultipleChoiceConPenalidad.class) {
            return new ContenedorBonificadores(controlador);
        }else{
            return new ContenedorExclusividad(controlador, rondaActiva.getJugadorActivo());
        }
    }

    private List<String> descripcionesDeOpciones(List<Opcion> opciones){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }

    private VBox contenedorVerticalDerecho(TipoDePregunta tipo, ControladorRespuesta controlador){
        VBox contenedorDeBonificadores = this.crearContenedorDeBonificadores(tipo, controlador);
        contenedorDeBonificadores.setSpacing(15);

        if(tipo.getClass() != VerdaderoFalso.class && tipo.getClass() != VerdaderoFalsoConPenalidad.class) {
            Button botonEnviar = new Button(ENVIAR);
            botonEnviar.setOnAction(controlador);
            return new VBox(contenedorDeBonificadores, botonEnviar);
        }

        return new VBox(contenedorDeBonificadores);
    }

}