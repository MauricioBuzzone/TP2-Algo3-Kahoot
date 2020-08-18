package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.VistaKahoot;
import edu.fiuba.algo3.vista.VistaRonda;
import edu.fiuba.algo3.modelo.Kahoot;


import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private ListView nombresJugadores;
    private String rutaKahoot;

    public BotonComenzarEventHandler(ListView jugadoresInscriptos, Stage stage, String rutaKahoot) {
        this.nombresJugadores = jugadoresInscriptos;
        this.stage = stage;
        this.rutaKahoot = rutaKahoot;
    }

    public void handle(ActionEvent actionEvent){

        List<Jugador> jugadores = this.obtenerJugadores();
        if(jugadores.isEmpty()){
            Alert alertaNombreInvalido = new Alert(AlertType.INFORMATION);
            alertaNombreInvalido.setTitle("Error");
            alertaNombreInvalido.setHeaderText(null);
            alertaNombreInvalido.setContentText("Debe haber al menos un Jugador para comenzar.");
            alertaNombreInvalido.showAndWait();
            return;
        }
        Kahoot kahoot = new Kahoot(jugadores, rutaKahoot);

        VistaRonda vistaRonda = this.asignarVistaRonda(kahoot);
        VistaKahoot vistaKahoot = new VistaKahoot(stage, kahoot, vistaRonda);
        kahoot.addObserver(vistaKahoot);
        kahoot.proximaRonda(); // Pone rondaActiva a la próxima ronda, en este caso la primera.
    }

    private List<Jugador> obtenerJugadores() {

        List<String> nombres =  this.nombresJugadores.getItems();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        for(String nombre : nombres){
            jugadores.add(new Jugador(nombre));
        }
        return jugadores;
    }

    private VistaRonda asignarVistaRonda(Kahoot kahoot) {
        List<Ronda> rondas = kahoot.getRondas();

        Button botonProximaRonda = new Button();
        botonProximaRonda.setOnAction(new BotonProximaRondaEventHandler(kahoot));
        VistaRonda vistaRonda = new VistaRonda(stage, rondas.get(0), botonProximaRonda);
        for (Ronda ronda : rondas) {
            ronda.addObserver(vistaRonda);
        }
        return vistaRonda;
    }
}