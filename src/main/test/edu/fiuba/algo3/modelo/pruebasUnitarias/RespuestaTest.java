package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RespuestaTest {

    @Test
    public void test01UnaRespuestaSeEvaluaConUnCriterioYLePideAlCriterioQueEvalueSuOpcion(){
        // public Respuesta(Jugador jugador, Opcion opcion) {
        Jugador mockedJugador = mock(Jugador.class);
        Eleccion mockedEleccionCorrecta = mock(Eleccion.class);
        Evaluador mockedEvaluadorVerdaderoFalso = mock(VerdaderoFalso2.class);
        Certificado mockedCertificado = mock(Correcta.class);

        when(mockedEvaluadorVerdaderoFalso.evaluarEleccion(any(Eleccion.class))).thenReturn(mockedCertificado);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedEleccionCorrecta);

        respuesta.responderConEvaluador(mockedEvaluadorVerdaderoFalso);

        verify(mockedEvaluadorVerdaderoFalso, times(1)).evaluarEleccion(any(Eleccion.class));
    }

    @Test
    public void test02UnaRespuestaConValidezCuandoSePideQueRespondaAValidezSeLePideResponderAUnJugador(){
        Jugador mockedJugador = mock(Jugador.class);
        Eleccion mockedEleccionCorrecta = mock(Eleccion.class);
        Evaluador mockedEvaluadorVerdaderoFalso = mock(VerdaderoFalso2.class);
        Certificado mockedCertificado = mock(Correcta.class);

        when(mockedEvaluadorVerdaderoFalso.evaluarEleccion(any(Eleccion.class))).thenReturn(mockedCertificado);

        Respuesta respuesta = new Respuesta(mockedJugador, mockedEleccionCorrecta);
        respuesta.responderConEvaluador(mockedEvaluadorVerdaderoFalso);

        verify(mockedCertificado, times(1)).responder(mockedJugador);
    }
}