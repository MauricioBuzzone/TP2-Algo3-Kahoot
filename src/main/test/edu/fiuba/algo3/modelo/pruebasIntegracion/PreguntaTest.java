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
        Opcion solucion = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");

        List<Opcion> opcionCorrecta = new ArrayList<Opcion>();
        opcionCorrecta.add(solucion);
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionIncorrecta);
        opciones.add(solucion);
        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(opcionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

    }

    @Test
    public void test0_2UnaPreguntaDeVFCRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlosJugadoresQueRespondieronCorrectamente() {

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

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 0);
        assert (tomas.puntosTotales() > 0);

    }

    @Test
    public void test0_3UnJugadorQueRespondeDosPreguntasBienTieneMasPuntosQueUnJugadorQueRespondeUnaBienYUnaMal() {

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomás");

        String enunciadoUno = "Diego es pintorRodillo";
        Opcion solucionUno = new OpcionComun("Verdadero");
        Opcion opcionIncorrectaUno = new OpcionComun("Falso");

        List<Opcion> opcionCorrectaUno = new ArrayList<Opcion>();
        opcionCorrectaUno.add(solucionUno);

        List<Opcion> opcionesUno = new ArrayList<Opcion>();
        opcionesUno.add(solucionUno);
        opcionesUno.add(opcionIncorrectaUno);

        TipoDePregunta tipoVerdaderoFalsoUno = new VerdaderoFalso(opcionCorrectaUno);
        Pregunta preguntaUno = new Pregunta(enunciadoUno, opcionesUno, tipoVerdaderoFalsoUno);

        List<Opcion> opcionDiegoUno = new ArrayList<Opcion>();
        opcionDiegoUno.add(new OpcionComun("Falso"));
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);

        List<Opcion> opcionTomasUno = new ArrayList<Opcion>();
        opcionTomasUno.add(new OpcionComun("Verdadero"));
        Eleccion primeraEleccionTomas = new Eleccion(opcionTomasUno);

        Bonificador bonificadorDiego = new Bonificador();
        Bonificador bonificadorTomas = new Bonificador();

        Respuesta primeraRespuestaDiego = new Respuesta(diego, primeraEleccionDiego, bonificadorDiego);
        Respuesta primeraRespuestaTomas = new Respuesta(tomas, primeraEleccionTomas, bonificadorTomas);

        Respuestas respuestasUno = new Respuestas();
        respuestasUno.agregarRespuesta(primeraRespuestaDiego);
        respuestasUno.agregarRespuesta(primeraRespuestaTomas);

        preguntaUno.responderPregunta(respuestasUno);

        String enunciadoDos = "Tomás nunca pintó con salsa de tomate";
        Opcion solucionDos = new OpcionComun("Falso");
        Opcion opcionIncorrectaDos = new OpcionComun("Verdadero");
        List<Opcion> opcionCorrectaDos = new ArrayList<Opcion>();
        opcionCorrectaDos.add(solucionDos);

        List<Opcion> opcionesDos = new ArrayList<Opcion>();
        opcionesDos.add(opcionIncorrectaDos);
        opcionesDos.add(solucionDos);


        TipoDePregunta tipoVerdaderoFalsoDos = new VerdaderoFalso(opcionCorrectaDos);
        Pregunta preguntaDos = new Pregunta(enunciadoDos, opcionesDos, tipoVerdaderoFalsoDos);


        List<Opcion> opcionDiegoDos = new ArrayList<Opcion>();
        opcionDiegoDos.add(new OpcionComun("Falso"));
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);

        List<Opcion> opcionTomasDos = new ArrayList<Opcion>();
        opcionTomasDos.add(new OpcionComun("Falso"));
        Eleccion segundaEleccionTomas = new Eleccion(opcionTomasDos);

        Bonificador segundoBonificadorDiego = new Bonificador();
        Bonificador segundoBonificadorTomas = new Bonificador();

        Respuesta segundaRespuestaDiego = new Respuesta(diego, segundaEleccionDiego, segundoBonificadorDiego);
        Respuesta segundaRespuestaTomas = new Respuesta(tomas, segundaEleccionTomas, segundoBonificadorTomas);
        Respuestas respuestasDos = new Respuestas();
        respuestasDos.agregarRespuesta(segundaRespuestaDiego);
        respuestasDos.agregarRespuesta(segundaRespuestaTomas);

        preguntaUno.responderPregunta(respuestasDos);

        assert (tomas.puntosTotales() > diego.puntosTotales());
    }

    @Test
    public void test1_1UnaPreguntaDeVerdaderoFalsoConPenalidadSePuedeCrearIndicandoleCualEsLaRespuestaCorrecta() {

        String enunciado = "El caballo blanco de San Martin es efectivamente blanco";
        Opcion opcion1 = new OpcionComun("Verdadero");
        Opcion opcion2 = new OpcionComun("Falso");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);
    }

    @Test
    public void test1_2UnaPreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas() {

        String enunciado = "Horóscopo Chino:¿Cuáles realmente pertenecen?";

        Opcion opcion1 = new OpcionComun("Perro");
        Opcion opcion2 = new OpcionComun("Gallo");
        Opcion opcion3 = new OpcionComun("Rinoceronte");
        Opcion opcion4 = new OpcionComun("Cerdo");
        Opcion opcion5 = new OpcionComun("Carpincho");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion4);

        List<Opcion> opciones = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionComun("El Chino");
        Opcion opcion2 = new OpcionComun("Duko");
        Opcion opcion3 = new OpcionComun("El Truenito pai");
        Opcion opcion4 = new OpcionComun("Aczino");
        Opcion opcion5 = new OpcionComun("Ysy A");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion5);

        List<Opcion> opciones = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionComun("Verdadero");
        Opcion opcion2 = new OpcionComun("Falso");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion2);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);


        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Verdadero"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Falso"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);

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

        Opcion opcion1 = new OpcionComun("Ío");
        Opcion opcion2 = new OpcionComun("Caronte");
        Opcion opcion3 = new OpcionComun("Ganímedes");
        Opcion opcion4 = new OpcionComun("Titán");
        Opcion opcion5 = new OpcionComun("Europa");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);

        List<Opcion> opciones = new ArrayList<Opcion>();
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

        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Ío"));
        opcionDiego.add(new OpcionComun("Ganímedes"));
        opcionDiego.add(new OpcionComun("Europa"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Ío"));
        opcionTomas.add(new OpcionComun("Ganímedes"));
        opcionTomas.add(new OpcionComun("Titán"));
        opcionTomas.add(new OpcionComun("Europa"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        List<Opcion> opcionPablo = new ArrayList<Opcion>();
        opcionPablo.add(new OpcionComun("Caronte"));
        opcionPablo.add(new OpcionComun("Titán"));
        Eleccion eleccionPablo = new Eleccion(opcionPablo);

        Bonificador bonificadorPablo = new Bonificador();

        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo, bonificadorPablo);

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);
        respuestas.agregarRespuesta(respuestaPablo);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 4);
        assertEquals(tomas.puntosTotales(), 6);
        assertEquals(pablo.puntosTotales(), 5);
    }

    @Test
    public void test1_6UnaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {

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

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);
        respuestas.agregarRespuesta(respuestaPablo);
        respuestas.agregarRespuesta(respuestaEdson);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 2);
        assertEquals(tomas.puntosTotales(), 0);
        assertEquals(pablo.puntosTotales(), 1);
        assertEquals(edson.puntosTotales(), 0);
    }

    @Test
    public void test2_1UnaPreguntaDeMultipleConPenalidadPuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas() {

        String enunciado = "¿Cuáles son personajes de Disney?";

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Katara");
        Opcion opcion3 = new OpcionComun("Ariel");
        Opcion opcion4 = new OpcionComun("Mérida");
        Opcion opcion5 = new OpcionComun("Chihiro");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion4);

        List<Opcion> opciones = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Katara");
        Opcion opcion3 = new OpcionComun("Ariel");
        Opcion opcion4 = new OpcionComun("Mérida");
        Opcion opcion5 = new OpcionComun("Chihiro");


        // Crea el tipo de pregunta y su elección correcta.
        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion4);

        TipoDePregunta tipoMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        // Crea opciones de la pregunta.
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceConPenalidad);


        // Caso Correctas: 3 Incorrectas: 0 -> suma 3
        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Mulán"));
        opcionDiego.add(new OpcionComun("Ariel"));
        opcionDiego.add(new OpcionComun("Mérida"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        // Caso Correctas: 3 Incorrectas: 1 -> suma 2
        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Mulán"));
        opcionTomas.add(new OpcionComun("Ariel"));
        opcionTomas.add(new OpcionComun("Mérida"));
        opcionTomas.add(new OpcionComun("Chihiro"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        // Caso Correctas: 1 Incorrectas: 2 -> resta 1
        List<Opcion> opcionPablo = new ArrayList<Opcion>();
        opcionPablo.add(new OpcionComun("Mulán"));
        opcionPablo.add(new OpcionComun("Katara"));
        opcionPablo.add(new OpcionComun("Chihiro"));
        Eleccion eleccionPablo = new Eleccion(opcionPablo);

        Bonificador bonificadorPablo = new Bonificador();

        Respuesta respuestaPablo = new Respuesta(pablo, eleccionPablo, bonificadorPablo);

        // Caso Correctas: 0 Incorrectas: 2 -> resta 2
        List<Opcion> opcionEdson = new ArrayList<Opcion>();
        opcionEdson.add(new OpcionComun("Katara"));
        opcionEdson.add(new OpcionComun("Chihiro"));
        Eleccion eleccionEdson = new Eleccion(opcionEdson);

        Bonificador bonificadorEdson = new Bonificador();

        Respuesta respuestaEdson = new Respuesta(edson, eleccionEdson, bonificadorEdson);

        // Caso Correctas: 2 Incorrectas: 2 -> no suma ni resta nada.
        List<Opcion> opcionMartin = new ArrayList<Opcion>();
        opcionMartin.add(new OpcionComun("Katara"));
        opcionMartin.add(new OpcionComun("Chihiro"));
        opcionMartin.add(new OpcionComun("Mulán"));
        opcionMartin.add(new OpcionComun("Ariel"));
        Eleccion eleccionMartin = new Eleccion(opcionMartin);

        Bonificador bonificadorMartin = new Bonificador();

        Respuesta respuestaMartin = new Respuesta(martin, eleccionMartin, bonificadorMartin);

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);
        respuestas.agregarRespuesta(respuestaPablo);
        respuestas.agregarRespuesta(respuestaEdson);
        respuestas.agregarRespuesta(respuestaMartin);

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
        Opcion opcion1 = new OpcionOrdenada("a", 1);
        Opcion opcion2 = new OpcionOrdenada("b", 2);
        Opcion opcion3 = new OpcionOrdenada("c", 3);
        Opcion opcion4 = new OpcionOrdenada("d", 4);
        Opcion opcion5 = new OpcionOrdenada("e", 5);

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);
        solucion.add(opcion4);
        solucion.add(opcion5);

        List<Opcion> opciones = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionOrdenada("Huevo", 1);
        Opcion opcion2 = new OpcionOrdenada("Gallina", 2);

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
        Opcion opcionDiego1 = new OpcionOrdenada("Huevo", 1);
        Opcion opcionDiego2 = new OpcionOrdenada("Gallina", 2);
        opcionDiego.add(opcionDiego1);
        opcionDiego.add(opcionDiego2);

        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //Jugador contesta incorrectamente
        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        Opcion opcionTomas1 =  new OpcionOrdenada("Gallina", 1);
        Opcion opcionTomas2 = new OpcionOrdenada("Huevo", 2);
        opcionTomas.add(opcionTomas1);
        opcionTomas.add(opcionTomas2);

        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);

        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 5);
        assertEquals(tomas.puntosTotales(), 3);
    }

    @Test
    public void test2_5UnaPreguntaDeGroupChoicePuedeCrearseIndicandoleCualesSonLasRespuestasCorrectas() {

        String enunciado = new String(" Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");

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
    }

    @Test
    public void test2_6UnaPreguntaDeGroupChoiceRecibeUnaListaDeRespuestasYAsignaLosPuntosALosJugadoresCorrectamente() {


        //Creo los jugadores
        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado


        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        diego.asignarPuntos(3);
        tomas.asignarPuntos(6);

        //Creo la pregunta
        String enunciado = new String(" Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");
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
        List<Opcion> opcionesDiego = new ArrayList<Opcion>();
        Opcion opcionDiego1 = new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC");        // Bien
        Opcion opcionDiego2 = new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con 1 DWC");             // Bien
        Opcion opcionDiego3 = new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con mas de 1 DWC");    // Bien
        Opcion opcionDiego4 = new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC");               // Bien
        Opcion opcionDiego5 = new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC");   // Bien
        opcionesDiego.add(opcionDiego1);
        opcionesDiego.add(opcionDiego2);
        opcionesDiego.add(opcionDiego3);
        opcionesDiego.add(opcionDiego4);
        opcionesDiego.add(opcionDiego5);

        Eleccion eleccionDiego = new Eleccion(opcionesDiego);
        Bonificador bonificadorDiego =new Bonificador();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        //Caso Incorrecta:
        List<Opcion> opcionesTomas = new ArrayList<Opcion>();
        Opcion opcionTomas1 = new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC");        // Bien
        Opcion opcionTomas2 = new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con mas de 1 DWC");      // Mal
        Opcion opcionTomas3 = new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con 1 DWC");           // Mal
        Opcion opcionTomas4 = new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC");               // Bien
        Opcion opcionTomas5 = new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC");   // Bien
        opcionesTomas.add(opcionTomas1);
        opcionesTomas.add(opcionTomas2);
        opcionesTomas.add(opcionTomas3);
        opcionesTomas.add(opcionTomas4);
        opcionesTomas.add(opcionTomas5);


        Eleccion eleccionTomas = new Eleccion(opcionesTomas);

        Bonificador bonificadorTomas = new Bonificador();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);


        //Se crea la lista de respuestas:
        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);

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

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Katara");
        Opcion opcion3 = new OpcionComun("Ariel");
        Opcion opcion4 = new OpcionComun("Mérida");
        Opcion opcion5 = new OpcionComun("Chihiro");


        // Crea el tipo de pregunta y su elección correcta.
        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion4);

        TipoDePregunta tipoMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        // Crea opciones de la pregunta.
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceConPenalidad);

        // Caso Correctas: 3 Incorrectas: 0 -> suma 3
        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Mulán"));
        opcionDiego.add(new OpcionComun("Ariel"));
        opcionDiego.add(new OpcionComun("Mérida"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();
        bonificadorDiego.cambiarFactorX2();

        Respuesta respuestaDiego = new Respuesta(diego, eleccionDiego, bonificadorDiego);

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);

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

        Opcion opcion1 = new OpcionComun("Verdadero");
        Opcion opcion2 = new OpcionComun("Falso");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion2);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        TipoDePregunta tipoVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalsoConPenalidad);


        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Falso"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();
        bonificadorTomas.cambiarFactorX3();

        Respuesta respuestaTomas = new Respuesta(tomas, eleccionTomas, bonificadorTomas);

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaTomas);

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

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.activarExclusividad();                       // Diego activa la exclusividad.
        respuestas.agregarRespuesta(respuestaTomas);

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

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.activarExclusividad();           // Diego activa la exclusividad
        respuestas.agregarRespuesta(respuestaTomas);
        respuestas.agregarRespuesta(respuestaPablo);
        respuestas.activarExclusividad();           // Pablo activa la exclusividad
        respuestas.agregarRespuesta(respuestaEdson);

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

        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);
        respuestas.activarExclusividad();               // Tomás activa la exclusividad

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
        Respuestas respuestas = new Respuestas();
        respuestas.agregarRespuesta(respuestaDiego);
        respuestas.agregarRespuesta(respuestaTomas);
        respuestas.activarExclusividad();                   // Tomás activa la exclusividad.

        //Pregunta asinga  los puntos correspondientes:
        pregunta.responderPregunta(respuestas);

        assertEquals(diego.puntosTotales(), 5);
        assertEquals(tomas.puntosTotales(), 6);
    }
}
