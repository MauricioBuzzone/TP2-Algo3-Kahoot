package edu.fiuba.algo3.modelo.pruebasIntegracion;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


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
        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(opcionCorrecta);
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

        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(opcionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add("Falso");
        Eleccion eleccionDiego = new Eleccion(opcionDiego);


        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add("Verdadero");
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorDiego = new Bonificador();
        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

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

        TipoDePregunta tipoVerdaderoFalsoUno = new VerdaderoFalso(opcionCorrectaUno);
        Pregunta preguntaUno = new Pregunta(enunciadoUno, opcionesUno, tipoVerdaderoFalsoUno);

        List<String> opcionDiegoUno = new ArrayList<String>();
        opcionDiegoUno.add(opcionIncorrectaUno);
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);

        List<String> opcionTomasUno = new ArrayList<String>();
        opcionTomasUno.add(solucionUno);
        Eleccion primeraEleccionTomas = new Eleccion(opcionTomasUno);

        Bonificador bonificadorDiego = new Bonificador();
        Bonificador bonificadorTomas = new Bonificador();

        Respuesta primeraRespuestaDiego = new Respuesta(diego, primeraEleccionDiego, bonificadorDiego);
        Respuesta primeraRespuestaTomas = new Respuesta(tomas, primeraEleccionTomas, bonificadorTomas);

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


        TipoDePregunta tipoVerdaderoFalsoDos = new VerdaderoFalso(opcionCorrectaDos);
        Pregunta preguntaDos = new Pregunta(enunciadoDos, opcionesDos, tipoVerdaderoFalsoDos);


        List<String> opcionDiegoDos = new ArrayList<String>();
        opcionDiegoDos.add(solucionDos);
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);

        List<String> opcionTomasDos = new ArrayList<String>();
        opcionTomasDos.add(solucionDos);
        Eleccion segundaEleccionTomas = new Eleccion(opcionTomasDos);

        Bonificador segundoBonificadorDiego = new Bonificador();
        Bonificador segundoBonificadorTomas = new Bonificador();

        Respuesta segundaRespuestaDiego = new Respuesta(diego, segundaEleccionDiego, segundoBonificadorDiego);
        Respuesta segundaRespuestaTomas = new Respuesta(tomas, segundaEleccionTomas, segundoBonificadorTomas);
        ArrayList<Respuesta> respuestasDos = new ArrayList<Respuesta>();
        respuestasDos.add(segundaRespuestaDiego);
        respuestasDos.add(segundaRespuestaTomas);

        preguntaUno.responderPregunta(respuestasDos);

        assert (tomas.puntosTotales() > diego.puntosTotales());
    }

    @Test
    public void test1_1UnaPreguntaDeVerdaderoFalsoConPenalidadSePuedeCrearIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "El caballo blanco de San Martin es efectivamente blanco";
        String opcion1 = "Verdadero";
        String opcion2 = "Falso";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);
    }

    @Test
    public void test1_2UnaPreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas() {

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


        TipoDePregunta tipoMultipleChoiceClasico = new MultipleChoiceClasico(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceClasico);
    }

    @Test
    public void test1_3UnaPreguntaMultipleChoicePuntajeParcialPuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas() {

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


        TipoDePregunta tipoMultipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoicePuntajeParcial);
    }

    @Test
    public void test1_4UnaPreguntaVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.asignarPuntos(10);
        tomas.asignarPuntos(7);


        String enunciado = "No es cierto que nunca hay que testear métodos privados";

        String opcion1 = "Verdadero";
        String opcion2 = "Falso";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion2);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);


        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion2);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

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
        diego.asignarPuntos(3);
        tomas.asignarPuntos(6);
        pablo.asignarPuntos(5);

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


        TipoDePregunta tipoMultipleChoiceClasico = new MultipleChoiceClasico(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceClasico);

        //todas correcta   --> 1 diego
        //parcialmente mal --> 0 tomas
        //todas mal        --> 0 pablo

        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        opcionDiego.add(opcion3);
        opcionDiego.add(opcion5);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion1);
        opcionTomas.add(opcion3);
        opcionTomas.add(opcion4);
        opcionTomas.add(opcion5);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        List<String> opcionPablo = new ArrayList<String>();
        opcionPablo.add(opcion2);
        opcionPablo.add(opcion4);
        Eleccion eleccionPablo = new Eleccion(opcionPablo);

        Bonificador bonificadorPablo = new Bonificador();

        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo, bonificadorPablo);

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
    public void test1_6UnaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        String enunciado = "¿Qué temas se dan en Física II?";

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


        TipoDePregunta tipoMultipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);
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

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //caso parcialmente incorrecto
        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion2);
        opcionTomas.add(opcion3);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        //caso parcialmente correcto
        List<String> opcionPablo = new ArrayList<String>();
        opcionPablo.add(opcion1);
        Eleccion eleccionPablo = new Eleccion(opcionPablo);

        Bonificador bonificadorPablo = new Bonificador();

        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo, bonificadorPablo);

        //caso incorrecto
        List<String> opcionEdson = new ArrayList<String>();
        opcionEdson.add(opcion4);
        opcionEdson.add(opcion3);
        Eleccion eleccionEdson = new Eleccion(opcionEdson);

        Bonificador bonificadorEdson = new Bonificador();

        Respuesta respuestaEdson = new Respuesta(edson, eleccionEdson, bonificadorEdson);

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

    @Test
    public void test2_1UnaPreguntaDeMultipleConPenalidadPuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas() {

        String enunciado = "¿Cuáles son personajes de Disney?";

        String opcion1 = "Mulán";
        String opcion2 = "Katara";
        String opcion3 = "Ariel";
        String opcion4 = "Mérida";
        String opcion5 = "Chihiro";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion4);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        TipoDePregunta tipoMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceConPenalidad);
    }

    @Test
    public void test2_2UnaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo");
        Jugador edson = new Jugador("Edson");
        Jugador martin = new Jugador("Martin");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.asignarPuntos(3);
        tomas.asignarPuntos(6);
        pablo.asignarPuntos(5);
        edson.asignarPuntos(9);
        martin.asignarPuntos(2);


        String enunciado = "¿Cuáles son personajes de Disney?";

        String opcion1 = "Mulán";
        String opcion2 = "Katara";
        String opcion3 = "Ariel";
        String opcion4 = "Mérida";
        String opcion5 = "Chihiro";


        // Crea el tipo de pregunta y su elección correcta.
        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion4);

        TipoDePregunta tipoMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        // Crea opciones de la pregunta.
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceConPenalidad);


        // Caso Correctas: 3 Incorrectas: 0 -> suma 3
        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        opcionDiego.add(opcion3);
        opcionDiego.add(opcion4);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        // Caso Correctas: 3 Incorrectas: 1 -> suma 2
        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion1);
        opcionTomas.add(opcion3);
        opcionTomas.add(opcion4);
        opcionTomas.add(opcion5);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        // Caso Correctas: 1 Incorrectas: 2 -> resta 1
        List<String> opcionPablo = new ArrayList<String>();
        opcionPablo.add(opcion1);
        opcionPablo.add(opcion2);
        opcionPablo.add(opcion5);
        Eleccion eleccionPablo = new Eleccion(opcionPablo);

        Bonificador bonificadorPablo = new Bonificador();

        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo, bonificadorPablo);

        // Caso Correctas: 0 Incorrectas: 2 -> resta 2
        List<String> opcionEdson = new ArrayList<String>();
        opcionEdson.add(opcion2);
        opcionEdson.add(opcion5);
        Eleccion eleccionEdson = new Eleccion(opcionEdson);

        Bonificador bonificadorEdson = new Bonificador();

        Respuesta respuestaEdson = new Respuesta(edson, eleccionEdson, bonificadorEdson);

        // Caso Correctas: 2 Incorrectas: 2 -> no suma ni resta nada.
        List<String> opcionMartin = new ArrayList<String>();
        opcionMartin.add(opcion2);
        opcionMartin.add(opcion5);
        opcionMartin.add(opcion1);
        opcionMartin.add(opcion3);
        Eleccion eleccionMartin = new Eleccion(opcionMartin);

        Bonificador bonificadorMartin = new Bonificador();

        Respuesta respuestaMartin = new Respuesta(martin, eleccionMartin, bonificadorMartin);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);
        respuestas.add(respuestaPablo);
        respuestas.add(respuestaEdson);
        respuestas.add(respuestaMartin);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 6);
        assertEquals(tomas.puntosTotales(), 8);
        assertEquals(pablo.puntosTotales(), 4);
        assertEquals(edson.puntosTotales(), 7);
        assertEquals(martin.puntosTotales(), 2);
    }

    @Test
    public void test2_3UnaPreguntaDeOrderedChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "Ordenar alfabeticamente";
        String opcion1 = "a";
        String opcion2 = "b";
        String opcion3 = "c";
        String opcion4 = "d";
        String opcion5 = "e";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);
        solucion.add(opcion4);
        solucion.add(opcion5);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        TipoDePregunta orderedChoice = new OrderedChoice(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, orderedChoice);

    }

    @Test
    public void test2_4UnaPreguntaDeOrderedChoiceRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.asignarPuntos(4);
        tomas.asignarPuntos(3);

        String enunciado = "Situar cronologicamente";

        String opcion1 = "Huevo";
        String opcion2 = "Gallina";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        TipoDePregunta orderedChoice = new OrderedChoice(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, orderedChoice);

        //Jugador contesta correctamente
        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        opcionDiego.add(opcion2);

        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //Jugador contesta incorrectamente
        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion2);
        opcionTomas.add(opcion1);

        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 5);
        assertEquals(tomas.puntosTotales(), 3);
    }

    @Test
    public void test2_5UnaPreguntaDeGroupChoicePuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas() {

        String enunciado = new String(" Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");
        String opcion1 = new String("Niki Lauda");
        String opcion2 = new String("Nico Rosberg");
        String opcion3 = new String("Lewis Hamilton");
        String opcion4 = new String("Damon Hill");
        String opcion5 = new String("Fernando Alonso");


        List<String> solucion = new ArrayList<String>();
        solucion.add("A:" + opcion1);
        solucion.add("B:" + opcion2);
        solucion.add("A:" + opcion3);
        solucion.add("B:" + opcion4);
        solucion.add("A:" + opcion5);
        TipoDePregunta groupChoice = new GroupChoice(solucion);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, groupChoice);
    }

    @Test
    public void test2_6UnaPreguntaDeGroupChoiceRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        /*
        Creo los jugadores
        Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        De manera tal que, se pueda corroborar el comportamiento deseado
        */

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        diego.asignarPuntos(3);
        tomas.asignarPuntos(6);

        //Creo la pregunta
        String enunciado = new String(" Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");
        String opcion1 = new String("Niki Lauda");
        String opcion2 = new String("Nico Rosberg");
        String opcion3 = new String("Lewis Hamilton");
        String opcion4 = new String("Damon Hill");
        String opcion5 = new String("Fernando Alonso");


        List<String> solucion = new ArrayList<String>();
        solucion.add("A:" + opcion1);
        solucion.add("B:" + opcion2);
        solucion.add("A:" + opcion3);
        solucion.add("B:" + opcion4);
        solucion.add("A:" + opcion5);
        TipoDePregunta groupChoice = new GroupChoice(solucion);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, groupChoice);

        //Caso correcta:
        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add("A:" + opcion1);
        opcionDiego.add("B:" + opcion2);
        opcionDiego.add("A:" + opcion3);
        opcionDiego.add("B:" + opcion4);
        opcionDiego.add("A:" + opcion5);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);
        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //Caso Incorrecta:
        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add("A:" + opcion1);
        opcionTomas.add("A:" + opcion2);
        opcionTomas.add("B:" + opcion3);
        opcionTomas.add("B:" + opcion4);
        opcionTomas.add("A:" + opcion5);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);
        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);


        //Se crea la lista de respuestas:
        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        //Pregunta asinga  los puntos correspondientes:
        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 4);
        assertEquals(tomas.puntosTotales(), 6);
    }

    @Test
    public void test2_7UnaPreguntaDeMultipleChoiceConPenalidadRecibeUnaRespuestasConBonificadorYAsignaLosPuntosAlJugadorCorrectamente() {

        Jugador diego = new Jugador("Diego");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.asignarPuntos(3);


        String enunciado = "¿Cuáles son personajes de Disney?";

        String opcion1 = "Mulán";
        String opcion2 = "Katara";
        String opcion3 = "Ariel";
        String opcion4 = "Mérida";
        String opcion5 = "Chihiro";


        // Crea el tipo de pregunta y su elección correcta.
        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion4);

        TipoDePregunta tipoMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        // Crea opciones de la pregunta.
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceConPenalidad);

        // Caso Correctas: 3 Incorrectas: 0 -> suma 3
        List<String> opcionDiego = new ArrayList<String>();
        opcionDiego.add(opcion1);
        opcionDiego.add(opcion3);
        opcionDiego.add(opcion4);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();
        bonificadorDiego.cambiarFactorX2();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 9);
    }

    @Test
    public void test2_8UnaPreguntaDeMultipleChoiceClasicoRecibeUnaRespuestasConBonificadorYAsignLosPuntosAlJugadorCorrectamente() {

        Jugador tomas = new Jugador("Tomas");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        tomas.asignarPuntos(7);


        String enunciado = "No es cierto que nunca hay que testear métodos privados";

        String opcion1 = "Verdadero";
        String opcion2 = "Falso";

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion2);

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);


        List<String> opcionTomas = new ArrayList<String>();
        opcionTomas.add(opcion2);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();
        bonificadorTomas.cambiarFactorX3();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaTomas);

        pregunta.responderPregunta(respuestas);

        assertEquals(tomas.puntosTotales(), 10);
    }

    @Test
    public void test3_1UnaPreguntaDeVFCConExclusividadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente() {

        String enunciado = "Diego es pintorRodillo (?";
        Opcion solucion = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");

        List<Opcion> opcionCorrecta = new ArrayList<Opcion>();
        opcionCorrecta.add(solucion);
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionIncorrecta);
        opciones.add(solucion);

        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(opcionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        diego.asignarPuntos(3);
        tomas.asignarPuntos(3);

        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Falso"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);


        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Verdadero"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorDiego = new Bonificador();
        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);
        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        pregunta.activarExclusividad();
        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 3);
        assertEquals(tomas.puntosTotales(), 5);

    }

    @Test
    public void test3_2UnaPreguntaDeMultipleChoiceParcialConDobleExclusividadRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        String enunciado = "¿Qué temas se dan en Física II?";

        Opcion opcion1 = new OpcionComun("Induccion magnetica");
        Opcion opcion2 = new OpcionComun("Fuerza De Lorenz");
        Opcion opcion3 = new OpcionComun("Diferenciacion");
        Opcion opcion4 = new OpcionComun("Cuerpo Rigido");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);


        TipoDePregunta tipoMultipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoicePuntajeParcial);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo M");
        Jugador edson = new Jugador("Edson");

        //caso correcto
        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Induccion magnetica"));
        opcionDiego.add(new OpcionComun("Fuerza De Lorenz"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //caso parcialmente incorrecto
        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Fuerza De Lorenz"));
        opcionTomas.add(new OpcionComun("Diferenciacion"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        //caso parcialmente correcto
        List<Opcion> opcionPablo = new ArrayList<Opcion>();
        opcionPablo.add(new OpcionComun("Induccion magnetica"));
        Eleccion eleccionPablo = new Eleccion(opcionPablo);

        Bonificador bonificadorPablo = new Bonificador();

        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo, bonificadorPablo);

        //caso incorrecto
        List<Opcion> opcionEdson = new ArrayList<Opcion>();
        opcionEdson.add(new OpcionComun("Cuerpo Rigido"));
        opcionEdson.add(new OpcionComun("Diferenciacion"));
        Eleccion eleccionEdson = new Eleccion(opcionEdson);

        Bonificador bonificadorEdson = new Bonificador();

        Respuesta respuestaEdson = new Respuesta(edson, eleccionEdson, bonificadorEdson);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);
        respuestas.add(respuestaPablo);
        respuestas.add(respuestaEdson);

        pregunta.activarExclusividad();
        pregunta.activarExclusividad();
        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 8);
        assertEquals(tomas.puntosTotales(), 0);
        assertEquals(pablo.puntosTotales(), 0);
        assertEquals(edson.puntosTotales(), 0);
    }

    @Test
    public void test3_3UnaPreguntaDeOrderedChoiceConExclusividadRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.asignarPuntos(4);
        tomas.asignarPuntos(3);

        String enunciado = "Situar cronologicamente";

        Opcion opcion1 = new OpcionOrdenada("Huevo", 1);
        Opcion opcion2 = new OpcionOrdenada("Gallina",2);

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        TipoDePregunta orderedChoice = new OrderedChoice(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, orderedChoice);

        //Jugador contesta correctamente
        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionOrdenada("Huevo", 1));
        opcionDiego.add(new OpcionOrdenada("Gallina",2));

        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //Jugador contesta incorrectamente
        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionOrdenada("Gallina",1));
        opcionTomas.add(new OpcionOrdenada("Huevo",2));

        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        pregunta.activarExclusividad();
        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 6);
        assertEquals(tomas.puntosTotales(), 3);
    }

    @Test
    public void test3_4UnaPreguntaDeGroupChoiceConExclusividadRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

        /*
        Creo los jugadores
        Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        De manera tal que, se pueda corroborar el comportamiento deseado
        */

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        diego.asignarPuntos(3);
        tomas.asignarPuntos(6);

        //Creo la pregunta
        String enunciado = new String("Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");
        Opcion opcion1 = new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion2 = new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con 1 DWC");
        Opcion opcion3 = new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion4 = new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC");
        Opcion opcion5 = new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC");


        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);
        solucion.add(opcion4);
        solucion.add(opcion5);
        TipoDePregunta groupChoice = new GroupChoice(solucion);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, groupChoice);

        //Caso correcta:
        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC"));                 // Bien
        opcionDiego.add(new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con 1 DWC"));                      // Bien
        opcionDiego.add(new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con mas de 1 DWC"));             // Bien
        opcionDiego.add(new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC"));                        // Bien
        opcionDiego.add(new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC"));            // Bien
        Eleccion eleccionDiego = new Eleccion(opcionDiego);
        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //Caso Incorrecta:
        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC"));                 // Bien
        opcionTomas.add(new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con mas de 1 DWC"));               // Mal
        opcionTomas.add(new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con 1 DWC"));                    // Mal
        opcionTomas.add(new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC"));                        // Bien
        opcionTomas.add(new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC"));            // Bien
        Eleccion eleccionTomas = new Eleccion(opcionTomas);
        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);


        //Se crea la lista de respuestas:
        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaDiego);
        respuestas.add(respuestaTomas);

        //Pregunta asinga  los puntos correspondientes:
        pregunta.activarExclusividad();
        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 5);
        assertEquals(tomas.puntosTotales(), 6);
    }
}
