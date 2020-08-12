package edu.fiuba.algo3.modelo;

import java.util.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Kahoot extends Observable {
    //private final int POSICION_RONDA_INICIAL = 0;
    private final int POSICION_SIGUIENTE_RONDA = 1;
    //private Ronda rondaActiva;
    //private List<Ronda> rondas;
    private int posicionSiguienteRonda;
    private Tabla jugadores;

    public List<Observer> observadores;

    public Kahoot(ArrayList<Jugador> jugadores){
        this.jugadores = new Tabla(jugadores);
        posicionSiguienteRonda = POSICION_SIGUIENTE_RONDA;
    }

    public void agregarRondas(){

    }

    public void jugarRonda(){
        //this.rondaActiva.jugarConSiguienteJugador();
    }
/*
    public void siguienteRonda(){
        if(this.haySiguienteRonda()){
            rondaActiva = rondas.get(posicionSiguienteRonda);
            posicionSiguienteRonda++;
            this.notifyObservers();
        }
    }

    public void haySiguienteRonda(){
        return rondas.size() > posicionSiguienteRonda;
    }

    public Ronda rondaActiva(){
        return rondaActica;
    }
 */
}
