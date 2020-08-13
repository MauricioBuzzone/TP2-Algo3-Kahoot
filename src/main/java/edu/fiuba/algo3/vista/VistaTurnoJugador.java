package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaTurnoJugador {
    private Kahoot kahoot;
    private Stage stage;
    private Scene scene
    public VistaTurnoJugador(Kahoot kahoot, Stage stage) {
        this.kahoot = kahoot;
        this.stage = stage;
        this.scene = this.prepararEscena();
    }

    private Scene prepararEscena() {
        kahoot.siguienteRonda();

    }

    public void mostrar() {

    }
}
