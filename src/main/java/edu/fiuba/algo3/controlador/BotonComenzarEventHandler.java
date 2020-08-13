package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorPrincipal;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.VistaPreguntaVF;
import edu.fiuba.algo3.vista.VistaTurnoJugador;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private ListView nombreJugadores;

    public BotonComenzarEventHandler(ListView jugadoresInscriptos, Stage stage) {
        this.nombreJugadores = jugadoresInscriptos;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){

        List<Jugador> jugadores = this.obtenerJugadores();

        Kahoot kahoot = new Kahoot(jugadores);

        if(kahoot.haySiguienteRonda()){
            VistaTurnoJugador vistaTurno = new VistaTurnoJugador(kahoot, stage);
            vistaTurno.mostrar();
        }
    }


    private List<Jugador> obtenerJugadores() {

        List<String> nombres =  this.nombreJugadores.getItems();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        for(String nombre : nombres){
            jugadores.add(new Jugador(nombre));
        }
        return jugadores;
    }
}

