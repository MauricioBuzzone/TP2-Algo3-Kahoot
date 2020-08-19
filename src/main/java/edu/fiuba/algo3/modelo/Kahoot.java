package edu.fiuba.algo3.modelo;


import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.excepciones.ArchivoJsonMalEscritoException;
import edu.fiuba.algo3.modelo.excepciones.ErrorAlAbrirArchivoException;
import edu.fiuba.algo3.modelo.excepciones.NoHayPreguntasException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;


public class Kahoot extends Observable{

    public static final String RUTA_ARCHIVO_DEFAULT = "RondasDefault.json";

    private Ronda rondaActiva;
    private Queue<Ronda> rondas = new LinkedList<Ronda>();
    private List<Jugador> jugadores;
    private CuentaAtras cuentaAtras;

    public Kahoot(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.abrirArchivoDefault();
    }

    public Kahoot(List<Jugador> jugadores, String rutaArchivo){
        this.jugadores = jugadores;
        try{
            this.agregarRonda(rutaArchivo);
        }catch (IOException ex){
            this.abrirArchivoDefault();
        }
        if(rondas.isEmpty()){
            throw new NoHayPreguntasException();
        }
    }

    private void abrirArchivoDefault(){
        try {
            this.agregarRonda(RUTA_ARCHIVO_DEFAULT);
        } catch (IOException ex) {
            throw new ErrorAlAbrirArchivoException();
        }
    }

    public void agregarPregunta(Pregunta pregunta, int tiempo){
        Ronda ronda = new Ronda(pregunta,  this.jugadores, tiempo);
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

    public Jugador jugadorConMasPuntos(){
        Jugador jugadorActualConMasPuntos = jugadores.get(0);
        for(Jugador jugador : jugadores){
            if(jugador.tieneMasPuntosQue(jugadorActualConMasPuntos)){
                jugadorActualConMasPuntos = jugador;
            }
        }
        return jugadorActualConMasPuntos;
    }

    public List<Jugador> terminarJuego(){
        return this.jugadores;
    }

    //Json
    public void agregarRonda(String archivo) throws IOException{

        try {

            String texto = Files.readString(Path.of(archivo));

            JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

            this.agregarRonda(jsonObject);

        }catch(JsonSyntaxException | NullPointerException ex1){
            throw new ArchivoJsonMalEscritoException();
        }
    }

    private void agregarRonda(JsonObject jsonObject) {
        JsonArray ArrayRondas = jsonObject.get("Rondas").getAsJsonArray();

        for (JsonElement jsonRonda : ArrayRondas) {
            Pregunta pregunta = Pregunta.recuperar(jsonRonda.getAsJsonObject());
            int tiempo = (jsonRonda.getAsJsonObject()).get("tiempo").getAsInt();
            this.agregarPregunta(pregunta, tiempo);
        }
    }
}
