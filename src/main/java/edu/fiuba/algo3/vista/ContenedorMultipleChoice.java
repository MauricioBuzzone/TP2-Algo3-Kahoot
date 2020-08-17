package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonOpcionComunEventHandler;
import edu.fiuba.algo3.controlador.BotonReiniciarOpcionesEventHandler;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class ContenedorMultipleChoice extends VBox{
    private static final int ESPACIADO_BOTONES = 15;
    private static final String REINICIAR = "Reiniciar";

    public ContenedorMultipleChoice(ControladorRespuesta controlador, List<String> descripciones){
        super();
        List<Button> botones = new ArrayList<Button>();

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
}
