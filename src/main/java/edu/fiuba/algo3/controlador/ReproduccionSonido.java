package edu.fiuba.algo3.controlador;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproduccionSonido {
    private MediaPlayer reproductor;

    public ReproduccionSonido(String rutaArchivo){
        com.sun.javafx.application.PlatformImpl.startup(()->{});
        File archivo = new File(rutaArchivo);
        Media audio = new Media(archivo.toURI().toString());
        reproductor = new MediaPlayer(audio);
    }
    public void reproducir(){
        reproductor.play();
        reproductor.setVolume(0.2);
    }
    //reproductor.setVolume(0.2);
    //reproductor.stop();
    //reproductor.setOnRepeat(runnable?);
}