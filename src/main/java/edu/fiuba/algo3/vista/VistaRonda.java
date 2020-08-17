package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.*;
import java.util.ArrayList;


import java.util.Observable;
import java.util.Observer;


public class VistaRonda implements Observer {

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 350;
    private static final int ESPACIADO = 30;

    private Ronda rondaActiva;
    private Stage stage;
    private Button botonAvanzarRonda;
    private Jugador jugadorAnterior;
    private Queue<Jugador> jugadores;


    public VistaRonda(Stage stage, Ronda rondaActiva, Button botonAvanzarRonda) {
        this.rondaActiva = rondaActiva;
        this.stage = stage;
        this.botonAvanzarRonda = botonAvanzarRonda;
        this.jugadorAnterior = null;
        this.jugadores = new LinkedList<Jugador>();

    }

    @Override
    public void update(Observable o, Object arg) {

        Jugador jugadorActivo = rondaActiva.getJugadorActivo();
        if(jugadorActivo != jugadorAnterior){
            jugadores.add(jugadorActivo);
            jugadorAnterior = jugadorActivo;
            Scene escena = crearEscenaRonda(jugadorActivo);
            stage.setScene(escena);
        }else {
            jugadorAnterior = null;
            Scene escena = crearEscenaTabla();
            stage.setScene(escena);
        }
    }

    private Scene crearEscenaRonda(Jugador jugadorActivo) {

        Label titulo = new Label("Turno de " + jugadorActivo.getNombre() + " buena suerte ");
        Button comenzarTurno = new Button();
        comenzarTurno.setText("Jugar");

        FactoryEscenas factory = new FactoryEscenas(stage, rondaActiva);
        Scene escenaProxima = factory.crearEscenaPregunta();

        comenzarTurno.setOnAction(new BotonComenzarTurnoEventHandler(this.stage, escenaProxima, rondaActiva));
        VBox contenedorPrincipal = new VBox(titulo, comenzarTurno);
        contenedorPrincipal.setSpacing(ESPACIADO);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }


    private Scene crearEscenaTabla() {
        Label titulo = new Label("Información de los puntajes de la ronda previa.");

        TableView tableView = new TableView();
        TableColumn<String, Integer> column1 = new TableColumn<>("Nombre de jugador");
        TableColumn<String, Integer> column2 = new TableColumn<>("Puntos");

        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setCellValueFactory(new PropertyValueFactory<>("ultimoPuntaje"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        while(!jugadores.isEmpty()){
            tableView.getItems().add(jugadores.poll());
        }

        VBox contenedorPrincipal = new VBox(titulo, tableView, botonAvanzarRonda);
        contenedorPrincipal.setSpacing(ESPACIADO);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);

    }

    public void cambiarRondaActiva(Ronda rondaActiva){
        this.rondaActiva = rondaActiva;
    }
}