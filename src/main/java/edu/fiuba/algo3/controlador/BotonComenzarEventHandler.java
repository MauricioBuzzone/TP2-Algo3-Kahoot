package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoHayPreguntasException;
import edu.fiuba.algo3.modelo.excepciones.ArchivoJsonMalEscritoException;
import edu.fiuba.algo3.modelo.excepciones.ErrorAlAbrirArchivoException;
import edu.fiuba.algo3.modelo.excepciones.SolucionInvalidaException;
import edu.fiuba.algo3.vista.VistaKahoot;
import edu.fiuba.algo3.vista.VistaRonda;
import edu.fiuba.algo3.modelo.Kahoot;


import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private ListView nombresJugadores;
    private String rutaKahoot;

    public BotonComenzarEventHandler(ListView jugadoresInscriptos, Stage stage, String rutaKahoot) {
        this.nombresJugadores = jugadoresInscriptos;
        this.stage = stage;
        this.rutaKahoot = rutaKahoot;
    }

    public void handle(ActionEvent actionEvent){

        List<Jugador> jugadores = this.obtenerJugadores();
        if(jugadores.isEmpty()){
            Alert alertaNombreInvalido = new Alert(AlertType.INFORMATION);
            alertaNombreInvalido.setTitle("Error");
            alertaNombreInvalido.setHeaderText(null);
            alertaNombreInvalido.setContentText("Debe haber al menos un Jugador para comenzar.");
            alertaNombreInvalido.showAndWait();
            return;
        }


        try {
            Kahoot kahoot = new Kahoot(jugadores, rutaKahoot);
            VistaRonda vistaRonda = this.asignarVistaRonda(kahoot);
            VistaKahoot vistaKahoot = new VistaKahoot(stage, kahoot, vistaRonda);
            kahoot.addObserver(vistaKahoot);
            kahoot.proximaRonda(); // Pone rondaActiva a la próxima ronda, en este caso la primera.


            //Si los usuarios fuesen mas considerados no deberia tener que hacer esto...
        }catch (ErrorAlAbrirArchivoException ex){
            Alert alertaNoSePuedoLeerElArchivo = new Alert(AlertType.INFORMATION);
            alertaNoSePuedoLeerElArchivo.setTitle("Error");
            alertaNoSePuedoLeerElArchivo.setHeaderText(null);
            alertaNoSePuedoLeerElArchivo.setContentText("Hubo un problema al abrir el archivo");
            alertaNoSePuedoLeerElArchivo.showAndWait();
            System.exit(0);

        }catch(ArchivoJsonMalEscritoException ex){
            Alert alertaJsonMalEscrito = new Alert(AlertType.INFORMATION);
            alertaJsonMalEscrito.setTitle("Error");
            alertaJsonMalEscrito.setHeaderText(null);
            alertaJsonMalEscrito.setContentText("Archivo Json mal escrito");
            alertaJsonMalEscrito.showAndWait();

        }catch(NoHayPreguntasException ex){
            Alert alertaJsonNoHayPreguntas = new Alert(AlertType.INFORMATION);
            alertaJsonNoHayPreguntas.setTitle("Error");
            alertaJsonNoHayPreguntas.setHeaderText(null);
            alertaJsonNoHayPreguntas.setContentText("Archivo Json no posee preguntas");
            alertaJsonNoHayPreguntas.showAndWait();
            System.exit(0);

        }catch(SolucionInvalidaException ex){
            Alert alertaJsonSinSolucion = new Alert(AlertType.INFORMATION);
            alertaJsonSinSolucion.setTitle("Error");
            alertaJsonSinSolucion.setHeaderText(null);
            alertaJsonSinSolucion.setContentText("Al menos una de las preguntas no posee solucion");
            alertaJsonSinSolucion.showAndWait();
            System.exit(0);
        }

    }

    private List<Jugador> obtenerJugadores() {

        List<String> nombres =  this.nombresJugadores.getItems();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        for(String nombre : nombres){
            jugadores.add(new Jugador(nombre));
        }
        return jugadores;
    }

    private VistaRonda asignarVistaRonda(Kahoot kahoot) {
        List<Ronda> rondas = kahoot.getRondas();

        Button botonProximaRonda = new Button();
        botonProximaRonda.setOnAction(new BotonProximaRondaEventHandler(kahoot));
        VistaRonda vistaRonda = new VistaRonda(stage, rondas.get(0), botonProximaRonda);
        for (Ronda ronda : rondas) {
            ronda.addObserver(vistaRonda);
        }
        return vistaRonda;
    }
}