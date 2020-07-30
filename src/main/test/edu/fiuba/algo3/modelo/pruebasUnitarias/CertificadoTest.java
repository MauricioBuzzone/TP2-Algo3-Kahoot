package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CertificadoTest {

    @Test
    public void test01CorrectaRecibeUnJugadorYResponde(){

        Jugador mockedJugador = mock(Jugador.class);
        Correcta validez = new Correcta(8);

        validez.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(8);
    }
    @Test
    public void test02IncorretaRecibeUnJugadorYResponde(){

        Jugador mockedJugador = mock(Jugador.class);
        Incorrecta validez = new Incorrecta(7);

        validez.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(7);
    }
    @Test
    public void test03CorretaLanzaUnaExcepcionAlInstanciarConPuntosNegativos(){

        assertThrows(PuntosInvalidosException.class,
                ()->{
                    Certificado correcta = new Correcta(-4);
                });
    }
    @Test
    public void test04IncorretaLanzaUnaExcepcionAlInstanciarConPuntosNegativos(){

        assertThrows(PuntosInvalidosException.class,
                ()->{
                    Certificado incorrecta = new Incorrecta(-4);
                });
    }
}