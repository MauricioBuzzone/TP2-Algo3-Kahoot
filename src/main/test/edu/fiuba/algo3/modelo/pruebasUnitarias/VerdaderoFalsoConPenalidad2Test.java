package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class VerdaderoFalsoConPenalidad2Test {
    @Test
    public void test01responderPreguntaConDosRespuestasAplicaResponderConEvaluadorACadaRespuestaEnviada(){

        String solucion = "Falso";
        String enunciado = "En FIUBA hay 11 carreras";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalsoConPenalidad2 verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad2(eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);

        verdaderoFalsoConPenalidad.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderConEvaluador(any(Evaluador.class));
    }

    @Test
    public void test02UnaPreguntaVerdaderoFalsoConPenalidadCuandoSeLaCreaConMasDeDosRespuestasCorrectasLanzaExcepcion() {

        String enunciado = "El gato de Schrodinger esta muerto";
        String solucion1 = "Verdadero";
        String solucion2 = "Falso";
        List<String> opcion = new ArrayList<String>();
        opcion.add(solucion1);
        opcion.add(solucion2);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        assertThrows(SolucionInvalidaException.class,
                () -> {
                    VerdaderoFalsoConPenalidad2 pregunta = new VerdaderoFalsoConPenalidad2(eleccionCorrecta);
                });
    }

    @Test
    public void test03VerdaderoFalsoConPenalidadRecibeUnaOpcionCorrectaYDevuelveUnCertificadoCorrecto(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad2(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (verdaderoFalsoConPenalidad.evaluarEleccion(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test04VerdaderoFalsoConPenalidadRecibeUnaOpcionIncorrectaYDevuelveUnCertificadoIncorrecto(){

        String texto = "2+2 = Pez";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad2(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Certificado certificado = verdaderoFalsoConPenalidad.evaluarEleccion(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(1);
    }
    @Test
    public void test05VerdaderoFalsoConPenalidadAlRecibirUnaEleccionConMasDeUnaOpcionYLanzaUnaExcepcion(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad2(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.cantidadDeOpciones()).thenReturn(3);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);


        assertThrows(EleccionInvalidaException.class,
                ()->{
                    Certificado certificado = verdaderoFalsoConPenalidad.evaluarEleccion(eleccion);
                });

    }

    @Test
    public void test06VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad2(mockedEleccion);

        String opcion = "Verdadero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        assert(verdaderoFalsoConPenalidad.sonOpcionesValidas(opciones));
    }
    @Test
    public void test07VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad2(mockedEleccion);

        String opcion1 = "Falso";
        String opcion2 = "Verdadero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidas(opciones));
    }
    @Test
    public void test08VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad2(mockedEleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidas(opciones));
    }
}
