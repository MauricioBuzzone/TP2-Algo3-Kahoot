package edu.fiuba.algo3.modelo.pruebasUnitarias;
import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.Respuestas;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.ArrayList;

public class RespuestasTest {

    @Test
    public void test01RespuestasRecibeUnaListaDeRespuestasYCuandoSePideResponderDelegaEnLasRespuestasLaResponsabilidadDeResponderse() {

        Respuestas respuestas = new Respuestas();
        Respuesta mockRespuesta1 = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);

        respuestas.agregarRespuesta(mockRespuesta1);
        respuestas.agregarRespuesta(mockRespuesta2);
        respuestas.agregarRespuesta(mockRespuesta3);

        Evaluador mockEvaluador = mock(Evaluador.class);
        Puntaje mockedPuntaje = mock(Puntaje.class);
        when(mockEvaluador.evaluarEleccion(any(Eleccion.class))).thenReturn(mockedPuntaje);

        respuestas.responder(mockEvaluador);

        verify(mockRespuesta1, times(1)).responderSegunEvaluador(mockEvaluador);
        verify(mockRespuesta2, times(1)).responderSegunEvaluador(mockEvaluador);
        verify(mockRespuesta3, times(1)).responderSegunEvaluador(mockEvaluador);
    }

    @Test
    public void test02RespuestasTieneRespuestasYCuandoSeActivaLaExclusividadAlJugadorQueRespondioBienLeLlegaElDobleYAlOtroNada(){
        Jugador joaqui = new Jugador("Juaqui");
        Jugador juancito = new Jugador("Juan");


        // Es fácil invertir una matriz.
        Opcion opcionCorrecta = new OpcionComun("Falso");
        Opcion opcionIncorrecta = new OpcionComun("Verdadero");


        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcionCorrecta);

        Evaluador evaluador = new VerdaderoFalso(opcionesCorrectas);

        Bonificador bonificadorComun1 = new Bonificador();
        Bonificador bonificadorComun2 = new Bonificador();

        List<Opcion> opcionesJoaqui = new ArrayList<Opcion>();
        opcionesJoaqui.add(new OpcionComun("Verdadero"));
        Eleccion eleccionJoaqui = new Eleccion(opcionesJoaqui);

        List<Opcion> opcionesJuancito = new ArrayList<Opcion>();
        opcionesJuancito.add(new OpcionComun("Falso"));
        Eleccion eleccionJuancito = new Eleccion(opcionesJuancito);


        Respuesta respuestaJoaqui = new Respuesta(joaqui, eleccionJoaqui, bonificadorComun1);
        Respuesta respuestaJuancito = new Respuesta(juancito, eleccionJuancito, bonificadorComun2);

        Respuestas respuestas = new Respuestas();

        respuestas.agregarRespuesta(respuestaJoaqui);
        respuestas.activarExclusividad();

        respuestas.agregarRespuesta(respuestaJuancito);


        respuestas.responder(evaluador);

        assertEquals(joaqui.puntosTotales(), 0);
        assertEquals(juancito.puntosTotales(), 2);
    }


    @Test
    public void test03RespuestasTieneRespuestasYCuandoSeActivaLaExclusividadAmbosJugadoresRespondenBienYPorLoTantoNingunoSumaPuntos(){
        Jugador santiGonzalez = new Jugador("Santi");
        Jugador sebastianGonzalez = new Jugador("Seba");


        // Todo número impar mayor que 5 se puede escribir como una suma de 3 números primos.
        Opcion opcionCorrecta = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");


        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcionCorrecta);

        Evaluador evaluador = new VerdaderoFalso(opcionesCorrectas);

        Bonificador bonificadorComun1 = new Bonificador();
        Bonificador bonificadorComun2 = new Bonificador();

        List<Opcion> opcionesSanti = new ArrayList<Opcion>();
        opcionesSanti.add(new OpcionComun("Verdadero"));
        Eleccion eleccionSanti = new Eleccion(opcionesSanti);

        List<Opcion> opcionesSeba = new ArrayList<Opcion>();
        opcionesSeba.add(new OpcionComun("Verdadero"));
        Eleccion eleccionSeba = new Eleccion(opcionesSeba);


        Respuesta respuestaSanti = new Respuesta(santiGonzalez, eleccionSanti, bonificadorComun1);
        Respuesta respuestaSeba = new Respuesta(sebastianGonzalez, eleccionSeba, bonificadorComun2);

        Respuestas respuestas = new Respuestas();

        respuestas.agregarRespuesta(respuestaSanti);
        respuestas.activarExclusividad();
        respuestas.agregarRespuesta(respuestaSeba);


        respuestas.responder(evaluador);

        assertEquals(santiGonzalez.puntosTotales(), 0);
        assertEquals(sebastianGonzalez.puntosTotales(), 0);
    }

    @Test
    public void test04RespuestasTieneRespuestasYCuandoSeActivaLaExclusividadAmbosJugadoresRespondenMalYPorLoTantoNingunoSumaPuntos(){
        Jugador manu = new Jugador("Manu");
        Jugador mariano = new Jugador("Mariano");


        // Un árbol binario tiene siempre raíz roja.
        Opcion opcionCorrecta = new OpcionComun("Falso");
        Opcion opcionIncorrecta = new OpcionComun("Verdadero");


        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcionCorrecta);

        Evaluador evaluador = new VerdaderoFalso(opcionesCorrectas);

        Bonificador bonificadorComun1 = new Bonificador();
        Bonificador bonificadorComun2 = new Bonificador();

        List<Opcion> opcionesManu = new ArrayList<Opcion>();
        opcionesManu.add(new OpcionComun("Verdadero"));
        Eleccion eleccionManu = new Eleccion(opcionesManu);

        List<Opcion> opcionesMariano = new ArrayList<Opcion>();
        opcionesMariano.add(new OpcionComun("Verdadero"));
        Eleccion eleccionMariano = new Eleccion(opcionesMariano);


        Respuesta respuestaManu = new Respuesta(manu, eleccionManu, bonificadorComun1);
        Respuesta respuestaMariano = new Respuesta(mariano, eleccionMariano, bonificadorComun2);

        Respuestas respuestas = new Respuestas();

        respuestas.agregarRespuesta(respuestaManu);
        respuestas.activarExclusividad();
        respuestas.agregarRespuesta(respuestaMariano);


        respuestas.responder(evaluador);

        assertEquals(manu.puntosTotales(), 0);
        assertEquals(mariano.puntosTotales(), 0);
    }

    @Test
    public void test05RespuestasTieneRespuestasYCuandoAmbosJugadoresActivanLaExclusividadAlJugadorQueRespondioBienLeLlegaElCuadrupleYAlOtroNada(){
        Jugador ine = new Jugador("Inés");
        Jugador mili = new Jugador("Milagros");


        // A roberta le gusta lo simple.
        Opcion opcionCorrecta = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");


        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcionCorrecta);

        Evaluador evaluador = new VerdaderoFalso(opcionesCorrectas);

        Bonificador bonificadorComun1 = new Bonificador();
        Bonificador bonificadorComun2 = new Bonificador();

        List<Opcion> opcionesIne = new ArrayList<Opcion>();
        opcionesIne.add(new OpcionComun("Verdadero"));
        Eleccion eleccionIne = new Eleccion(opcionesIne);

        List<Opcion> opcionesMili = new ArrayList<Opcion>();
        opcionesMili.add(new OpcionComun("Falso"));
        Eleccion eleccionMili = new Eleccion(opcionesMili);


        Respuesta respuestaIne = new Respuesta(ine, eleccionIne, bonificadorComun1);
        Respuesta respuestaMili = new Respuesta(mili, eleccionMili, bonificadorComun2);

        Respuestas respuestas = new Respuestas();

        respuestas.agregarRespuesta(respuestaIne);
        respuestas.activarExclusividad();

        respuestas.agregarRespuesta(respuestaMili);
        respuestas.activarExclusividad();


        respuestas.responder(evaluador);

        assertEquals(ine.puntosTotales(), 4);
        assertEquals(mili.puntosTotales(), 0);
    }


}