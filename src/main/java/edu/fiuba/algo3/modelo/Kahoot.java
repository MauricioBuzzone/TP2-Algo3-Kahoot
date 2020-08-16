package edu.fiuba.algo3.modelo;


import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;


public class Kahoot extends Observable{

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

    public void agregarPregunta(Pregunta pregunta){
        Ronda ronda = new Ronda(pregunta, tablaJugadores.jugadores());
        rondas.add(ronda);
    }

    public void proximaRonda(){
        this.rondaActiva = this.nuevaRonda();
        this.setChanged();
        this.notifyObservers();
    }

    private Ronda nuevaRonda(){
        if(this.quedanRondas()){
            return rondas.poll();
        }
        return rondaActiva;
    }

    public boolean quedanRondas(){
        return(!rondas.isEmpty());
    }


    public Ronda getRondaActiva(){
        return rondaActiva;
    }

    public List<Ronda> getRondas(){
        return new ArrayList(rondas);
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
