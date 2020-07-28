package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MultipleChoicePuntajeParcialTest{
    @Test
    public void test01MCPPAlEvaluarUnaRespuestaLePasaElCriterioCorrespondiente(){
        String enunciado = "¿Quiénes son profesores de AMII?";

        String opcion1 = "Sirne";
        String opcion2 = "Acero";
        String opcion3 = "Unger";
        String opcion4 = "Vargas";
        String opcion5 = "Piva";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        MultipleChoicePuntajeParcial multipleChoicePuntajeParcial=new MultipleChoicePuntajeParcial(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);

        multipleChoicePuntajeParcial.evaluarRespuestas(respuestas);

        verify(mockRespuesta, times(1)).evaluarConCriterio(any(CriterioMultipleChoiceParcial.class));

    }

    @Test
    public void test02responderPreguntaAplicaResponderACadaRespuestaEnviada(){

        String enunciado = "¿Cuales no son principios SOLID";

        String opcion1 = "Liskov";
        String opcion2 = "Close-Open";
        String opcion3 = "Single Responsability";
        String opcion4 = "Herencia de Markov";
        String opcion5 = "Design driven development";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion2);
        correctas.add(opcion4);
        correctas.add(opcion5);

        Eleccion eleccionCorrecta = new Eleccion(correctas);
        MultipleChoicePuntajeParcial multipleChoice = new MultipleChoicePuntajeParcial(enunciado, eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(mockRespuesta);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        multipleChoice.responderPregunta(respuestas);

        verify(mockRespuesta, times(1)).responder();
        verify(mockRespuesta2, times(1)).responder();
        verify(mockRespuesta3, times(1)).responder();
    }
}
