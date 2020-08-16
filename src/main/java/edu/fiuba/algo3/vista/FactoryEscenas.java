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

    public Scene crearEscenaPregunta(){

        Pregunta pregunta = rondaActiva.getPregunta();
        String enunciado = pregunta.getEnunciado();
        List<Opcion> opciones = pregunta.getOpciones();
        List<String> descripciones = this.descripcionesDeOpciones(opciones);

        return crearEscenaDeVerdaderoFalso(enunciado,descripciones);
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


    private List<String> descripcionesDeOpciones(List<Opcion> opciones){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }
}