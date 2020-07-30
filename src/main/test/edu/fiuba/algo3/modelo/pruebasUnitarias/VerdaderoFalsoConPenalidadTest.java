package edu.fiuba.algo3.modelo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoConPenalidadTest {

    @Test
    public void test01evaluarRespuestasAplicaEvaluarConCriterioACadaRespuestaEnviada(){

        String solucion = "Falso";
        String enunciado = "En FIUBA hay 11 carreras";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);

        verdaderoFalsoConPenalidad.evaluarRespuestas(respuestas);

        verify(mockRespuesta, times(1)).evaluarConCriterio(any(CriterioVerdaderoFalsoConPenalidad.class));
        verify(mockRespuesta2, times(1)).evaluarConCriterio(any(CriterioVerdaderoFalsoConPenalidad.class));
    }

    @Test
    public void test02responderPreguntaAplicaResponderACadaRespuestaEnviada(){
        String solucion = "Verdadero";
        String enunciado = "En caballo blanco de San Martin es blanco";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        verdaderoFalsoConPenalidad.responderPregunta(respuestas);

        verify(mockRespuesta, times(1)).responder();
        verify(mockRespuesta2, times(1)).responder();
        verify(mockRespuesta3, times(1)).responder();
    }

    @Test
    public void test03UnaPreguntaVerdaderoFalsoConPenalidadCuandoSeLaCreaConMasDeDosRespuestasCorrectasLanzaExcepcion(){

        String enunciado = "El gato de Schrodinger esta muerto";
        String solucion1 = "Verdadero";
        String solucion2 = "Falso";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion1);
        opcion.add(solucion2);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        assertThrows(SolucionInvalidaException.class,
                ()->{
                    VerdaderoFalsoConPenalidad pregunta = new VerdaderoFalsoConPenalidad(enunciado, eleccionCorrecta);
                });
    }
}
