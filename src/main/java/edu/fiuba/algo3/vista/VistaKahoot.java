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



import java.util.Observable;
import java.util.Observer;


public class VistaKahoot implements Observer{

    private static final String PREGUNTA_VF = "Verdadero o Falso";
    private static final String PREGUNTA_VFCP = "Verdadero o Falso con Penalidad";
    private static final String PREGUNTA_MCC = "Múltiple Choice Clásico";
    private static final String PREGUNTA_MCCP = "Múltiple Choice con Penalidad";
    private static final String PREGUNTA_MCPP = "Múltiple Choice con Puntaje Parcial";
    private static final String PREGUNTA_OC = "Ordered Choice";
    private static final String PREGUNTA_GC = "Group Choice";
    private static final int ESPACIADO = 30;

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
        Pregunta pregunta = ronda.getPregunta();
        Label titulo = new Label("Próxima pregunta: " + this.nombreTipoDePregunta(pregunta));
        titulo.setFont(new Font(App.FUENTE, 22));

        Label enunciado = new Label(pregunta.getEnunciado());
        enunciado.setFont(new Font(App.FUENTE, 18));

        VBox contenedorSuperior = new VBox(titulo, enunciado);
        contenedorSuperior.setSpacing(3);
        contenedorSuperior.setAlignment(Pos.CENTER);

        Button avanzarATurno = new Button();
        avanzarATurno.setText("Avanzar");
        avanzarATurno.setFont(new Font(App.FUENTE, 18));
        avanzarATurno.setOnAction(new BotonProximoJugadorEventHandler(ronda));
        avanzarATurno.setPrefSize(130,14);

        VBox contenedorPrincipal = new VBox(contenedorSuperior, avanzarATurno);
        contenedorPrincipal.setSpacing(ESPACIADO);
        contenedorPrincipal.setAlignment(Pos.CENTER);

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

        Label titulo = new Label("Puntaje final");
        TableView tableView = new TableView();
        TableColumn<String, Integer> column1 = new TableColumn<>("Nombre de jugador");
        TableColumn<String, Integer> column2 = new TableColumn<>("Puntos Totales");

        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setCellValueFactory(new PropertyValueFactory<>("puntos"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        for(Jugador jugador: kahoot.terminarJuego()){
            tableView.getItems().add(jugador);
        }
        VBox contenedorPrincipal = new VBox(titulo, tableView);
        contenedorPrincipal.setSpacing(ESPACIADO);
        return new Scene(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);
    }

}