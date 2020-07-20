package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidezTest{

    @Test
    public void test01CorrectaRecibeUnJugadorYResponde{

        Jugador mockedJugador = mock(Jugador.class);
        Correcta validez = new Correcta;

        validez.responder(mockedJugadorUno);

        verify(mockedJugador, times(1)).responderBien();
    }
    @Test
    public void test01IncorretaRecibeUnJugadorYResponde{

        Jugador mockedJugador = mock(Jugador.class);
        InCorrecta validez = new InCorrecta;

        validez.responder(mockedJugadorUno);

        verify(mockedJugador, times(1)).responderMal();
    }
}