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
        CriterioVF mockedCriterioVF = mock(CriterioVF.class);
        Validez mockedValidez = mock(Correcta.class);

        when(mockedCriterioVF.validarCriterio(any(Opcion.class))).thenReturn(mockedValidez);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedOpcionCorrecta);

        respuesta.evaluarConCriterio(mockedCriterioVF);

        verify(mockedCriterioVF, times(1)).validarCriterio(any(Opcion.class));
    }

    @Test
    public void test02UnaRespuestaConValidezCuandoSePideQueRespondaAValidezSeLePideResponderAUnJugador(){
        Jugador mockedJugador = mock(Jugador.class);
        Opcion mockedOpcionCorrecta = mock(Opcion.class);
        CriterioVF mockedCriterioVF = mock(CriterioVF.class);
        Validez mockedValidez = mock(Correcta.class);

        when(mockedCriterioVF.validarCriterio(any(Opcion.class))).thenReturn(mockedValidez);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedOpcionCorrecta);
        respuesta.evaluarConCriterio(mockedCriterioVF);
        respuesta.responder();

        verify(mockedValidez, times(1)).responder(mockedJugador);
    }
}