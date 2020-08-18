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
        Label titulo = new Label("Información de los puntajes de la ronda previa.");

        TableView tableView = new TableView();
        TableColumn<String, Integer> column1 = new TableColumn<>("Nombre de jugador");
        TableColumn<String, Integer> column2 = new TableColumn<>("Puntos");

        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setCellValueFactory(new PropertyValueFactory<>("ultimoPuntaje"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        while(!jugadores.isEmpty()){
            tableView.getItems().add(jugadores.poll());
        }

        VBox contenedorPrincipal = new VBox(titulo, tableView, botonAvanzarRonda);
        contenedorPrincipal.setSpacing(ESPACIADO);
        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);

    }

    public void cambiarRondaActiva(Ronda rondaActiva){
        this.rondaActiva = rondaActiva;
    }
}