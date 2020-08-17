package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;

public class BotonOpcionDeGrupoEventHandler implements EventHandler<ActionEvent> {

    private SplitMenuButton menuDeGruposAsociado;
    private ControladorRespuesta controladorRespuesta;
    private MenuItem itemAsociado;

    public BotonOpcionDeGrupoEventHandler(ControladorRespuesta controlador, SplitMenuButton menuDeGruposAsociado, MenuItem itemAsociado){
        this.menuDeGruposAsociado =menuDeGruposAsociado;
        this.controladorRespuesta= controlador;
        this.itemAsociado= itemAsociado;
    }
    public void handle(ActionEvent actionEvent) {
        menuDeGruposAsociado.setText(itemAsociado.getText());
        for(MenuItem item :menuDeGruposAsociado.getItems()) {
            item.setDisable(false);
        }
        itemAsociado.setDisable(true);
    }
}