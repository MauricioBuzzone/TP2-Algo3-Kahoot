package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TablaTest {

    @Test
    public void test01InicialmenteSepuedeUtilizarExclusividadDeAmbosJugadores(){
        Jugador jugador1 = new Jugador("Don Pepito");
        Jugador jugador2 = new Jugador("Don Jose");
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Tabla tablaJugadores = new Tabla(jugadores);
        assert(tablaJugadores.puedeUtilizarExclusividad(jugador1));
        assert (tablaJugadores.puedeUtilizarExclusividad(jugador2));
    }

    @Test
    public void test02NingunJugadorPuedeUsarTresExclusividades(){
        Jugador jugador1 = new Jugador("Don Pepito");
        Jugador jugador2 = new Jugador("Don Jose");
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Tabla tablaJugadores = new Tabla(jugadores);

        tablaJugadores.activarExclusividad(jugador1);
        tablaJugadores.activarExclusividad(jugador1);
        tablaJugadores.activarExclusividad(jugador2);
        tablaJugadores.activarExclusividad(jugador2);

        assertFalse(tablaJugadores.puedeUtilizarExclusividad(jugador1));
        assertFalse(tablaJugadores.puedeUtilizarExclusividad(jugador2));
    }

    @Test
    public void testo03LosJugadoresPuedeUtilizarExclusividadLuegoDeHaberlaUsadoUnaVezAnteriormente(){
        Jugador jugador1 = new Jugador("Don Pepito");
        Jugador jugador2 = new Jugador("Don Jose");
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Tabla tablaJugadores = new Tabla(jugadores);

        tablaJugadores.activarExclusividad(jugador1);
        tablaJugadores.activarExclusividad(jugador2);

        assert(tablaJugadores.puedeUtilizarExclusividad(jugador1));
        assert(tablaJugadores.puedeUtilizarExclusividad(jugador2));
    }
}
