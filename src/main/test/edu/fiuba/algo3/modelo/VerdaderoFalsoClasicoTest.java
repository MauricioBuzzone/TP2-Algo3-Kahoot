package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class VerdaderoFalsoClasicoTest{
    @Test
    public void test01VerdaderoFalsoClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){

        String enunciado = "Vamos a aprobar la entrega 0";
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico(enunciado,true);

    }
    @Test
    public void test02VerdaderoFalsoClasicoRecibeUnaListaDeRespuestaYAsignaCorrectamentePuntosALosJugadores(){

        Jugador mockedJugadorUno = mock(Jugador.class);
        Jugador mockedJugadorDos = mock(Jugador.class);

        List<String> opciones = new List<String>();
        opciones.add('True');
        opciones.add('False');

        when(mockedJugadorUno.responder(opciones)).thenReturn(true);
        when(mockedJugadorDos.responder(opciones)).thenReturn(false);

        String enunciado = "Vamos a aprobar la entrega 0";
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico(enunciado,true);

        boolean respuestaUno = mockedJugadorUno.responder(opciones);
        boolean respuestaDos = mockedJugadorDos.responder(opciones);

        assert (pregunta.responder(respuestaUno))== 1;
        assert (pregunta.responder(respuestaDos))== 0;
    }
}