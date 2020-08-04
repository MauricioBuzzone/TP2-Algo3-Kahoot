package edu.fiuba.algo3.modelo;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class VerdaderoFalsoTest {
    @Test
    public void test01responderPreguntaConDosRespuestasAplicaResponderSegunEvaluadorACadaRespuestaEnviada(){

        String solucion = "Seeee";
        String enunciado = "Se aprueba la entrega 0?";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);

        verdaderoFalso.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void test02UnaPreguntaVerdaderoFalsoCuandoSeLaCreaConMasDeDosRespuestasCorrectasLanzaExcepcion(){

        String enunciado = "El gato de Schrodinger esta muerto";
        String solucion1 = "Verdadero";
        String solucion2 = "Falso";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion1);
        opcion.add(solucion2);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        assertThrows(SolucionInvalidaException.class,
                ()->{
                    VerdaderoFalso pregunta = new VerdaderoFalso(eleccionCorrecta);
                });
    }

    @Test
    public void test03VerdaderoFalsoRecibeUnaEleccionAcertadaYDevuelveUnCertificadoCorrecto(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalso = new VerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (verdaderoFalso.evaluarEleccion(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test04VerdaderoFalsoRecibeUnaEleccioDesacertadaYDevuelveUnCertificadoIncorrecto(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalso = new VerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Certificado certificado = verdaderoFalso.evaluarEleccion(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
    @Test
    public void test05VerdaderoFalsoRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidasComoSolucion(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalso = new VerdaderoFalso(mockedEleccion);

        String opcion = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        assert(verdaderoFalso.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test06VerdaderoFalsoRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalso = new VerdaderoFalso(mockedEleccion);

        String opcion1 = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        String opcion2 = "Para cualquier grafo se cumple la relación Suma[d(v_i)] = 2|E(G)|";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(verdaderoFalso.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test07VerdaderoFalsoRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalso = new VerdaderoFalso(mockedEleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(verdaderoFalso.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test8VerdaderoFalsoConPuntajeParcialPuedeInstanciarseConUnaListaDeOpcionesCorrectasEInstanciarUna(){

        String enunciado = new String("La Pampa es una provincia de Argentina");
        String opcion1 = new String("Verdadero");
        String opcion2 = new String("Falso");


        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);


        TipoDePregunta verdaderoFalso = new VerdaderoFalso(solucion);

        Eleccion eleccionJugador = verdaderoFalso.crearEleccion(solucion);

        Certificado certificado = verdaderoFalso.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }
}
