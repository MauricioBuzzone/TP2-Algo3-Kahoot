package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Reloj extends Pane {
    private Timeline animacion;
    private int temporizador;
    private String textoEtiqueta = "";

    private Label etiqueta;

    public Reloj(int temporizador) {
        super();
        this.etiqueta = new Label("00:"+temporizador);
        this.temporizador = temporizador;
        etiqueta.setFont(javafx.scene.text.Font.font(40));

        getChildren().add(etiqueta);
        animacion = new Timeline(new KeyFrame(Duration.seconds(1), e -> actualizarEtiqueta()));
        animacion.setCycleCount(Timeline.INDEFINITE);
    }

    private void actualizarEtiqueta() {
        if (temporizador > 0) {
            temporizador--;
        }
        if(temporizador<10) {
            textoEtiqueta = "00:0" + temporizador;
        }else {
            textoEtiqueta = "00:" + temporizador;
        }
        etiqueta.setText(textoEtiqueta);
    }

    public void iniciarReloj(){
        animacion.play();
    }
}
