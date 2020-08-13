package edu.fiuba.algo3.modelo;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class Kahoot {

    public static final int VERDADERO_FALSO = 1;

    private Ronda rondaActiva;
    private Queue<Ronda> rondas = new LinkedList<Ronda>();
    private Tabla tablaJugadores;

    public Kahoot(List<Jugador> jugadores){
        tablaJugadores = new Tabla(jugadores);
    }

    public void agregarPregunta(Pregunta pregunta){
        Ronda ronda = new Ronda(pregunta, tablaJugadores.jugadores());
        rondas.add(ronda);
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
        return 1; // cambiar lógica
    }

    public boolean haySiguienteJugador(){
        return rondaActiva.haySiguienteJugador();
    }

    public Jugador getSiguienteJugador(){
        return rondaActiva.getSiguienteJugador();
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
}
