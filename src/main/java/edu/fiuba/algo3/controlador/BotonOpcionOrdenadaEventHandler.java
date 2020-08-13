package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionOrdenada;

import edu.fiuba.algo3.vista.VistaTurnoJugador;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class BotonOpcionOrdenadaEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private ControladorRespuesta controladorRespuesta;
    private int indice;
    private Button boton;

    public BotonOpcionOrdenadaEventHandler(ControladorRespuesta controladorRespuesta,  TextField textField, int indice, Button boton) {
        this.controladorRespuesta = controladorRespuesta;
        this.textField = textField;
        this.indice = indice;
        this.boton = boton;
    }

    public void handle(ActionEvent actionEvent) {
        String descripcion = textField.getText();
        Opcion opcionUsuario = new OpcionOrdenada(descripcion, indice);
        controladorRespuesta.agregarOpcion(opcionUsuario);
        boton.setDisable(true);

    }
}