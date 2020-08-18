package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Reloj extends Pane {
    private Timeline animation;
    private int tmp;
    private String s = "";

    Label label;

    public Reloj(int tmp) {
        super();
        this.label = new Label(tmp + "");
        this.tmp = tmp;
        label.setFont(javafx.scene.text.Font.font(50));

        getChildren().add(label);
        animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> timeLabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    private void timeLabel() {
        if (tmp > 0) {
            tmp--;
        }
        s = tmp + "";
        label.setText(s);
    }
}
