package edu.fiuba.algo3.modelo;

import java.util.*;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.Respuestas;

public class Ronda extends Observable{
    private Pregunta pregunta;
    private Queue<Jugador> jugadores;
    private Respuestas respuestas;
    private Jugador jugadorActivo;
    private CuentaAtras cuentaAtras;

    public void proximoJugador(){
        this.jugadorActivo = this.nuevoJugador();
        this.setChanged();
        this.notifyObservers();
    }

    public Jugador getJugadorActivo(){
        return jugadorActivo;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    private Jugador nuevoJugador(){
        if(this.quedanJugadores()){
            return jugadores.poll();
        }
        return jugadorActivo;
    }

    public boolean quedanJugadores(){
        return(!jugadores.isEmpty());
    }

    public List<Opcion> getOpciones(){
        return pregunta.getOpciones();
    }


    // Dar vuelta el encapsulamiento.
    public String getEnunciado(){
        return pregunta.getEnunciado();
    }


    public void agregarRespuesta(Respuesta respuesta){
        respuestas.agregarRespuesta(respuesta);
        if(this.quedanJugadores()){
            this.proximoJugador();
        }else{
            this.responder();
        }
    }

    private void responder(){
        pregunta.responderPregunta(respuestas);
        this.setChanged();
        this.notifyObservers();
    }


    public Ronda(Pregunta unaPregunta, List<Jugador> listaJugadores) {
        respuestas = new Respuestas();
        pregunta = unaPregunta;
        jugadores = new LinkedList<Jugador>(listaJugadores);
    }

    public void jugadorVaAResponder(RespondedorPorDefecto respondedor){
        Timer timer = new Timer();
        this.cuentaAtras = new CuentaAtras(respondedor);
        timer.schedule(this.cuentaAtras, 15000);
    }

    public void jugadorYaRespondio(){
        cuentaAtras.cancel();
    }

    public void activarExclusividad() {
        respuestas.activarExclusividad();
    }
}