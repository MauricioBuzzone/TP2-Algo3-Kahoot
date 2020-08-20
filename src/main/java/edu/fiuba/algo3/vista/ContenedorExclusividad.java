package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonExclusividadEventHandler;
import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ContenedorExclusividad extends HBox {
    private static final int TAMANIO_LETRA = 18;
    private static final int ANCHO_BOTON = 130;
    private static final int ALTO_BOTON = 14;

    public ContenedorExclusividad(ControladorRespuesta controlador, Jugador jugadorActivo) {

        super();
        Button botonExclusividad = new Button();
        botonExclusividad.setText("Exclusividad");
        botonExclusividad.setStyle(StyleHandler.COLOR_BOTON_BLANCO);

        botonExclusividad.setPrefSize(ANCHO_BOTON,ALTO_BOTON);
        botonExclusividad.setFont(new Font(App.FUENTE, TAMANIO_LETRA));

        botonExclusividad.setOnAction(new BotonExclusividadEventHandler(controlador, jugadorActivo, botonExclusividad));
        if(!jugadorActivo.puedeUtilizarExclusividad()) {
            botonExclusividad.setDisable(true);
        }

        this.getChildren().addAll(botonExclusividad);
    }
}
