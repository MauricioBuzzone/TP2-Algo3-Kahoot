package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.*;

public class RespuestaTest {

    @Test
    public void test01UnaRespuestaSeRespondeSegunUnEvaluadorVFYLePideAlEvaluadorQueEvalueSuOpcion(){

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion mockedEleccionCorrecta = mock(Eleccion.class);
        Evaluador mockedEvaluadorVerdaderoFalso = mock(VerdaderoFalso.class);
        Puntaje mockedPuntaje = mock(Puntaje.class);
        Bonificador mockedBonificador = mock(Bonificador.class);

        when(mockedEvaluadorVerdaderoFalso.evaluarEleccion(any(Eleccion.class))).thenReturn(mockedPuntaje);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedEleccionCorrecta, mockedBonificador);

        respuesta.responderSegunEvaluador(mockedEvaluadorVerdaderoFalso);

        verify(mockedEvaluadorVerdaderoFalso, times(1)).evaluarEleccion(any(Eleccion.class));
    }

    @Test
    public void test02UnaRespuestaSeRespondeSegunUnEvaluadorVFSeLePideResponderAUnJugador(){
        Jugador mockedJugador = mock(Jugador.class);
        Eleccion mockedEleccionCorrecta = mock(Eleccion.class);
        Evaluador mockedEvaluadorVerdaderoFalso = mock(VerdaderoFalso.class);
        Puntaje mockedPuntaje = mock(Puntaje.class);
        Bonificador mockedBonificador = mock(Bonificador.class);

        when(mockedEvaluadorVerdaderoFalso.evaluarEleccion(any(Eleccion.class))).thenReturn(mockedPuntaje);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedEleccionCorrecta, mockedBonificador);
        respuesta.responderSegunEvaluador(mockedEvaluadorVerdaderoFalso);
        respuesta.actualizarPuntaje();

        verify(mockedJugador, times(1)).responder(any(Puntaje.class), any(Bonificador.class));
    }

    @Test
    public void test03UnaRespuestaSeRespondeYSeEvaluaLaEleccion(){
        Jugador mockedJugador = mock(Jugador.class);
        Eleccion mockedEleccionCorrecta = mock(Eleccion.class);
        Evaluador mockedEvaluadorVerdaderoFalso = mock(VerdaderoFalso.class);
        Puntaje mockedPuntaje = mock(Puntaje.class);
        Bonificador mockedBonificador = mock(Bonificador.class);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedEleccionCorrecta, mockedBonificador);
        respuesta.responderSegunEvaluador(mockedEvaluadorVerdaderoFalso);

        verify(mockedEvaluadorVerdaderoFalso, times(1)).evaluarEleccion(mockedEleccionCorrecta);
    }

    @Test
    public void test04UnaRespuestaConEleccionCorrectaCuandoLlamanARespuestaCorrectaConEvaluadorDevuelveTrue(){

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion mockedEleccionCorrecta = mock(Eleccion.class);
        Evaluador mockedEvaluadorVerdaderoFalso = mock(VerdaderoFalso.class);
        Puntaje mockedPuntaje = mock(Puntaje.class);
        Bonificador mockedBonificador = mock(Bonificador.class);

        Evaluador mockEvaluador = mock(Evaluador.class);
        when(mockEvaluador.esCorrecta(any(Eleccion.class))).thenReturn(true);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedEleccionCorrecta, mockedBonificador);

        assertTrue(respuesta.respuestaCorrecta(mockEvaluador));
    }
}