package edu.fiuba.algo3.modelo.pruebasUnitarias;
import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.mockito.Mockito.*;

public class RespuestaTest {

    @Test
    public void test01UnaRespuestaSeRespondeSegunUnEvaluadorVFYLePideAlEvaluadorQueEvalueSuOpcion(){
        // public Respuesta(Jugador jugador, Opcion opcion) {
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

        verify(mockedJugador, times(1)).responder(mockedPuntaje, mockedBonificador);
    }
}