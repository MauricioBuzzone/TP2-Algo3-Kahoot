package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RespuestaTest {

    @Test
    public void test01UnaRespuestaSeEvaluaConUnCriterioYLePideAlCriterioQueEvalueSuOpcion(){
        // public Respuesta(Jugador jugador, Opcion opcion) {
        Jugador mockedJugador = mock(Jugador.class);
        Opcion mockedOpcionCorrecta = mock(Opcion.class);
        Criterio mockedCriterio = mock(Criterio.class);
        Validez mockedValidez = mock(Correcta.class);

        when(mockedCriterio.validarCriterio(mockedOpcionCorrecta)).thenReturn(mockedValidez);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedOpcionCorrecta);

        respuesta.evaluarConCriterio(mockedCriterio);

        verify(mockedCriterio, times(1)).validarCriterio(mockedOpcionCorrecta);
    }

    @Test
    public void test02UnaRespuestaConValidezCuandoSePideQueRespondaAValidezSeLePideResponderAUnJugador(){
        Jugador mockedJugador = mock(Jugador.class);
        Opcion mockedOpcionCorrecta = mock(Opcion.class);
        Criterio mockedCriterio = mock(Criterio.class);
        Validez mockedValidez = mock(Correcta.class);

        when(mockedCriterio.validarCriterio(mockedOpcionCorrecta)).thenReturn(mockedValidez);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedOpcionCorrecta);
        respuesta.evaluarConCriterio(mockedCriterio);
        respuesta.responder();

        verify(mockedValidez, times(1)).responder(mockedJugador);
    }
}