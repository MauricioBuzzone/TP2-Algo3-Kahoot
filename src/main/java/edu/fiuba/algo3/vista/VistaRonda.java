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

    private static final int ESPACIADO = 30;
    private static final int TAMANIO_FONT_BOTON = 18;
    private static final int TAMANIO_FONT_TITULO = 36;
    private static final int TAMANIO_FONT_SUB_TITULO = 20;
    private static final int TAMANIO_FONT_BUENASUERTE = 24;
    private static final int TAMANIO_FONT_BONIFICADORES = 22;
    private static final int TAMANIO_FONT_EXCLUSIVIDAD = 22;
    private static final int TAMANIO_FONT_BOTON_JUGAR = 28;
    private static final int ANCHO_BOTON_AVANZAR_RONDA = 200;
    private static final int ALTO_BOTON_AVANZAR_RONDA = 14;
    private static final int ANCHO_BOTON_COMENZAR_TURNO = 130;
    private static final int ALTO_BOTON_COMENZAR_TURNO = 14;


    private Reloj reloj;
    private Ronda rondaActiva;
    private Stage stage;
    private Button botonAvanzarRonda;
    private Jugador jugadorAnterior;
    private Queue<Jugador> jugadores;


    public VistaRonda(Stage stage, Ronda rondaActiva, Button botonAvanzarRonda) {
        this.rondaActiva = rondaActiva;
        this.stage = stage;

        this.configurarBoton(botonAvanzarRonda, ANCHO_BOTON_AVANZAR_RONDA, ALTO_BOTON_AVANZAR_RONDA, "Próxima ronda", TAMANIO_FONT_BOTON);
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

    private Label crearLabel(String descripcion,int tamanio){
        Label label = new Label(descripcion);
        label.setFont(new Font(App.FUENTE, tamanio));

        return label;
    }

    private Scene crearEscenaRonda(Jugador jugadorActivo) {

        StyleHandler coloreador = new StyleHandler();

        Label titulo = this.crearLabel("Próximo Jugador: " + jugadorActivo.getNombre(), TAMANIO_FONT_TITULO);
        titulo.setStyle(coloreador.colorFont(rondaActiva.getPregunta().getTipoDePregunta()));
        Label buenaSuerte = this.crearLabel("¡Buena suerte!", TAMANIO_FONT_BUENASUERTE);
        buenaSuerte.setStyle(coloreador.colorFont(rondaActiva.getPregunta().getTipoDePregunta()));

        VBox contenedorTitulo = new VBox(titulo, buenaSuerte);
        contenedorTitulo.setSpacing(5);
        contenedorTitulo.setAlignment(Pos.CENTER);

        Label usosBonificadorX2 = this.crearLabel("Usos disponibles X2: " + jugadorActivo.usosDisponiblesX2(), TAMANIO_FONT_BONIFICADORES);
        usosBonificadorX2.setStyle(coloreador.colorFont(rondaActiva.getPregunta().getTipoDePregunta()));
        Label usosBonificadorX3 = this.crearLabel("Usos disponibles X3: " + jugadorActivo.usosDisponiblesX3(), TAMANIO_FONT_BONIFICADORES);
        usosBonificadorX3.setStyle(coloreador.colorFont(rondaActiva.getPregunta().getTipoDePregunta()));
        Label usosExclusividad = this.crearLabel("Usos disponibles Exclusividad: " + jugadorActivo.usosDisponiblesExclusividad(),TAMANIO_FONT_EXCLUSIVIDAD);
        usosExclusividad.setStyle(coloreador.colorFont(rondaActiva.getPregunta().getTipoDePregunta()));

        VBox bonificadores = new VBox(usosBonificadorX2, usosBonificadorX3, usosExclusividad);
        bonificadores.setSpacing(1);
        bonificadores.setAlignment(Pos.CENTER);

        Button comenzarTurno = new Button();
        this.configurarBoton(comenzarTurno, ANCHO_BOTON_COMENZAR_TURNO, ALTO_BOTON_COMENZAR_TURNO, "Jugar", TAMANIO_FONT_BOTON_JUGAR);
        comenzarTurno.setStyle(coloreador.colorBoton(rondaActiva.getPregunta().getTipoDePregunta()));

        reloj = new Reloj(rondaActiva.getTiempo());
        FactoryEscenas factory = new FactoryEscenas(stage, rondaActiva, reloj);
        Scene escenaProxima = factory.crearEscenaPregunta();

        comenzarTurno.setOnAction(new BotonComenzarTurnoEventHandler(this.stage, escenaProxima, rondaActiva, reloj));

        VBox contenedorPrincipal = new VBox(contenedorTitulo, bonificadores, comenzarTurno);
        contenedorPrincipal.setSpacing(ESPACIADO);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setStyle(coloreador.colorBackground(rondaActiva.getPregunta().getTipoDePregunta()));
        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);
    }

    private Scene crearEscenaTabla() {

        Label titulo = this.crearLabel("¡Terminó la ronda!", TAMANIO_FONT_TITULO);
        Label tituloPuntos = this.crearLabel("Puntos conseguidos", TAMANIO_FONT_SUB_TITULO);

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

    private void configurarBoton(Button boton, int alto, int ancho, String descripcion, int tamanio){
        boton.setText(descripcion);
        boton.setFont(new Font(App.FUENTE, tamanio));
        boton.setPrefSize(alto,ancho);
    }

}