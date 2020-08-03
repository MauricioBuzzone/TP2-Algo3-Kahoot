package edu.fiuba.algo3.modelo;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class VerdaderoFalsoTest {
    @Test
    public void test01responderPreguntaConDosRespuestasAplicaResponderConEvaluadorACadaRespuestaEnviada(){

        String solucion = "Seeee";
        String enunciado = "Se aprueba la entrega 0?";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);

        verdaderoFalso.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderConEvaluador(any(Evaluador.class));
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
    public void test03VerdaderoFalsoRecibeUnaOpcionCorrectaYDevuelveUnCertificadoCorrecto(){

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
    public void test04VerdaderoFalsoRecibeUnaOpcionIncorrectaYDevuelveUnCertificadoIncorrecto(){

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
    public void test05VerdaderoFalsoAlRecibirUnaEleccionConMasDeUnaOpcionLanzaUnaExcepcion(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalso = new VerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.cantidadDeOpciones()).thenReturn(3);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);


        assertThrows(EleccionInvalidaException.class,
                ()->{
                    Certificado certificado = verdaderoFalso.evaluarEleccion(eleccion);
                });

    }
    @Test
    public void test06VerdaderoFalsoRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalso = new VerdaderoFalso(mockedEleccion);

        String opcion = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        assert(verdaderoFalso.sonOpcionesValidas(opciones));
    }
    @Test
    public void test07VerdaderoFalsoRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalso = new VerdaderoFalso(mockedEleccion);

        String opcion1 = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        String opcion2 = "Para cualquier grafo se cumple la relación Suma[d(v_i)] = 2|E(G)|";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(verdaderoFalso.sonOpcionesValidas(opciones));
    }
    @Test
    public void test08VerdaderoFalsoRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalso = new VerdaderoFalso(mockedEleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(verdaderoFalso.sonOpcionesValidas(opciones));
    }
}
