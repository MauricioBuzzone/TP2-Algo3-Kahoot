package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PreguntaTest {

    @Test
    public void test01UnaPreguntaDeVFCPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";
        Eleccion eleccionCorrecta = new Eleccion(solucion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

    }

    @Test
    public void test02UnaPreguntaDeVFCRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";
        Eleccion eleccionCorrecta = new Eleccion(solucion);
        Pregunta verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        Eleccion eleccionDiego = new Eleccion("Falso");
        Eleccion eleccionTomas = new Eleccion("Verdadero");

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        verdaderoFalso.evaluarRespuestas(respuestas);
        verdaderoFalso.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 0);
        assert (tomas.puntosTotales() > 0);

    }

    @Test
    public void test03UnJugadorQueRespondeDosPreguntasBienTieneMasPuntosQueUnJugadorQueRespondeUnaBienYUnaMal() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomás");

        String enunciadoUno = "Diego es pintorRodillo";
        String solucionUno = "Verdadero";
        Eleccion eleccionCorrectaUno = new Eleccion(solucionUno);
        Pregunta preguntaUno = new VerdaderoFalso(enunciadoUno, eleccionCorrectaUno);

        Eleccion primeraEleccionDiego = new Eleccion("Falso");
        Eleccion primeraEleccionTomas = new Eleccion("Verdadero");

        Respuesta primeraRespuestaDiego = new Respuesta(diego, primeraEleccionDiego);
        Respuesta primeraRespuestaTomas = new Respuesta(tomas, primeraEleccionTomas);
        ArrayList<Respuesta> respuestasUno = new ArrayList<Respuesta>();
        respuestasUno.add(primeraRespuestaDiego);
        respuestasUno.add(primeraRespuestaTomas);

        preguntaUno.evaluarRespuestas(respuestasUno);
        preguntaUno.responderPregunta(respuestasUno);

        String enunciadoDos = "Tomás nunca pintó con salsa de tomate";
        String solucionDos = "Falso";
        Eleccion eleccionCorrectaDos = new Eleccion(solucionDos);
        Pregunta preguntaDos = new VerdaderoFalso(enunciadoDos, eleccionCorrectaDos);

        Eleccion segundaEleccionDiego = new Eleccion("Falso");
        Eleccion segundaEleccionTomas = new Eleccion("Falso");

        Respuesta segundaRespuestaDiego = new Respuesta(diego, segundaEleccionDiego);
        Respuesta segundaRespuestaTomas = new Respuesta(tomas, segundaEleccionTomas);
        ArrayList<Respuesta> respuestasDos = new ArrayList<Respuesta>();
        respuestasDos.add(segundaRespuestaDiego);
        respuestasDos.add(segundaRespuestaTomas);

        preguntaDos.evaluarRespuestas(respuestasDos);
        preguntaUno.responderPregunta(respuestasDos);

        assert (tomas.puntosTotales() > diego.puntosTotales());
    }

}
