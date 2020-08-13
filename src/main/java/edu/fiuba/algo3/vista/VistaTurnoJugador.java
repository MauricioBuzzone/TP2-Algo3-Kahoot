package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.BotonAvanzarAResponderPreguntaEventHandler;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;



public class VistaTurnoJugador {
    private Kahoot kahoot;
    private Stage stage;
    private Scene scene;

    public VistaTurnoJugador(Kahoot kahoot, Stage stage) {
        this.kahoot = kahoot;
        this.stage = stage;
        this.scene = this.crearEscena();
    }

    private Scene crearEscena() {
        if(kahoot.haySiguienteJugador()){
            System.out.println("Entré al if");
            kahoot.siguienteJugador();
            Jugador jugador = kahoot.getJugador();
            return crearEscenaVistaLobbyJugador(kahoot, jugador);
        }else{// if (kahoot.haySiguienteRonda()){
            System.out.println("Entré al else");
            kahoot.siguienteRonda();
            return this.crearEscena();
        }/*else{
            VistaFinalizacion vista = new VistaFinalizacion(stage, kahoot);
            return vista.crearEscena();
        }*/
    }
    private Scene crearEscenaVistaLobbyJugador(Kahoot kahoot, Jugador jugador){
        Label titulo = new Label("Turno de " + jugador.getNombre());
        Button botonResponderPregunta = new Button();
        botonResponderPregunta.setText("Responder pregunta");
        botonResponderPregunta.setOnAction(new BotonAvanzarAResponderPreguntaEventHandler(stage, kahoot));
        VBox contenedorPrincipal = new VBox(titulo, botonResponderPregunta);
        contenedorPrincipal.setSpacing(30);
        return new Scene(contenedorPrincipal, 300, 250);

    }


    public void mostrar() {
        System.out.println(stage == null);
        stage.setScene(scene);
    }
}
