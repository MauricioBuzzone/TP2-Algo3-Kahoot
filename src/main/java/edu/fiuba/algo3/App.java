package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;


        String enunciado = "¿Aprobamos la entrega2?";

        String opcion1 = "Re sí";
        String opcion2 = "Se... ponele";
        String opcion3 = "Mmm vs dsis";
        String opcion4 = "Desaproba2 lince";
        String opcion5 = "Recursan gente, los esperan en Derecho";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion4);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion5);
        opciones.add(opcion4);
        opciones.add(opcion3);
        opciones.add(opcion2);
        opciones.add(opcion1);


        TipoDePregunta tipoDePregunta = new MultipleChoiceClasico(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoDePregunta);
        pregunta.mostrar();


    }

    public static void main(String[] args) {
        launch();
    }

}