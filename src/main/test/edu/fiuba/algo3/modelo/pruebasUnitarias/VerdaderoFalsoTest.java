package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void test01evaluarRespuestasAplicaEvaluarConCriterioACadaRespuestaEnviada(){

        String solucion = "Seeee";
        String enunciado = "Se aprueba la entrega 0?";
        Eleccion eleccionCorrecta = new Eleccion(solucion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);

        verdaderoFalso.evaluarRespuestas(respuestas);

        verify(mockRespuesta, times(1)).evaluarConCriterio(any(CriterioVerdaderoFalso.class));
        verify(mockRespuesta2, times(1)).evaluarConCriterio(any(CriterioVerdaderoFalso.class));
    }

    @Test
    public void test02responderPreguntaAplicaResponderACadaRespuestaEnviada(){
        String solucion = "Seeee";
        String enunciado = "Se aprueba la entrega 0?";
        Eleccion eleccionCorrecta = new Eleccion(solucion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        verdaderoFalso.responderPregunta(respuestas);

        verify(mockRespuesta, times(1)).responder();
        verify(mockRespuesta2, times(1)).responder();
        verify(mockRespuesta3, times(1)).responder();
    }
}
