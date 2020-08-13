package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Eleccion;
import edu.fiuba.algo3.modelo.Bonificador;

import edu.fiuba.algo3.vista.VistaTurnoJugador;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class ControladorRespuesta implements EventHandler<ActionEvent> {

    private Stage stage;
    private Kahoot kahoot;
    private List<Opcion> opcionesAlmacenadas;
    private Bonificador bonificador;

    public ControladorRespuesta(Stage stage, Kahoot kahoot) {
        this.stage = stage;
        this.kahoot = kahoot;
        this.opcionesAlmacenadas = new ArrayList<Opcion>();
        this.bonificador = new Bonificador();
    }

    public void agregarOpcion(Opcion opcion){
        opcionesAlmacenadas.add(opcion);
    }

    public void setBonificador(Bonificador bonificador){
        this.bonificador = bonificador;
    }


    public void handle(ActionEvent actionEvent) {

        kahoot.jugadorYaRespondio();
        Eleccion eleccion = new Eleccion(opcionesAlmacenadas);
        Respuesta respuesta = new Respuesta(kahoot.getJugador(), eleccion, bonificador);
        kahoot.agregarRespuesta(respuesta);
        VistaTurnoJugador vista = new VistaTurnoJugador(kahoot, stage);
        vista.mostrar();
    }
}