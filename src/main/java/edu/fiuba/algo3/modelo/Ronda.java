package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Ronda {
    private Pregunta pregunta;
    private Queue<Jugador> jugadores;
    private Respuestas respuestas;
    private Jugador jugadorActivo;

    public Ronda(Pregunta unaPregunta, List<Jugador> listaJugadores) {
        respuestas = new Respuestas();
        pregunta = unaPregunta;
        jugadores = new LinkedList<Jugador>(listaJugadores);
    }

    public String getEnunciado() {
        return pregunta.getEnunciado();
    }

    public List<String> getOpciones() {
        return pregunta.getOpciones();
    }

    public boolean haySiguienteJugador(){
        return(!jugadores.isEmpty());
    }

    public Jugador getSiguienteJugador(){
        return jugadores.poll();
    }

    public void agregarRespuesta(Respuesta respuesta){
        respuestas.agregarRespuesta(respuesta);
    }

    public void responder(){
        pregunta.responderPregunta(respuestas);
    }
}
