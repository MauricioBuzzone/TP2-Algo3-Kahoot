package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.SolucionInvalidaException;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.TipoDePregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderedChoiceTest {

    @Test
    public void test01ResponderPreguntaConUnaRespuestasAplicaResponderConEvaluadorACadaRespuestaEnviada(){

        String enunciado = "Ordernar estos nuemro de mayor a menor";

        Opcion opcion1 = new OpcionOrdenada("1", 1);
        Opcion opcion2 = new OpcionOrdenada("2", 2);
        Opcion opcion3 = new OpcionOrdenada("3", 3);
        Opcion opcion4 = new OpcionOrdenada("4", 4);
        Opcion opcion5 = new OpcionOrdenada("5", 5);

        List<Opcion> correctas = new ArrayList<Opcion>();
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
        Opcion opcion1 = new OpcionOrdenada("6/Enero/1929", 1);
        Opcion opcion2 = new OpcionOrdenada("20/Marzo/2012", 4);
        Opcion opcion3 = new OpcionOrdenada("24/Julio/1942", 2);
        Opcion opcion4 = new OpcionOrdenada("26/Agosto/2000", 3);

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);
        correctas.add(opcion4);

        TipoDePregunta orderedChoice = new OrderedChoice(correctas);

        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(true);

        Puntaje puntaje =orderedChoice.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }

    @Test
    public void  test03OrderedChoiceRecibeUnaEleccionIncorrectaYDevuelvePuntajeDeValorCero(){

        String enunciado = "Ordenar segun orden cronologico ";
        Opcion opcion1 = new OpcionOrdenada("6/Enero/1929", 1);
        Opcion opcion2 = new OpcionOrdenada("20/Marzo/2012", 4);
        Opcion opcion3 = new OpcionOrdenada("24/Julio/1942", 2);
        Opcion opcion4 = new OpcionOrdenada("26/Agosto/2000", 3);

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);
        correctas.add(opcion4);


        TipoDePregunta orderedChoice = new OrderedChoice(correctas);

        Eleccion eleccion = mock(Eleccion.class);

        when(eleccion.igualA(any(Eleccion.class))).thenReturn(false);

        Puntaje puntaje =orderedChoice.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }

    @Test
    public void test04UnaOrderedChoiseLanzaUnaExcepcionCuandoSeIntentaInicializarConMenosDeDosOcionesCorrectas(){

        String enunciado = "Ordenar años";

        Opcion opcion1 = new OpcionOrdenada("Si", 1);

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion1);


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    TipoDePregunta orderedChoice = new OrderedChoice(correctas);
                });
    }
    @Test
    public void test05UnaOrderedChoiseLanzaUnaExcepcionCuandoSeIntentaInicializarConMasDeCincoOcionesCorrectas(){

        String enunciado = "Ordenar años";

        Opcion opcion1 = new OpcionOrdenada("frula", 1);

        List<Opcion> correctas = new ArrayList<Opcion>();
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
        Opcion opcion1 = new OpcionOrdenada("6/Enero/1929", 1);
        Opcion opcion2 = new OpcionOrdenada("20/Marzo/2012", 4);
        Opcion opcion3 = new OpcionOrdenada("24/Julio/1942", 2);
        Opcion opcion4 = new OpcionOrdenada("26/Agosto/2000", 3);

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);
        correctas.add(opcion4);

        List<Opcion> opcionesJugador = new ArrayList<Opcion>();
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
        Opcion opcion1 = new OpcionOrdenada("6/Enero/1929", 1);
        Opcion opcion2 = new OpcionOrdenada("20/Marzo/2012", 4);
        Opcion opcion3 = new OpcionOrdenada("24/Julio/1942", 2);
        Opcion opcion4 = new OpcionOrdenada("26/Agosto/2000", 3);

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);
        correctas.add(opcion4);


        List<Opcion> opcionesJugador = new ArrayList<Opcion>();
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
        Opcion opcion1 = new OpcionOrdenada("Test", 1);
        Opcion opcion2 = new OpcionOrdenada("Code", 2);
        Opcion opcion3 = new OpcionOrdenada("Refactor", 3);

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);


        TipoDePregunta orderedChoice = new OrderedChoice(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Puntaje puntaje = orderedChoice.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }


}