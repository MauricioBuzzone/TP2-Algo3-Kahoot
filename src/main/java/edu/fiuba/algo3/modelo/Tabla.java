package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Tabla {
    private final int USOS_DISPONIBLES_NULOS = 0;
    private final int USOS_MAX_EXCLUSIVIDAD = 2;
    private List<Jugador> jugadores;
    private Hashtable<Jugador, Integer> usosDisponiblesExclusividad = new Hashtable<Jugador, Integer>() {
    };

    public List<Jugador> jugadores(){
        return jugadores;
    }

    public Tabla(List<Jugador> jugadores){
        this.jugadores = jugadores;
        for(Jugador jugador:jugadores)
            usosDisponiblesExclusividad.put(jugador, USOS_MAX_EXCLUSIVIDAD);
    }

    public void activarExclusividad(Jugador jugador){
        int usosDisponibles = usosDisponiblesExclusividad.get(jugador);
        usosDisponiblesExclusividad.remove(jugador);
        usosDisponiblesExclusividad.put(jugador, usosDisponibles-1);
    }

    public boolean puedeUtilizarExclusividad(Jugador jugador) {
        return (usosDisponiblesExclusividad.get(jugador) > USOS_DISPONIBLES_NULOS);
    }
}
