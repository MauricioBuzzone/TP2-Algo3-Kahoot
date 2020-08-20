package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.text.Font;

public class Reloj extends Pane {

    private static final int TIEMPO_MAXIMO = 60;
    private static final int TAMANIO_FUENTE = 40;
    private static final String TIEMPO_MAS_DE_NUEVE_SEG = "  00:";
    private static final String TIEMPO_MENOS_DE_NUEVE_SEG = "  00:0";
    private Timeline animacion;
    private int temporizador;
    private String textoEtiqueta = "";
    private Label etiqueta;

    public Reloj(int temporizador) {
        super();
        if(temporizador >= TIEMPO_MAXIMO){
            temporizador = TIEMPO_MAXIMO;
        }
        this.etiqueta = new Label(TIEMPO_MAS_DE_NUEVE_SEG + temporizador);
        this.temporizador = temporizador;
        etiqueta.setFont(new Font(App.FUENTE,TAMANIO_FUENTE));

        getChildren().add(etiqueta);
        animacion = new Timeline(new KeyFrame(Duration.seconds(1), e -> actualizarEtiqueta()));
        animacion.setCycleCount(Timeline.INDEFINITE);
    }

    private void actualizarEtiqueta() {
        if (temporizador > 0) {
            temporizador--;
        }
        if(temporizador<10) {
            textoEtiqueta = TIEMPO_MENOS_DE_NUEVE_SEG + temporizador;
        }else {
            textoEtiqueta = TIEMPO_MAS_DE_NUEVE_SEG + temporizador;
        }
        etiqueta.setText(textoEtiqueta);
    }

    public void iniciarReloj(){
        animacion.play();
    }
}
