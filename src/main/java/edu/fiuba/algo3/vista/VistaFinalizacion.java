package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Tabla;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class VistaFinalizacion {
    private List<Jugador> jugadores;
    public VistaFinalizacion(Tabla tabla) {
        this.jugadores = tabla.jugadores();
    }

    public Scene crearEscena() {
        TableView tableView = new TableView();


        TableColumn<String, Integer> column1 = new TableColumn<>("Nombre de jugador");
        TableColumn<String, Integer> column2 = new TableColumn<>("Puntos");

        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setCellValueFactory(new PropertyValueFactory<>("puntos"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        for(Jugador unJugador : jugadores){
            tableView.getItems().add(new VistaJugador(unJugador.getNombre(), unJugador.puntosTotales()));
        }

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        return scene;
    }
}
