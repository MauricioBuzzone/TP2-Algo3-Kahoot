package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PreguntaTest {

    @Test
    public void test0_1UnaPreguntaDeVFCPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";

        List<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add(solucion);

        Eleccion eleccionCorrecta = new Eleccion(opcionCorrecta);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(enunciado, eleccionCorrecta);

    }

    @Test
    public void test0_2UnaPreguntaDeVFCRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente() {

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
    public void test0_3UnJugadorQueRespondeDosPreguntasBienTieneMasPuntosQueUnJugadorQueRespondeUnaBienYUnaMal() {

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

    @Test
    public void test1_1UnaPreguntaDeVerdaderoFalsoConPenalidadSePuedeCrearIndicandoleCualEsLaRespuestaCorrecta(){

        String enunciado = "El caballo blanco de San Martin es efectivamente blanco";
        String opcion1 = "Verdadero";
        String opcion2 = "Falso";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        Eleccion eleccionCorrecta = new Eleccion(solucion);
        VerdaderoFalsoConPenalidad pregunta = new VerdaderoFalsoConPenalidad(enunciado, eleccionCorrecta);
    }

    @Test
    public void test1_2UnaPreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas(){

        String enunciado = "Horóscopo Chino:¿Cuáles realmente pertenecen?";

        String opcion1 = "Perro";
        String opcion2 = "Gallo";
        String opcion3 = "Rinoceronte";
        String opcion4 = "Cerdo";
        String opcion5 = "Carpincho";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion4);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico(enunciado, eleccionCorrecta);
    }

    @Test
    public void test1_3UnaPreguntaMultipleChoicePuntajeParcialPuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas(){

        String enunciado = "¿Quién está toooodo de ooooro?";

        String opcion1 = "El Chino";
        String opcion2 = "Duko";
        String opcion3 = "El Truenito pai";
        String opcion4 = "Aczino";
        String opcion5 = "Ysy A";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion5);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        MultipleChoicePuntajeParcial pregunta = new MultipleChoicePuntajeParcial(enunciado, eleccionCorrecta);
    }

    @Test
    public void test1_4UnaPreguntaVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.responderBien(10);
        tomas.responderBien(7);


        String enunciado = "No es cierto que nunca hay que testear métodos privados";

        String opcion1 = "Verdadero";
        String opcion2 = "Falso";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion2);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        VerdaderoFalsoConPenalidad pregunta = new VerdaderoFalsoConPenalidad(enunciado, eleccionCorrecta);


        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);
        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego);

        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion2);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        pregunta.evaluarRespuestas(respuestas);
        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 9);
        assertEquals(tomas.puntosTotales(), 8);
    //Diego no se equivocó... leyó mal la pregunta. Maldita doble negación!!!
    }

    @Test
    public void test1_6UnaPreguntaDeMCPPRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente(){

        String enunciado= "¿Qué temas se dan en Física II?";

        String texto1 = new String("Induccion magnetica");
        String texto2 = new String("Fuerza De Lorenz");
        String texto3 = new String("Diferenciacion");
        String texto4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(texto1);
        solucion.add(texto2);
        Eleccion eleccionCorrecta = new Eleccion(solucion);

        Pregunta multipleChoice= new MultipleChoicePuntajeParcial(enunciado, eleccionCorrecta);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo M");
        Jugador edson = new Jugador("Edson");

        //caso correcto
        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(texto1);
        opcionDiego.add(texto2);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);
        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego);

        //caso parcialmente incorrecto
        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(texto2);
        opcionTomas.add(texto3);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas);

        //caso parcialmente correcto
        List<String> opcionPablo = new ArrayList<String>();
        opcionPablo.add(texto1);
        Eleccion eleccionPablo = new Eleccion(opcionPablo);
        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo);

        //caso incorrecto
        List<String> opcionEdson = new ArrayList<String>();
        opcionEdson.add(texto4);
        opcionEdson.add(texto3);
        Eleccion eleccionEdson = new Eleccion(opcionEdson);
        Respuesta respuestaEdson = new Respuesta(edson, eleccionEdson);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);
        respuestas.add(respuestaPablo);
        respuestas.add(respuestaEdson);

        multipleChoice.evaluarRespuestas(respuestas);
        multipleChoice.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 2);
        assertEquals(tomas.puntosTotales(), 0);
        assertEquals(pablo.puntosTotales(), 1);
        assertEquals(edson.puntosTotales(), 0);

    }
}
