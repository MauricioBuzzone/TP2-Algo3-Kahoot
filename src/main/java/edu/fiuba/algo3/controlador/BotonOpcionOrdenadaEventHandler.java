package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

import java.util.List;

public class BotonOpcionOrdenadaEventHandler implements EventHandler<ActionEvent> {

    private SplitMenuButton menuDeIndicesAsociado;
    private ControladorRespuesta controladorRespuesta;
    private MenuItem itemAsociado;
    private OpcionOrdenada opcionAsociada;

    public BotonOpcionOrdenadaEventHandler(ControladorRespuesta controlador, SplitMenuButton menuDeIndicesAsociado,
                                           MenuItem itemAsociado, String descripcion) {

        this.menuDeIndicesAsociado = menuDeIndicesAsociado;
        this.opcionAsociada = new OpcionOrdenada(descripcion, Integer.parseInt(itemAsociado.getText()));
        this.controladorRespuesta = controlador;
        this.itemAsociado = itemAsociado;
    }


    public void handle(ActionEvent actionEvent) {

        menuDeIndicesAsociado.setText(itemAsociado.getText());
        for(MenuItem item :menuDeIndicesAsociado.getItems()) {
            item.setDisable(false);
        }
        itemAsociado.setDisable(true);

        controladorRespuesta.eliminarPorDescripcion(opcionAsociada);
        String descripcion = opcionAsociada.getDescripcion();

        controladorRespuesta.agregarOpcion(opcionAsociada);
    }
}
