package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.controlador.*;
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

    private Ronda rondaActiva;
    private Stage stage;
    private Button botonFinal;
    private Jugador jugadorAnterior = null;
    private Queue<Jugador> jugadores;

    public VistaRonda(Stage stage, Ronda rondaActiva, Button botonFinal) {
        this.rondaActiva = rondaActiva;
        this.stage = stage;
        this.botonFinal = botonFinal;
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
            Scene escena = crearEscenaTabla();
            stage.setScene(escena);
        }
    }

    private Scene crearEscenaRonda(Jugador jugadorActivo) {
        Label titulo = new Label("Información sobre el jugador que está por venir " + jugadorActivo.getNombre());
        Button avanzarATurno = new Button();
        avanzarATurno.setText("Avanzar");

        List<Opcion> opciones = rondaActiva.getOpciones();
        List<String> descripciones = this.descripcionesAPartirDeOpciones(opciones);
        String enunciado = rondaActiva.getEnunciado();

        Scene escenaProxima = this.crearEscenaDeVerdaderoFalso(enunciado, descripciones);

        avanzarATurno.setOnAction(new BotonAvanzarATurnoEventHandler(this.stage, escenaProxima, rondaActiva));
        VBox contenedorPrincipal = new VBox(titulo, avanzarATurno);
        contenedorPrincipal.setSpacing(30);
        return new Scene(contenedorPrincipal, 300, 250);
    }

    private List<String> descripcionesAPartirDeOpciones(List<Opcion> opciones){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }


    private Scene crearEscenaDeVerdaderoFalso(String enunciado, List<String> opciones){
        String titulo = "Verdadero Falso";

        ControladorRespuesta controlador = new ControladorRespuesta(stage, rondaActiva);

        Button botonVerdadero = new Button();
        botonVerdadero.setText(opciones.get(0));
        botonVerdadero.setOnAction(new BotonOpcionComunEventHandler(controlador, opciones.get(0)));

        Button botonFalso = new Button();
        botonFalso.setText(opciones.get(1));
        botonFalso.setOnAction(new BotonOpcionComunEventHandler(controlador, opciones.get(1)));

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        HBox contenedorBotones = new HBox(botonVerdadero, botonFalso);
        contenedorBotones.setSpacing(20);
        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), contenedorBotones, botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, 350, 300);
    }

    private Scene crearEscenaTabla() {
        Label titulo = new Label("Información de todos los participantes de la ronda previa.");
        TableView tableView = new TableView();
        TableColumn<String, Integer> column1 = new TableColumn<>("Nombre de jugador");
        TableColumn<String, Integer> column2 = new TableColumn<>("Puntos");

        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setCellValueFactory(new PropertyValueFactory<>("puntos"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        while(!jugadores.isEmpty()){
            tableView.getItems().add(jugadores.poll());
        }

        VBox contenedorPrincipal = new VBox(titulo, tableView, botonFinal);
        contenedorPrincipal.setSpacing(30);
        return new Scene(contenedorPrincipal, 300, 250);

    }


    public void cambiarRondaActiva(Ronda rondaActiva){
        this.rondaActiva = rondaActiva;
    }
}