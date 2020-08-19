package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.controlador.BotonProximoJugadorEventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;


import java.util.LinkedList;
import java.util.Observable;
import java.util.List;
import java.util.Observer;
import java.util.Queue;


public class VistaKahoot implements Observer{

    private static final String PREGUNTA_VF = "Verdadero o Falso";
    private static final String PREGUNTA_VFCP = "Verdadero o Falso con Penalidad";
    private static final String PREGUNTA_MCC = "Múltiple Choice Clásico";
    private static final String PREGUNTA_MCCP = "Múltiple Choice con Penalidad";
    private static final String PREGUNTA_MCPP = "Múltiple Choice con Puntaje Parcial";
    private static final String PREGUNTA_OC = "Ordered Choice";
    private static final String PREGUNTA_GC = "Group Choice";

    private static final int ESPACIADO = 30;
    private static final int TAMANIO_FONT_TITULO = 24;
    private static final int TAMANIO_FONT_SUB_TITULO = 28;
    private static final int TAMANIO_FONT_BOTON_AVANZAR = 22;

    private Kahoot kahoot;
    private Stage stage;
    private VistaRonda vistaRonda;
    private Ronda rondaAnterior = null;

    public VistaKahoot(Stage stage, Kahoot kahoot, VistaRonda vistaRonda){
        this.kahoot = kahoot;
        this.stage = stage;
        this.vistaRonda = vistaRonda;
    }

    @Override
    public void update(Observable o, Object arg){
        Ronda rondaActiva = kahoot.getRondaActiva();
        if(rondaActiva != rondaAnterior){
            rondaAnterior = rondaActiva;
            this.vistaRonda.cambiarRondaActiva(rondaActiva);
            Scene escena = crearEscenaRonda(rondaActiva);
            stage.setScene(escena);
        }else{
            Scene escena = crearEscenaTabla();
            stage.setScene(escena);
        }
    }

    private Scene crearEscenaRonda(Ronda ronda){
        TipoDePreguntaColorHandler coloreador = new TipoDePreguntaColorHandler();

        Pregunta pregunta = ronda.getPregunta();
        Label titulo = new Label("Próxima pregunta: " + this.nombreTipoDePregunta(pregunta));
        titulo.setFont(new Font(App.FUENTE, TAMANIO_FONT_TITULO));

        Label enunciado = new Label(pregunta.getEnunciado());
        enunciado.setFont(new Font(App.FUENTE, TAMANIO_FONT_SUB_TITULO));

        VBox contenedorSuperior = new VBox(titulo, enunciado);
        contenedorSuperior.setSpacing(3);
        contenedorSuperior.setAlignment(Pos.CENTER);

        Button avanzarATurno = new Button();
        avanzarATurno.setText("Avanzar");
        avanzarATurno.setFont(new Font(App.FUENTE, TAMANIO_FONT_BOTON_AVANZAR));
        avanzarATurno.setOnAction(new BotonProximoJugadorEventHandler(ronda));
        avanzarATurno.setPrefSize(130,14);
        avanzarATurno.setStyle(coloreador.colorBoton(pregunta.getTipoDePregunta()));

        VBox contenedorPrincipal = new VBox(contenedorSuperior, avanzarATurno);
        contenedorPrincipal.setSpacing(ESPACIADO);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setStyle(coloreador.colorBackground(pregunta.getTipoDePregunta()));

        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);
    }

    private String nombreTipoDePregunta(Pregunta pregunta){
        TipoDePregunta tipo = pregunta.getTipoDePregunta();
        if(tipo.getClass() == GroupChoice.class){
            return PREGUNTA_GC;
        }else if(tipo.getClass() == VerdaderoFalsoConPenalidad.class){
            return PREGUNTA_VFCP;
        }else if(tipo.getClass() == MultipleChoiceClasico.class){
            return PREGUNTA_MCC;
        }else if(tipo.getClass() == MultipleChoiceConPenalidad.class) {
            return PREGUNTA_MCCP;
        }else if(tipo.getClass() == MultipleChoicePuntajeParcial.class) {
            return PREGUNTA_MCPP;
        }else if(tipo.getClass() == OrderedChoice.class) {
            return PREGUNTA_OC;
        }else{//(tipo.getClass() == VerdaderoFalso.class ) {
            return PREGUNTA_VF;
        }
    }

    private Scene crearEscenaTabla(){

        Label titulo = new Label("¡Terminó el AlgoHoot!");
        titulo.setFont(new Font(App.FUENTE, 26));

        Label tituloFinal = new Label();

        if(this.hayEmpate()){
            tituloFinal.setText("Un inesperado empate!!! ╯°□°）╯︵ ┻━┻");
            tituloFinal.setFont(new Font(App.FUENTE, 22));
        }else {
            tituloFinal.setText("El ganador es: " + kahoot.jugadorConMasPuntos().getNombre());
            tituloFinal.setFont(new Font(App.FUENTE, 22));
        }
        VBox contenedorTitulo = new VBox(titulo, tituloFinal);
        contenedorTitulo.setSpacing(5);
        contenedorTitulo.setAlignment(Pos.CENTER);


        Label tituloTabla = new Label("Tabla final");
        tituloTabla.setFont(new Font(App.FUENTE, 18));

        Queue<Jugador> jugadores = new LinkedList<>(kahoot.terminarJuego());

        TablaDePuntajes tabla = new TablaDePuntajes("puntos","Puntos Totales", jugadores);

        VBox contenedorTabla = new VBox(tituloTabla, tabla);
        contenedorTabla.setSpacing(5);
        contenedorTabla.setAlignment(Pos.CENTER);

        VBox contenedorPrincipal = new VBox(contenedorTitulo, contenedorTabla);
        contenedorPrincipal.setSpacing(ESPACIADO);
        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);
    }

    private boolean hayEmpate(){
        List<Jugador> jugadores = new LinkedList<>(kahoot.terminarJuego());
        Jugador jugadorConMasPuntos = kahoot.jugadorConMasPuntos();

        boolean hayEmpate = false;
        for(Jugador jugador : jugadores){
            if(jugador.jugadoresConMismosPuntos(jugadorConMasPuntos)){;
                hayEmpate = true;
            }
        }
        return hayEmpate;
    }

    private Label crearLabelProximaPregunta(String descripcion, String tipoDePregunta){

        Label titulo = new Label("Próxima pregunta: " + tipoDePregunta);
        titulo.setFont(new Font(App.FUENTE, TAMANIO_FONT_TITULO));

        Label enunciado = new Label(descripcion);
        enunciado.setFont(new Font(App.FUENTE, TAMANIO_FONT_SUB_TITULO));

        return titulo;
    }
}