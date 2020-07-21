package edu.fiuba.algo3.modelo;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegracionTest {

    @Test
    public void test01UnaPreguntaDeVFCPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";
        Opcion opcionCorrecta = new Opcion(solucion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, opcionCorrecta);

    }

    @Test
    public void test02UnaPreguntaDeVFCRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente(){

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";
        Opcion opcionCorrecta = new Opcion(solucion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, opcionCorrecta);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        Opcion eleccionDiego = new Opcion("Falso");
        Opcion eleccionTomas = new Opcion("Verdadero");

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        verdaderoFalso.evaluarRespuestas(respuestas);
        verdaderoFalso.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 0);
        assert(tomas.puntosTotales() > 0);

    }




}
