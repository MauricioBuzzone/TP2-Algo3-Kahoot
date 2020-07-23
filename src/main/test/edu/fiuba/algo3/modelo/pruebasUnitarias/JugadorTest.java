package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01UnJugadorAlResponderBienObtienePuntos(){

        Jugador jugador = new Jugador("Tomas");

        jugador.responderBien();

        assert (jugador.puntosTotales() > 0);
    }

    @Test
    public void test02UnJugadorAlResponderMalNoSeLeSumanPuntos(){

        Jugador jugador = new Jugador("Tomas");

        jugador.responderMal();

        assertEquals(jugador.puntosTotales(),0);

    }

    @Test
    public void test03UnJugadorAlResponderParcialementeBienSeLeSumanPuntosPeroMenosQueSiHubieseRespondidoBien(){

        Jugador jugadorUno = new Jugador("Tomas");
        Jugador JugadorDos = new Jugador("Pablo");

        jugadorUno.responderBien();
        JugadorDos.responderParcial();

        assert(jugadorUno.puntosTotales() > JugadorDos.puntosTotales());

    }



}
