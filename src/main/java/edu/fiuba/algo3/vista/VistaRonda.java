package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
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


import java.util.Observable;
import java.util.Observer;


public class VistaRonda implements Observer {

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 350;

    private Ronda rondaActiva;
    private Stage stage;
    private Button botonAvanzarRonda;
    private Jugador jugadorAnterior;

    public VistaRonda(Stage stage, Ronda rondaActiva, Button botonAvanzarRonda) {
        this.rondaActiva = rondaActiva;
        this.stage = stage;
        this.botonAvanzarRonda = botonAvanzarRonda;
        this.jugadorAnterior = null;
    }

    @Override
    public void update(Observable o, Object arg) {

        Jugador jugadorActivo = rondaActiva.getJugadorActivo();
        if(jugadorActivo != jugadorAnterior){
            jugadorAnterior = jugadorActivo;
            Scene escena = crearEscenaRonda(jugadorActivo);
            stage.setScene(escena);
        }else {
            Scene escena = crearEscenaTabla();
            stage.setScene(escena);
        }
    }

    private Scene crearEscenaRonda(Jugador jugadorActivo) {
        Label titulo = new Label("Información sobre el jugador que está por venir" + jugadorActivo.getNombre());
        Button avanzarATurno = new Button();
        avanzarATurno.setText("Avanzar");

        List<Opcion> opciones = rondaActiva.getOpciones();
        List<String> descripciones = this.descripcionesAPartirDeOpciones(opciones);
        String enunciado = rondaActiva.getEnunciado();

        Scene escenaProxima = this.crearEscenaDeVerdaderoFalso(enunciado, descripciones);

        avanzarATurno.setOnAction(new BotonAvanzarATurnoEventHandler(this.stage, escenaProxima));
        VBox contenedorPrincipal = new VBox(titulo, avanzarATurno);
        contenedorPrincipal.setSpacing(30);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private List<String> descripcionesAPartirDeOpciones(List<Opcion> opciones){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
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

    private Scene crearEscenaTabla() {
        Label titulo = new Label("Información de todos los participantes de la ronda previa.");
        VBox contenedorPrincipal = new VBox(titulo, botonAvanzarRonda);
        contenedorPrincipal.setSpacing(30);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);

    }


    public void cambiarRondaActiva(Ronda rondaActiva){
        this.rondaActiva = rondaActiva;
    }
}