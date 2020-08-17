package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonOpcionDeGrupoEventHandler;
import edu.fiuba.algo3.controlador.BotonReiniciarOpcionesEventHandler;


import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;
import java.util.ArrayList;
import java.util.List;

public class ContenedorGroupChoice extends VBox {
    private static final int ESPACIADO_BOTONES = 15;
    private static final String REINICIAR = "Reiniciar";

    public ContenedorGroupChoice(ControladorRespuesta controlador, List<Opcion> opciones) {
        super();
        List<HBox> contenedoresOpciones = new ArrayList<HBox>();
        List<String> descripciones = this.descripcionesDeOpciones(opciones);
        List<String> grupos = this.grupoDeOpciones(opciones);

        for (String descripcion : descripciones) {
            HBox opcion = new HBox();
            Label labelDescripcion = new Label(descripcion);
            SplitMenuButton menuDeGrupos = this.crearMenuDeGrupos(controlador,grupos, descripcion);
            opcion.getChildren().addAll(labelDescripcion,menuDeGrupos);
            contenedoresOpciones.add(opcion);
            opcion.setSpacing(5);
        }
        this.getChildren().addAll(contenedoresOpciones);
        this.setSpacing(40);
    }

    private SplitMenuButton crearMenuDeGrupos(ControladorRespuesta controlador,List<String> grupos, String descripcion){
        SplitMenuButton menuDeGrupos = new SplitMenuButton();
        menuDeGrupos.setText("Grupo");

        for(String grupo: grupos){
            MenuItem opcionGrupo = new MenuItem(grupo);

            opcionGrupo.setOnAction(new BotonOpcionDeGrupoEventHandler(controlador, menuDeGrupos, opcionGrupo,descripcion));
            menuDeGrupos.getItems().add(opcionGrupo);
        }
        return menuDeGrupos;
    }

    private List<String> descripcionesDeOpciones(List<Opcion> opciones) {
        List<String> descripciones = new ArrayList<String>();
        for (Opcion opcion : opciones) {
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }

    private List<String> grupoDeOpciones(List<Opcion> opciones) {
        List<String> grupos = new ArrayList<String>();
        for (Opcion opcion : opciones) {
            if(!grupos.contains(((OpcionDeGrupo) opcion).getGrupo())) {
                grupos.add(((OpcionDeGrupo) opcion).getGrupo());
            }
        }
        return grupos;
    }
}