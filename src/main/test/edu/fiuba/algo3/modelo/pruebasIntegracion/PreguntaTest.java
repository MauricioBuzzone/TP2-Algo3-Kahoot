package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PreguntaTest {

    @Test
    public void test01UnaPreguntaDeVFCPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";

        List<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add(solucion);

        Eleccion eleccionCorrecta = new Eleccion(opcionCorrecta);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

    }

    @Test
    public void test02UnaPreguntaDeVFCRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";

        List<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add(solucion);

        Eleccion eleccionCorrecta = new Eleccion(opcionCorrecta);
        Pregunta verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add("Falso");
        Eleccion eleccionDiego = new Eleccion(opcionDiego);


        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add("Verdadero");
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

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
        List<String> opcionCorrectaUno = new ArrayList<String>();
        opcionCorrectaUno.add(solucionUno);
        Eleccion eleccionCorrectaUno = new Eleccion(opcionCorrectaUno);
        Pregunta preguntaUno = new VerdaderoFalso(enunciadoUno, eleccionCorrectaUno);

        List<String> opcionDiegoUno = new ArrayList<String>();
        opcionDiegoUno.add("Falso");
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);

        List<String> opcionTomasUno = new ArrayList<String>();
        opcionTomasUno.add("Verdadero");
        Eleccion primeraEleccionTomas = new Eleccion(opcionTomasUno);

        Respuesta primeraRespuestaDiego = new Respuesta(diego, primeraEleccionDiego);
        Respuesta primeraRespuestaTomas = new Respuesta(tomas, primeraEleccionTomas);
        ArrayList<Respuesta> respuestasUno = new ArrayList<Respuesta>();
        respuestasUno.add(primeraRespuestaDiego);
        respuestasUno.add(primeraRespuestaTomas);

        preguntaUno.evaluarRespuestas(respuestasUno);
        preguntaUno.responderPregunta(respuestasUno);




        String enunciadoDos = "Tomás nunca pintó con salsa de tomate";
        String solucionDos = "Falso";
        List<String> opcionCorrectaDos = new ArrayList<String>();
        opcionCorrectaDos.add(solucionDos);

        Eleccion eleccionCorrectaDos = new Eleccion(opcionCorrectaDos);
        Pregunta preguntaDos = new VerdaderoFalso(enunciadoDos, eleccionCorrectaDos);


        List<String> opcionDiegoDos = new ArrayList<String>();
        opcionDiegoDos.add("Falso");
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);

        List<String> opcionTomasDos = new ArrayList<String>();
        opcionTomasDos.add("Falso");
        Eleccion segundaEleccionTomas = new Eleccion(opcionTomasDos);

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
