package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.MultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.MultipleChoicePuntajeParcial;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta;
import edu.fiuba.algo3.vista.VistaPreguntaClasica;
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

        //Test de integracion 1-3
        String enunciado = "¿Quién está toooodo de ooooro?";

        String opcion1 = "El Chino";
        String opcion2 = "Duko";
        String opcion3 = "El Truenito pai";
        String opcion4 = "Aczino";
        String opcion5 = "Ysy A";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion5);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);


        TipoDePregunta tipoMultipleChoicePenalidad = new MultipleChoiceConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoicePenalidad);
        pregunta.mostrar();


    }

    public static void main(String[] args) {
        launch();
    }

}