package edu.fiuba.algo3.modelo.pruebasIntegracion;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
    @Test
    public void test0_1UnaPreguntaDeVFCPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";
        String opcionIncorrecta = "Falso";

        List<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add(solucion);
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcionIncorrecta);
        opciones.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcionCorrecta);
        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

    }

    @Test
    public void test0_2UnaPreguntaDeVFCRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente() {

        String enunciado = "Diego es pintorRodillo (?";
        String solucion = "Verdadero";
        String opcionIncorrecta = "Falso";

        List<String> opcionCorrecta = new ArrayList<String>();
        opcionCorrecta.add(solucion);
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcionIncorrecta);
        opciones.add(solucion);

        Eleccion eleccionCorrecta = new Eleccion(opcionCorrecta);
        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

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

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 0);
        assert (tomas.puntosTotales() > 0);

    }

    @Test
    public void test0_3UnJugadorQueRespondeDosPreguntasBienTieneMasPuntosQueUnJugadorQueRespondeUnaBienYUnaMal() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomás");

        String enunciadoUno = "Diego es pintorRodillo";
        String solucionUno = "Verdadero";
        String opcionIncorrectaUno = "Falso";

        List<String> opcionCorrectaUno = new ArrayList<String>();
        opcionCorrectaUno.add(solucionUno);

        List<String> opcionesUno = new ArrayList<String>();
        opcionesUno.add(opcionIncorrectaUno);
        opcionesUno.add(solucionUno);

        Eleccion eleccionCorrectaUno = new Eleccion(opcionCorrectaUno);
        TipoDePregunta tipoVerdaderoFalsoUno = new VerdaderoFalso(eleccionCorrectaUno);
        Pregunta preguntaUno = new Pregunta(enunciadoUno, opcionesUno, tipoVerdaderoFalsoUno);

        List<String> opcionDiegoUno = new ArrayList<String>();
        opcionDiegoUno.add(opcionIncorrectaUno);
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);

        List<String> opcionTomasUno = new ArrayList<String>();
        opcionTomasUno.add(solucionUno);
        Eleccion primeraEleccionTomas = new Eleccion(opcionTomasUno);

        Respuesta primeraRespuestaDiego = new Respuesta(diego, primeraEleccionDiego);
        Respuesta primeraRespuestaTomas = new Respuesta(tomas, primeraEleccionTomas);
        ArrayList<Respuesta> respuestasUno = new ArrayList<Respuesta>();
        respuestasUno.add(primeraRespuestaDiego);
        respuestasUno.add(primeraRespuestaTomas);

        preguntaUno.responderPregunta(respuestasUno);

        String enunciadoDos = "Tomás nunca pintó con salsa de tomate";
        String solucionDos = "Falso";
        String opcionIncorrectaDos = "Verdadero";
        List<String> opcionCorrectaDos = new ArrayList<String>();
        opcionCorrectaDos.add(solucionDos);

        List<String> opcionesDos = new ArrayList<String>();
        opcionesDos.add(opcionIncorrectaDos);
        opcionesDos.add(solucionDos);

        Eleccion eleccionCorrectaDos = new Eleccion(opcionCorrectaDos);
        TipoDePregunta tipoVerdaderoFalsoDos = new VerdaderoFalso(eleccionCorrectaDos);
        Pregunta preguntaDos = new Pregunta(enunciadoDos, opcionesDos, tipoVerdaderoFalsoDos);


        List<String> opcionDiegoDos = new ArrayList<String>();
        opcionDiegoDos.add(solucionDos);
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);

        List<String> opcionTomasDos = new ArrayList<String>();
        opcionTomasDos.add(solucionDos);
        Eleccion segundaEleccionTomas = new Eleccion(opcionTomasDos);

        Respuesta segundaRespuestaDiego = new Respuesta(diego, segundaEleccionDiego);
        Respuesta segundaRespuestaTomas = new Respuesta(tomas, segundaEleccionTomas);
        ArrayList<Respuesta> respuestasDos = new ArrayList<Respuesta>();
        respuestasDos.add(segundaRespuestaDiego);
        respuestasDos.add(segundaRespuestaTomas);

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
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);
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

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        TipoDePregunta tipoMultipleChoiceClasico = new MultipleChoiceClasico(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceClasico);
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

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        TipoDePregunta tipoMultipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoicePuntajeParcial);
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

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);


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

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 9);
        assertEquals(tomas.puntosTotales(), 8);
        //Diego no se equivocó... leyó mal la pregunta. Maldita doble negación!!!
    }

    @Test
    public void test1_5UnaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.responderBien(3);
        tomas.responderBien(6);
        pablo.responderBien(5);

        String enunciado = "¿Cuáles son lunas de Jupiter?";

        String opcion1 = "Ío";
        String opcion2 = "Caronte";
        String opcion3 = "Ganímedes";
        String opcion4 = "Titán";
        String opcion5 = "Europa";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        TipoDePregunta tipoMultipleChoiceClasico = new MultipleChoiceClasico(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceClasico);

        //todas correcta   --> 1 diego
        //parcialmente mal --> 0 tomas
        //todas mal        --> 0 pablo

        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        opcionDiego.add(opcion3);
        opcionDiego.add(opcion5);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);
        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego);

        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion1);
        opcionTomas.add(opcion3);
        opcionTomas.add(opcion4);
        opcionTomas.add(opcion5);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas);

        List<String> opcionPablo = new ArrayList<String>();
        opcionPablo.add(opcion2);
        opcionPablo.add(opcion4);
        Eleccion eleccionPablo = new Eleccion(opcionPablo);
        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);
        respuestas.add(respuestaPablo);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 4);
        assertEquals(tomas.puntosTotales(), 6);
        assertEquals(pablo.puntosTotales(), 5);
    }

    @Test
    public void test1_6UnaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente(){

        String enunciado= "¿Qué temas se dan en Física II?";

        String opcion1 = new String("Induccion magnetica");
        String opcion2 = new String("Fuerza De Lorenz");
        String opcion3 = new String("Diferenciacion");
        String opcion4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Eleccion eleccionCorrecta = new Eleccion(solucion);

        TipoDePregunta tipoMultipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(eleccionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoicePuntajeParcial);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo M");
        Jugador edson = new Jugador("Edson");

        //caso correcto
        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        opcionDiego.add(opcion2);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);
        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego);

        //caso parcialmente incorrecto
        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion2);
        opcionTomas.add(opcion3);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas);

        //caso parcialmente correcto
        List<String> opcionPablo = new ArrayList<String>();
        opcionPablo.add(opcion1);
        Eleccion eleccionPablo = new Eleccion(opcionPablo);
        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo);

        //caso incorrecto
        List<String> opcionEdson = new ArrayList<String>();
        opcionEdson.add(opcion4);
        opcionEdson.add(opcion3);
        Eleccion eleccionEdson = new Eleccion(opcionEdson);
        Respuesta respuestaEdson = new Respuesta(edson, eleccionEdson);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);
        respuestas.add(respuestaPablo);
        respuestas.add(respuestaEdson);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 2);
        assertEquals(tomas.puntosTotales(), 0);
        assertEquals(pablo.puntosTotales(), 1);
        assertEquals(edson.puntosTotales(), 0);
    }
}
