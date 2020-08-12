package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Tabla {
    private final int USOS_DISPONIBLES_NULOS = 0;
    private List<Jugador> jugadores;
    private Hashtable<Jugador, Integer> usosDisponiblesExclusividad = new Hashtable<Jugador, Integer>() {
    };

    public Tabla(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        for(Jugador jugador:jugadores)
            usosDisponiblesExclusividad.put(jugador, 2);
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
