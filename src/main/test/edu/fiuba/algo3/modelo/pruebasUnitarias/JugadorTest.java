package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.Bonificador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JugadorTest {

    @Test
    public void test01UnJugadorAlResponderBienObtienePuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje = Puntaje.crearPuntajeFavorable(4);

        Bonificador bonificador = new Bonificador();
        jugador.responder(puntaje, bonificador);

        assertEquals(jugador.puntosTotales(), 4);
    }

    @Test
    public void test02UnJugadorAlResponderMalTieneCeroPuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje = Puntaje.crearPuntajeFavorable(0);

        Bonificador bonificador = new Bonificador();
        jugador.responder(puntaje, bonificador);

        assertEquals(jugador.puntosTotales(),0);

    }

    @Test
    public void test03UnJugadorAlResponderMalNoSeLeSumanPuntosYTieneMenosQueSiHubieseRespondidoBien(){

        Jugador jugadorUno = new Jugador("Tomas");
        Jugador JugadorDos = new Jugador("Pablo");

        Puntaje puntaje1 = Puntaje.crearPuntajeFavorable(5);
        Puntaje puntaje2 = Puntaje.crearPuntajeDesfavorable(5);

        Bonificador bonificador = new Bonificador();
        jugadorUno.responder(puntaje1, bonificador);
        JugadorDos.responder(puntaje2, bonificador);

        assert(jugadorUno.puntosTotales() > JugadorDos.puntosTotales());
    }

    @Test
    public void test04UnJugadorAlResponderMalDadoQuePreviamenteRespondioBienLeQuitanPuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje1 = Puntaje.crearPuntajeFavorable(5);
        Puntaje puntaje2 = Puntaje.crearPuntajeDesfavorable(2);

        Bonificador bonificador = new Bonificador();
        jugador.responder(puntaje1, bonificador);
        jugador.responder(puntaje2, bonificador);

        assertEquals(jugador.puntosTotales(),3);

    }

    @Test
    public void test05UnJugadorRespondeMalSinPenalizacionNoLeRestanPuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje1 = Puntaje.crearPuntajeFavorable(5);
        Puntaje puntaje2 = Puntaje.crearPuntajeDesfavorable(0);

        Bonificador bonificador = new Bonificador();
        jugador.responder(puntaje1, bonificador);
        jugador.responder(puntaje2, bonificador);

        assertEquals(jugador.puntosTotales(),5);

    }

    @Test
    public void test06InicialmenteSepuedeUtilizarExclusividadDeAmbosJugadores(){
        Jugador jugador1 = new Jugador("Don Pepito");
        Jugador jugador2 = new Jugador("Don Jose");

        assert(jugador1.puedeUtilizarExclusividad());
        assert(jugador2.puedeUtilizarExclusividad());
    }

    @Test
    public void test07NingunJugadorPuedeUsarTresExclusividades(){
        Jugador jugador1 = new Jugador("Don Pepito");
        Jugador jugador2 = new Jugador("Don Jose");


        jugador1.activarExclusividad();
        jugador1.activarExclusividad();
        jugador2.activarExclusividad();
        jugador2.activarExclusividad();

        assertFalse(jugador1.puedeUtilizarExclusividad());
        assertFalse(jugador2.puedeUtilizarExclusividad());
    }

    @Test
    public void testo08LosJugadoresPuedeUtilizarExclusividadLuegoDeHaberlaUsadoUnaVezAnteriormente(){
        Jugador jugador1 = new Jugador("Don Pepito");
        Jugador jugador2 = new Jugador("Don Jose");

        jugador1.activarExclusividad();
        jugador2.activarExclusividad();

        assert(jugador1.puedeUtilizarExclusividad());
        assert(jugador2.puedeUtilizarExclusividad());
    }

    @Test
    public void test09UnJugadorAlCrearsePuedeUtilizarX3yX2(){
        Jugador jugador = new Jugador("Pablo");
        assert(jugador.puedeUtilizarx2() && jugador.puedeUtilizarx3());
    }

    @Test
    public void test10UnJugadorAlUsarUnX2yX3YaNoTieneUsosYPorLoTantoNoPuedeUtilizarlo(){
        Jugador jugador = new Jugador("Pablo");
        jugador.activarx2();
        jugador.activarx3();
        assertFalse(jugador.puedeUtilizarx2() && jugador.puedeUtilizarx3());
    }
}
