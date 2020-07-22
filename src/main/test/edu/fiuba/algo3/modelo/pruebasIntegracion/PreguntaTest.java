package edu.fiuba.algo3.modelo;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PreguntaTest {

    @Test
    public void test01UnaPreguntaDeVFCPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";
        Opcion opcionCorrecta = new Opcion(solucion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, opcionCorrecta);

    }

    @Test
    public void test02UnaPreguntaDeVFCRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente() {

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
        assert (tomas.puntosTotales() > 0);

    }

    @Test
    public void test03UnJugadorQueRespondeDosPreguntasBienTieneMasPuntosQueUnJugadorQueRespondeUnaBienYUnaMal() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomás");

        String enunciadoUno = "Diego es pintorRodillo";
        String solucionUno = "Verdadero";
        Opcion opcionCorrectaUno = new Opcion(solucionUno);
        VerdaderoFalso preguntaUno = new VerdaderoFalso(enunciadoUno, opcionCorrectaUno);

        Opcion primeraEleccionDiego = new Opcion("Falso");
        Opcion primeraEleccionTomas = new Opcion("Verdadero");

        Respuesta primeraRespuestaDiego = new Respuesta(diego, primeraEleccionDiego);
        Respuesta primeraRespuestaTomas = new Respuesta(tomas, primeraEleccionTomas);
        ArrayList<Respuesta> respuestasUno = new ArrayList<Respuesta>();
        respuestasUno.add(primeraRespuestaDiego);
        respuestasUno.add(primeraRespuestaTomas);

        preguntaUno.evaluarRespuestas(respuestasUno);
        preguntaUno.responderPregunta(respuestasUno);

        String enunciadoDos = "Tomás nunca pintó con salsa de tomate";
        String solucionDos = "Falso";
        Opcion opcionCorrectaDos = new Opcion(solucionDos);
        VerdaderoFalso preguntaDos = new VerdaderoFalso(enunciadoDos, opcionCorrectaDos);

        Opcion segundaEleccionDiego = new Opcion("Falso");
        Opcion segundaEleccionTomas = new Opcion("Falso");

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
