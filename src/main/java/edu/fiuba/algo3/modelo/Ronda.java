package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Ronda extends Observable{
    private Pregunta pregunta;
    private List<Jugador> jugadores;
    private Respuestas respuestas;
    private Jugador jugadorActivo;
    private int posicionJugadorSiguiente;
    private List<Observer> observadores;
    private static final int POSICION_JUGADOR_INICIAL=0;

    public Ronda(Pregunta unaPregunta, List<Jugador> listaJugadores){
        this.respuestas = new Respuestas();
        this.pregunta = unaPregunta;
        this.jugadores = listaJugadores;
        this.jugadorActivo = jugadores.get(POSICION_JUGADOR_INICIAL);
        this.posicionJugadorSiguiente = 1;
    }

    public Pregunta getPregunta(){
       return pregunta;
    }

    private boolean haySiguienteJugador(){
        return jugadores.size()>posicionJugadorSiguiente;
    }

    public void siguienteJugador(){
        if(this.haySiguienteJugador()){
            jugadorActivo = jugadores.get(posicionJugadorSiguiente);
            posicionJugadorSiguiente ++;
            this.notifyObservers();
        }
    }


    public void activarExclusividad(){
        respuestas.activarExclusividad();
    }

    public void agregarRespuesta(Eleccion eleccion, Bonificador bonificador){
        this.respuestas.agregarRespuesta(new Respuesta(jugadorActivo, eleccion, bonificador));
        this.siguienteJugador();
    }

    public void evaluarRespuestas(){
        this.pregunta.responderPregunta(this.respuestas);
    }
}
