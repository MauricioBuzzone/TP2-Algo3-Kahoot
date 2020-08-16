package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Eleccion;
import edu.fiuba.algo3.modelo.Bonificador;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class ControladorRespuesta implements EventHandler<ActionEvent> {

    private Stage stage;
    private Ronda rondaActiva;
    private List<Opcion> opcionesAlmacenadas;
    private Bonificador bonificador;

    public ControladorRespuesta(Stage stage, Ronda rondaActiva) {
        this.stage = stage;
        this.rondaActiva = rondaActiva;
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
        this.rondaActiva.jugadorYaRespondio();
        Eleccion eleccion = new Eleccion(opcionesAlmacenadas);
        Respuesta respuesta = new Respuesta(rondaActiva.getJugadorActivo(), eleccion, bonificador);
        rondaActiva.agregarRespuesta(respuesta);
    }
}