package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class OrderedChoiceTest {

    @Test
    public void test01ResponderPreguntaConUnaRespuestasAplicaResponderConEvaluadorACadaRespuestaEnviada(){

        String enunciado = "Ordernar estos nuemro de mayor a menor";

        String opcion1 = "1";
        String opcion2 = "2";
        String opcion3 = "3";
        String opcion4 = "4";
        String opcion5 = "5";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion2);
        correctas.add(opcion4);
        correctas.add(opcion5);


        TipoDePregunta orderedChoice = new OrderedChoice(correctas);

        Respuesta mockRespuesta = mock(Respuesta.class);

        orderedChoice.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void  test02OrderedChoiceRecibeUnaEleccionAcertadaYDevuelvePuntajeDeValorUno(){

        String enunciado = "Ordenar segun orden cronologico ";
        String opcion1 = " 6/Enero/1929";
        String opcion2 = " 20/Marzo/2012";
        String opcion3 = " 24/Julio/1942";
        String opcion4 = " 26/Agosto/2000";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion3);
        correctas.add(opcion4);
        correctas.add(opcion2);

        TipoDePregunta orderedChoice = new OrderedChoice(correctas);

        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.estaEnOrden(any(Eleccion.class))).thenReturn(true);

        Puntaje puntaje =orderedChoice.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }

    @Test
    public void  test03OrderedChoiceRecibeUnaEleccionIncorrectaYDevuelvePuntajeDeValorCero(){

        String enunciado = "Ordenar segun orden cronologico ";
        String opcion1 = " 6/Enero/1929";
        String opcion2 = " 20/Marzo/2012";
        String opcion3 = " 24/Julio/1942";
        String opcion4 = " 26/Agosto/2000";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion3);
        correctas.add(opcion4);
        correctas.add(opcion2);


        TipoDePregunta orderedChoice = new OrderedChoice(correctas);

        Eleccion eleccion = mock(Eleccion.class);

        when(eleccion.estaEnOrden(any(Eleccion.class))).thenReturn(false);

        Puntaje puntaje =orderedChoice.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }

    @Test
    public void test04UnaOrderedChoiseLanzaUnaExcepcionCuandoSeIntentaInicializarConMenosDeDosOcionesCorrectas(){

        String enunciado = "Ordenar años";

        String opcion1 = "Si";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    TipoDePregunta orderedChoice = new OrderedChoice(correctas);
                });
    }
    @Test
    public void test05UnaOrderedChoiseLanzaUnaExcepcionCuandoSeIntentaInicializarConMasDeCincoOcionesCorrectas(){

        String enunciado = "Ordenar años";

        String opcion1 = "frula";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion1);
        correctas.add(opcion1);
        correctas.add(opcion1);
        correctas.add(opcion1);
        correctas.add(opcion1);


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    TipoDePregunta orderedChoice = new OrderedChoice(correctas);
                });
    }
    @Test
    public void  test06OrderedChoiceRecibeUnaEleccionConCantidadDeOpcionesMenorYDevuelvePuntajeDeValorCero(){

        String enunciado = "Ordenar segun orden cronologico ";
        String opcion1 = " 6/Enero/1929";
        String opcion2 = " 20/Marzo/2012";
        String opcion3 = " 24/Julio/1942";
        String opcion4 = " 26/Agosto/2000";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion3);
        correctas.add(opcion4);
        correctas.add(opcion2);

        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);

        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        TipoDePregunta orderedChoice = new OrderedChoice(correctas);

        Puntaje puntaje =orderedChoice.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
    @Test
    public void  test07OrderedChoiceRecibeUnaEleccionConCantidadDeOpcionesMayorYDevuelveUnPuntajeDeValorCero(){

        String enunciado = "Ordenar segun orden cronologico ";
        String opcion1 = " 6/Enero/1929";
        String opcion2 = " 20/Marzo/2012";
        String opcion3 = " 24/Julio/1942";
        String opcion4 = " 26/Agosto/2000";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion3);
        correctas.add(opcion4);
        correctas.add(opcion2);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);

        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        TipoDePregunta orderedChoice = new OrderedChoice(correctas);

        Puntaje puntaje =orderedChoice.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }

    @Test
    public void test08OrderedChoiceEvaluaRespuestaCorrectaYDevuelvePuntajeDeValorUno(){

        String enunciado = "Pasos de TDD";
        String opcion1 = "Test";
        String opcion2 = "Code";
        String opcion3 = "Refactor";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);


        TipoDePregunta orderedChoice = new OrderedChoice(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Puntaje puntaje = orderedChoice.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), 1);
    }


}