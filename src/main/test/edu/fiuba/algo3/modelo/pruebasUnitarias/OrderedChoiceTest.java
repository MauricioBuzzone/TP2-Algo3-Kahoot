package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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


        Eleccion eleccionCorrecta = new Eleccion(correctas);
        OrderedChoice orderedChoice = new OrderedChoice(eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);

        orderedChoice.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void  test02OrderedChoiceRecibeUnaEleccionAcertadaYDevuelveUnCertificadoCorrecto(){

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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        OrderedChoice orderedChoice = new OrderedChoice(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);

        when(eleccion.estaEnOrden(eleccionCorrecta)).thenReturn(true);

        (orderedChoice.evaluarEleccion(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void  test03OrderedChoiceRecibeUnaEleccionIncorrectaYDevuelveUnCertificadoIncorrecto(){

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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        OrderedChoice orderedChoice = new OrderedChoice(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);

        when(eleccion.estaEnOrden(eleccionCorrecta)).thenReturn(false);

        (orderedChoice.evaluarEleccion(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }

    @Test
    public void test04UnaOrderedChoiseLanzaUnaExcepcionCuandoSeIntentaInicializarConMenosDeDosOcionesCorrectas(){

        String enunciado = "Ordenar años";

        String opcion1 = "Si";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    OrderedChoice orderedChoice = new OrderedChoice(eleccionCorrecta);
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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    OrderedChoice orderedChoice = new OrderedChoice(eleccionCorrecta);
                });
    }
    @Test
    public void  test06OrderedChoiceRecibeUnaEleccionConCantidadDeOpcionesMenorYDevuelveUnCertificadoIncorrecto(){

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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);

        Eleccion eleccionJugador = new Eleccion(opcionesJugador);


        OrderedChoice orderedChoice = new OrderedChoice(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);

        (orderedChoice.evaluarEleccion(eleccionJugador)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
    @Test
    public void  test06OrderedChoiceRecibeUnaEleccionConCantidadDeOpcionesMayorYDevuelveUnCertificadoIncorrecto(){

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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);

        Eleccion eleccionJugador = new Eleccion(opcionesJugador);


        OrderedChoice orderedChoice = new OrderedChoice(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);

        (orderedChoice.evaluarEleccion(eleccionJugador)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }

    @Test
    public void test7OrderedChoicePuedeInstanciarseConUnaListaDeOpcionesCorrectasEInstanciarUna(){

        String enunciado = new String("Pasos de TDD");
        String opcion1 = new String("Test");
        String opcion2 = new String("Code");
        String opcion3 = new String("Refactor");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);


        TipoDePregunta orderedChoice = new OrderedChoice(solucion);

        Eleccion eleccionJugador = orderedChoice.crearEleccion(solucion);

        Certificado certificado = orderedChoice.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }


}