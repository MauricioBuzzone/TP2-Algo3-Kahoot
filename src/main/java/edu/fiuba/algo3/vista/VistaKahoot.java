package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.controlador.BotonProximoJugadorEventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;


public class VistaKahoot implements Observer{

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 350;
    private static final int ESPACIADO = 30;

    private Kahoot kahoot;
    private Stage stage;
    private VistaRonda vistaRonda;
    private Ronda rondaAnterior = null;

    public VistaKahoot(Stage stage, Kahoot kahoot, VistaRonda vistaRonda){
        this.kahoot = kahoot;
        this.stage = stage;
        this.vistaRonda = vistaRonda;
    }

    @Override
    public void update(Observable o, Object arg){
        Ronda rondaActiva = kahoot.getRondaActiva();
        if(rondaActiva != rondaAnterior){
            rondaAnterior = rondaActiva;
            this.vistaRonda.cambiarRondaActiva(rondaActiva);
            Scene escena = crearEscenaRonda(rondaActiva);
            stage.setScene(escena);
        }else{
            Scene escena = crearEscenaTabla();
            stage.setScene(escena);
        }
    }

    private Scene crearEscenaRonda(Ronda ronda){
        Label titulo = new Label("**Se muestra de lo que va a tratar la ronda**");
        Button avanzarATurno = new Button();
        avanzarATurno.setText("Avanzar");
        avanzarATurno.setOnAction(new BotonProximoJugadorEventHandler(ronda));
        VBox contenedorPrincipal = new VBox(titulo, avanzarATurno);
        contenedorPrincipal.setSpacing(ESPACIADO);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }
    private Scene crearEscenaTabla(){

        Label titulo = new Label("Puntaje final");
        TableView tableView = new TableView();
        TableColumn<String, Integer> column1 = new TableColumn<>("Nombre de jugador");
        TableColumn<String, Integer> column2 = new TableColumn<>("Puntos Totales");

        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setCellValueFactory(new PropertyValueFactory<>("puntos"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        for(Jugador jugador: kahoot.terminarJuego()){
            tableView.getItems().add(jugador);
        }
        VBox contenedorPrincipal = new VBox(titulo, tableView);
        contenedorPrincipal.setSpacing(ESPACIADO);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

}