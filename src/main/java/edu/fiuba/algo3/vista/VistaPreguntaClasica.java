package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class VistaPreguntaClasica {

    String enunciado;
    List<Button> botones;


    public VistaPreguntaClasica(String enunciado, List<String> opciones){

        this.enunciado = enunciado;
        this.botones = this.crearBotonesAPartirDe(opciones);

    }

    public void setBonificadores(){
        Button botonx2 = new Button();
        Button botonx3 = new Button();
        botonx2.setText("x2");
        botonx3.setText("x3");
        botones.add(botonx2);
        botones.add(botonx3);
    }

    public void mostrar(){

        VBox contenedorPrincipal = this.crearContenedorConOpciones();

        Scene scene = new Scene(contenedorPrincipal, 500, 250);

        App.stage.setScene(scene);
        App.stage.show();
    }

    private VBox crearContenedorConOpciones() {

        App.stage.setTitle("AlgoHoot - DEMO");
        Label etiqueta = new Label();
        Label enunciado = new Label();
        enunciado.setText(this.enunciado);

        List<HBox> cajasHorizontales = this.obtenerCajasHorizontalesDeOpcciones();

        VBox contenedorPrincipal = new VBox(enunciado, etiqueta);
        contenedorPrincipal.getChildren().addAll(cajasHorizontales);

        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        return contenedorPrincipal;
    }

    private List<HBox> obtenerCajasHorizontalesDeOpcciones() {

        List<HBox> cajasHorizontales = new ArrayList<HBox>();
        Stack<Button> unosBotones = new Stack<Button>();
        unosBotones.addAll(this.botones);
        while(unosBotones.size() > 1){
            cajasHorizontales.add(new HBox(10, unosBotones.pop(), unosBotones.pop()));
        }
        if(unosBotones.size() == 1){
            cajasHorizontales.add(new HBox(10, unosBotones.pop()));
        }
        return cajasHorizontales;
    }

    private List<Button> crearBotonesAPartirDe(List<String> opciones) {

        List<Button> botones = new ArrayList<Button>();
        for(String unaOpcion : opciones){
            Button boton = new Button();
            boton.setText(unaOpcion);
            botones.add(boton);
        }
        return botones;
    }

}
