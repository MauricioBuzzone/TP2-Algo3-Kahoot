package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ValidezTest{

    @Test
    public void test01CorrectaRecibeUnJugadorYResponde(){

        Jugador mockedJugador = mock(Jugador.class);
        Correcta validez = new Correcta();

        validez.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien();
    }
    @Test
    public void test01IncorretaRecibeUnJugadorYResponde(){

        Jugador mockedJugador = mock(Jugador.class);
        Incorrecta validez = new Incorrecta();

        validez.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal();
    }
}