package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01UnJugadorAlResponderBienObtienePuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje = crearPuntajeFavorable(4);

        jugador.responder(puntaje);

        assertEquals(jugador.puntosTotales(), 4);
    }

    @Test
    public void test02UnJugadorAlResponderMalTieneCeroPuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje = crearPuntajeFavorable(0);

        jugador.responder(puntaje);

        assertEquals(jugador.puntosTotales(),0);

    }

    @Test
    public void test03UnJugadorAlResponderMalNoSeLeSumanPuntosYTieneMenosQueSiHubieseRespondidoBien(){

        Jugador jugadorUno = new Jugador("Tomas");
        Jugador JugadorDos = new Jugador("Pablo");

        Puntaje puntaje1 = crearPuntajeFavorable(5);
        Puntaje puntaje2 = crearPuntajeDesfavorable(5);

        jugadorUno.responderBien(puntaje1);
        JugadorDos.responderMal(puntaje2);

        assert(jugadorUno.puntosTotales() > JugadorDos.puntosTotales());

    }

    @Test
    public void test04UnJugadorAlResponderMalDadoQuePreviamenteRespondioBienLeQuitanPuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje1 = crearPuntajeFavorable(5);
        Puntaje puntaje2 = crearPuntajeDesfavorable(2);

        jugador.responderBien(puntaje1);
        jugador.responderMal(puntaje2);

        assertEquals(jugador.puntosTotales(),3);

    }

    @Test
    public void test05UnJugadorRespondeMalSinPenalizacionNoLeRestanPuntos(){

        Jugador jugador = new Jugador("Tomas");

        Puntaje puntaje = crearPuntajeFavorable(5);
        Puntaje puntaje = crearPuntajeDesfavorable(0);

        jugador.responderBien(5);
        jugador.responderMal(0);

        assertEquals(jugador.puntosTotales(),5);

    }



}
