package edu.fiuba.algo3.modelo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void test01responderPreguntaConDosRespuestasAplicaResponderConCriterioACadaRespuestaEnviada(){

        String solucion = "Seeee";
        String enunciado = "Se aprueba la entrega 0?";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);

        verdaderoFalso.responderPregunta(respuestas);

        verify(mockRespuesta, times(1)).responderConCriterio(any(CriterioVerdaderoFalso.class));
        verify(mockRespuesta2, times(1)).responderConCriterio(any(CriterioVerdaderoFalso.class));
    }

    @Test
    public void test02responderPreguntaConTresRespuestasAplicaResponderConCriterioACadaRespuestaEnviada(){
        String solucion = "Seeee";
        String enunciado = "Se aprueba la entrega 0?";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        verdaderoFalso.responderPregunta(respuestas);

        verify(mockRespuesta, times(1)).responderConCriterio(any(CriterioVerdaderoFalso.class));
        verify(mockRespuesta2, times(1)).responderConCriterio(any(CriterioVerdaderoFalso.class));
        verify(mockRespuesta3, times(1)).responderConCriterio(any(CriterioVerdaderoFalso.class));
    }


    @Test
    public void test03UnaPreguntaVerdaderoFalsoCuandoSeLaCreaConMasDeDosRespuestasCorrectasLanzaExcepcion(){

        String enunciado = "El gato de Schrodinger esta muerto";
        String solucion1 = "Verdadero";
        String solucion2 = "Falso";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion1);
        opcion.add(solucion2);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        assertThrows(SolucionInvalidaException.class,
                ()->{
                    VerdaderoFalso pregunta = new VerdaderoFalso(enunciado, eleccionCorrecta);
                });
    }
}
