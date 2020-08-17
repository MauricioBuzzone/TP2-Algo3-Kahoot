package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonOpcionComunEventHandler;
import edu.fiuba.algo3.controlador.BotonReiniciarOpcionesEventHandler;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;


import java.util.ArrayList;
import java.util.List;

public class ContenedorMultipleChoice extends VBox{
    private static final int ESPACIADO_BOTONES = 15;
    private static final String REINICIAR = "Reiniciar";

    public ContenedorMultipleChoice(ControladorRespuesta controlador, List<Opcion> opciones){
        super();
        List<Button> botones = new ArrayList<Button>();
        List<String> descripciones = this.descripcionesDeOpciones(opciones);

        for(String descripcion : descripciones){
            Button boton = new Button();
            boton.setText(descripcion);
            boton.setOnAction(new BotonOpcionComunEventHandler(controlador, descripcion, boton));
            botones.add(boton);
        }

        Button botonReiniciar = new Button();
        botonReiniciar.setText(REINICIAR);
        botonReiniciar.setOnAction(new BotonReiniciarOpcionesEventHandler(controlador, botones));
        botones.add(botonReiniciar);

        this.getChildren().addAll(botones);
        this.setSpacing(ESPACIADO_BOTONES);
    }

    private List<String> descripcionesDeOpciones(List<Opcion> opciones){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }
}
