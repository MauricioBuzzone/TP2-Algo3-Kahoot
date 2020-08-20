package edu.fiuba.algo3.controlador;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import java.util.List;


public class BotonEliminarJugadoresEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private ListView tabla;

    public BotonEliminarJugadoresEventHandler(TextField textField, ListView tablaJugadores) {
        this.textField = textField;
        this.tabla = tablaJugadores;
    }
    public void handle(ActionEvent actionEvent){
        String nombreJugadorNuevo = this.textField.getText();
        if(nombreJugadorNuevo.isEmpty()){
            Alert alertaNombreInvalido = new Alert(AlertType.INFORMATION);
            alertaNombreInvalido.setTitle("¡Nombre inválido!");
            alertaNombreInvalido.setHeaderText(null);
            alertaNombreInvalido.setContentText("Recuerde que no es válido ingresar nombres vacíos. \n Por favor, ingréselo nuevamente.");

            alertaNombreInvalido.showAndWait();
            return;
        }
        this.textField.setText("");
        this.textField.requestFocus();

        tabla.getItems().remove(nombreJugadorNuevo);

    }
}