package edu.fiuba.algo3.modelo;


import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class Kahoot {

    public static final int VERDADERO_FALSO = Pregunta.VERDADERO_FALSO;
    public static final int VERDADERO_FALSO_CON_PENALIDAD = Pregunta.VERDADERO_FALSO_CON_PENALIDAD;
    public static final int MULTIPLE_CHOICE_CLASICO = Pregunta.MULTIPLE_CHOICE_CLASICO;
    public static final int MULTIPLE_CHOICE_CON_PENALIDAD = Pregunta.MULTIPLE_CHOICE_CON_PENALIDAD;
    public static final int MULTIPLE_CHOICE_PUNTAJE_PARCIAL = Pregunta.MULTIPLE_CHOICE_PUNTAJE_PARCIAL;
    public static final int ORDERED_CHOICE = Pregunta.ORDERED_CHOICE;
    public static final int GROUP_CHOICE = Pregunta.GROUP_CHOICE;

    public static final String RUTA_ARCHIVO_DEFAULT = "RondasDefault.json";


    private Ronda rondaActiva;
    private Queue<Ronda> rondas = new LinkedList<Ronda>();
    private Tabla tablaJugadores;
    private CuentaAtras cuentaAtras;

    public Kahoot(List<Jugador> jugadores) {
        tablaJugadores = new Tabla(jugadores);
        try {
            this.agregarRonda(RUTA_ARCHIVO_DEFAULT);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public Kahoot(List<Jugador> jugadores, String rutaArchivo){
        tablaJugadores = new Tabla(jugadores);
        try{
            this.agregarRonda(rutaArchivo);
        }catch (IOException ex){
            System.out.println(ex);
        }
    }

    //TestOnly. A borrar
    public Kahoot(List<Jugador> jugadores, Pregunta pregunta){
        tablaJugadores = new Tabla(jugadores);
        this.agregarPregunta(pregunta);
    }

    public void agregarPregunta(Pregunta pregunta){
        Ronda ronda = new Ronda(pregunta, tablaJugadores.jugadores());
        rondas.add(ronda);
    }

    public void jugadorVaAResponder(RespondedorPorDefecto respondedor){
        Timer timer = new Timer();
        this.cuentaAtras = new CuentaAtras(respondedor);
        timer.schedule(this.cuentaAtras, 15000);
    }

    public void jugadorYaRespondio(){
        cuentaAtras.cancel();
    }

    public boolean haySiguienteRonda(){
        return(!rondas.isEmpty());
    }

    public void siguienteRonda(){
        rondaActiva = rondas.poll();
    }

    public String getEnunciado(){
        return rondaActiva.getEnunciado();
    }

    public List<String> getOpciones(){
        return rondaActiva.getOpciones();
    }

    public int tipoDePregunta(){
        return rondaActiva.tipoDePregunta();
    }

    public boolean haySiguienteJugador(){
        return rondaActiva.haySiguienteJugador();
    }

    public void siguienteJugador(){
        rondaActiva.siguienteJugador();
    }

    public Jugador getJugador(){
        return rondaActiva.getJugador();
    }

    public void agregarRespuesta(Respuesta respuesta){
        rondaActiva.agregarRespuesta(respuesta);
    }

    public void responder(){
        rondaActiva.responder();
    }

    public Tabla terminarJuego(){
        return tablaJugadores;
    }

    //Json
    public void agregarRonda(String archivo) throws IOException{

        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        this.agregarRonda(jsonObject);

    }

    private void agregarRonda(JsonObject jsonObject){
        JsonArray ArrayRondas = jsonObject.get("Rondas").getAsJsonArray();

        for (JsonElement jsonRonda : ArrayRondas){
            Pregunta pregunta = Pregunta.recuperar(jsonRonda.getAsJsonObject());
            this.agregarPregunta(pregunta);
        }
    }
}
