package edu.fiuba.algo3.modelo;

import java.util.*;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.Respuestas;

public class Ronda extends Observable{

    private static final int SEG_A_MILISEG = 1000;

    private Pregunta pregunta;
    private Queue<Jugador> jugadores;
    private Respuestas respuestas;
    private Jugador jugadorActivo;
    private CuentaAtras cuentaAtras;
    private int tiempo;

    public Ronda(Pregunta unaPregunta, List<Jugador> listaJugadores, int tiempo) {
        respuestas = new Respuestas();
        pregunta = unaPregunta;
        jugadores = new LinkedList<Jugador>(listaJugadores);
        this.tiempo = tiempo;
    }

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

    public int getTiempo(){
        return tiempo;
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


    public void jugadorVaAResponder(RespondedorPorDefecto respondedor){
        Timer timer = new Timer();
        this.cuentaAtras = new CuentaAtras(respondedor);
        timer.schedule(this.cuentaAtras, this.tiempo * SEG_A_MILISEG);
    }

    public void jugadorYaRespondio(){
        cuentaAtras.cancel();
    }

    public void activarExclusividad() {
        respuestas.activarExclusividad();
    }
}