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
import javafx.scene.control.Labeled;
import javafx.scene.text.Font;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;
import java.util.ArrayList;
import java.util.List;

public class ContenedorGroupChoice extends VBox {
    private static final int ESPACIADO_BOTONES = 15;

    public ContenedorGroupChoice(ControladorRespuesta controlador, List<Opcion> opciones) {
        super();
        List<HBox> contenedoresOpciones = new ArrayList<HBox>();
        List<String> descripciones = this.descripcionesDeOpciones(opciones);
        List<String> grupos = this.grupoDeOpciones(opciones);

        for (String descripcion : descripciones) {
            HBox opcion = new HBox();
            Label labelDescripcion = new Label(descripcion);
            labelDescripcion.setFont(new Font("Calabri", 24));
            SplitMenuButton menuDeGrupos = this.crearMenuDeGrupos(controlador,grupos, descripcion);
            menuDeGrupos.setPrefSize(110,18);
            menuDeGrupos.setFont(new Font("Calabir", 18));
            opcion.getChildren().addAll(labelDescripcion,menuDeGrupos);
            contenedoresOpciones.add(opcion);
            opcion.setSpacing(10);
        }
        this.getChildren().addAll(contenedoresOpciones);
        this.setSpacing(ESPACIADO_BOTONES);
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