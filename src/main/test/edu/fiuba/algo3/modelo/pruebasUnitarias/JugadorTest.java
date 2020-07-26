package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01UnJugadorAlResponderBienObtienePuntos(){

        Jugador jugador = new Jugador("Tomas");

        jugador.responderBien(4);

        assertEquals(jugador.puntosTotales(), 4);
    }

    @Test
    public void test02UnJugadorAlResponderMalTieneCeroPuntos(){

        Jugador jugador = new Jugador("Tomas");

        jugador.responderMal(2);

        assertEquals(jugador.puntosTotales(),0);

    }

    @Test
    public void test03UnJugadorAlResponderMalNoSeLeSumanPuntosYTieneMenosQueSiHubieseRespondidoBien(){

        Jugador jugadorUno = new Jugador("Tomas");
        Jugador JugadorDos = new Jugador("Pablo");

        jugadorUno.responderBien(5);
        JugadorDos.responderMal(5);

        assert(jugadorUno.puntosTotales() > JugadorDos.puntosTotales());

    }

    @Test
    public void test04UnJugadorAlResponderMalDadoQuePreviamenteRespondioBienLeQuitanPuntos(){

        Jugador jugador = new Jugador("Tomas");

        jugador.responderBien(5);
        jugador.responderMal(2);

        assertEquals(jugador.puntosTotales(),3);

    }

    @Test
    public void test05UnJugadorRespondeMalSinPenalizacionNoLeRestanPuntos(){

        Jugador jugador = new Jugador("Tomas");

        jugador.responderBien(5);
        jugador.responderMal(0);

        assertEquals(jugador.puntosTotales(),5);

    }



}
