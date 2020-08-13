package edu.fiuba.algo3.modelo;

import java.util.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Kahoot extends Observable {
    private final int POSICION_SIGUIENTE_RONDA = 1;
    private Ronda rondaActiva;
    private List<Ronda> rondas = new ArrayList<Ronda>();
    private int posicionSiguienteRonda;
    private Tabla tablaJugadores;
    private List<Jugador> jugadores;


    public Kahoot(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.tablaJugadores = new Tabla(jugadores);
        posicionSiguienteRonda = POSICION_SIGUIENTE_RONDA;
    }

    public void agregarRondas(){

    }

    public void jugarRonda(){
        this.rondaActiva.siguienteJugador();
    }

    public void siguienteRonda(){
        if(this.haySiguienteRonda()){
            rondaActiva = rondas.get(posicionSiguienteRonda);
            posicionSiguienteRonda++;
        }
        this.notifyObservers();
    }

    private boolean haySiguienteRonda(){
        return rondas.size() > posicionSiguienteRonda;
    }

    public Ronda rondaActiva(){
        return rondaActiva;
    }

    public void agregarPregunta(Pregunta pregunta){
        rondas.add(new Ronda(pregunta, jugadores));
    }
}
