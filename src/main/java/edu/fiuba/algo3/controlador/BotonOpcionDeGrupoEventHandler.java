package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;

public class BotonOpcionDeGrupoEventHandler implements EventHandler<ActionEvent> {

    private SplitMenuButton menuDeGruposAsociado;
    private ControladorRespuesta controladorRespuesta;
    private MenuItem itemAsociado;
    private OpcionDeGrupo opcionAsociada;

    public BotonOpcionDeGrupoEventHandler(ControladorRespuesta controlador, SplitMenuButton menuDeGruposAsociado,
                                          MenuItem itemAsociado, String descripcion){
        this.menuDeGruposAsociado =menuDeGruposAsociado;
        this.opcionAsociada = new OpcionDeGrupo(descripcion, itemAsociado.getText());
        this.controladorRespuesta= controlador;
        this.itemAsociado= itemAsociado;
    }

    public void handle(ActionEvent actionEvent) {
        this.actualizarMenu();
        controladorRespuesta.actualizarOpcionConDescripcionPor(opcionAsociada);
    }

    private void actualizarMenu(){
        menuDeGruposAsociado.setText(itemAsociado.getText());
        for(MenuItem item :menuDeGruposAsociado.getItems()) {
            item.setDisable(false);
        }
        itemAsociado.setDisable(true);
    }
}