package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
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
        Label titulo = new Label("Turno de " + jugadorActivo.getNombre() + " buena suerte ");
        Button comenzarTurno = new Button();
        comenzarTurno.setText("Jugar");


        FactoryEscenas factory = new FactoryEscenas(stage, rondaActiva);
        Scene escenaProxima = factory.crearEscenaPregunta();

        comenzarTurno.setOnAction(new BotonAvanzarATurnoEventHandler(this.stage, escenaProxima));
        VBox contenedorPrincipal = new VBox(titulo, comenzarTurno);
        contenedorPrincipal.setSpacing(30);
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