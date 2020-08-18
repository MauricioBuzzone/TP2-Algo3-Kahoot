package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.controlador.*;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

import javafx.stage.Stage;
import java.util.*;



import java.util.Observable;
import java.util.Observer;


public class VistaRonda implements Observer {

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 350;
    private static final int ESPACIADO = 30;

    private Reloj reloj;
    private Ronda rondaActiva;
    private Stage stage;
    private Button botonAvanzarRonda;
    private Jugador jugadorAnterior;
    private Queue<Jugador> jugadores;


    public VistaRonda(Stage stage, Ronda rondaActiva, Button botonAvanzarRonda) {
        this.rondaActiva = rondaActiva;
        this.stage = stage;

        botonAvanzarRonda.setText("Próxima ronda");
        botonAvanzarRonda.setFont(new Font(App.FUENTE, 18));
        botonAvanzarRonda.setPrefSize(200,14);

        this.botonAvanzarRonda = botonAvanzarRonda;
        this.jugadorAnterior = null;
        this.jugadores = new LinkedList<Jugador>();

    }

    @Override
    public void update(Observable o, Object arg) {

        Jugador jugadorActivo = rondaActiva.getJugadorActivo();
        if(jugadorActivo != jugadorAnterior){
            jugadores.add(jugadorActivo);
            jugadorAnterior = jugadorActivo;
            Scene escena = crearEscenaRonda(jugadorActivo);
            stage.setScene(escena);
        }else {
            jugadorAnterior = null;
            Scene escena = crearEscenaTabla();
            stage.setScene(escena);
        }
    }

    private Scene crearEscenaRonda(Jugador jugadorActivo) {

        Label titulo = new Label("Próximo Jugador: " + jugadorActivo.getNombre());
        titulo.setFont(new Font(App.FUENTE, 24));
        Label buenaSuerte = new Label("¡Buena suerte!");
        buenaSuerte.setFont(new Font(App.FUENTE, 22));

        VBox contenedorTitulo = new VBox(titulo, buenaSuerte);
        contenedorTitulo.setSpacing(5);
        contenedorTitulo.setAlignment(Pos.CENTER);

        Label usosBonificadorX2 = new Label("Usos disponibles X2: " + jugadorActivo.usosDisponiblesX2());
        usosBonificadorX2.setFont(new Font(App.FUENTE, 18));
        Label usosBonificadorX3 = new Label("Usos disponibles X3: " + jugadorActivo.usosDisponiblesX3());
        usosBonificadorX3.setFont(new Font(App.FUENTE, 18));
        Label usosExclusividad = new Label("Usos disponibles Exclusividad: " + jugadorActivo.usosDisponiblesExclusividad());
        usosExclusividad.setFont(new Font(App.FUENTE, 18));

        VBox bonificadores = new VBox(usosBonificadorX2, usosBonificadorX3, usosExclusividad);
        bonificadores.setSpacing(1);
        bonificadores.setAlignment(Pos.CENTER);

        Button comenzarTurno = new Button();
        comenzarTurno.setText("Jugar");
        comenzarTurno.setPrefSize(130,14);
        comenzarTurno.setFont(new Font(App.FUENTE, 18));

        reloj = new Reloj(rondaActiva.getTiempo());
        FactoryEscenas factory = new FactoryEscenas(stage, rondaActiva, reloj);
        Scene escenaProxima = factory.crearEscenaPregunta();

        comenzarTurno.setOnAction(new BotonComenzarTurnoEventHandler(this.stage, escenaProxima, rondaActiva, reloj));

        VBox contenedorPrincipal = new VBox(contenedorTitulo, bonificadores, comenzarTurno);
        contenedorPrincipal.setSpacing(ESPACIADO);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);
    }


    private Scene crearEscenaTabla() {
        Label titulo = new Label("¡Terminó la ronda!");
        titulo.setFont(new Font(App.FUENTE, 24));
        Label tituloPuntos = new Label("Puntos conseguidos");
        tituloPuntos.setFont(new Font(App.FUENTE, 20));

        VBox contenedorTitulo = new VBox(titulo, tituloPuntos);
        contenedorTitulo.setSpacing(5);
        contenedorTitulo.setAlignment(Pos.CENTER);

        TablaDePuntajes tabla = new TablaDePuntajes("ultimoPuntaje", "Puntos Conseguidos", jugadores);

        VBox contenedorPrincipal = new VBox(contenedorTitulo, tabla, botonAvanzarRonda);
        contenedorPrincipal.setSpacing(ESPACIADO);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);

    }

    public void cambiarRondaActiva(Ronda rondaActiva){
        this.rondaActiva = rondaActiva;
    }
}