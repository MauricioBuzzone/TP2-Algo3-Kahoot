package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.VistaTurnoJugador;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;


public class ControladorTurno implements Observer {

    private Kahoot kahoot;
    private Stage stage;
    public ControladorTurno(Kahoot kahoot, Stage stage) {
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void update(Observable o, Object arg) {

        VistaTurnoJugador vista = new VistaTurnoJugador(kahoot, stage);
        vista.mostrar();
    }
}
