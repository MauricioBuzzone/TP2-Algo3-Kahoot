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

public class VerdaderoFalsoConPenalidadTest {
    @Test
    public void test01responderPreguntaConDosRespuestasAplicaResponderSegunEvaluadorACadaRespuestaEnviada(){

        String solucion = "Falso";
        String enunciado = "En FIUBA hay 11 carreras";
        List<String> opcion= new ArrayList<String>();
        opcion.add(solucion);

        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcion);

        Respuesta mockRespuesta = mock(Respuesta.class);

        verdaderoFalsoConPenalidad.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void test02UnaPreguntaVerdaderoFalsoConPenalidadCuandoSeLaCreaConMasDeDosRespuestasCorrectasLanzaExcepcion() {

        String enunciado = "El gato de Schrodinger esta muerto";
        String solucion1 = "Verdadero";
        String solucion2 = "Falso";
        List<String> opcion = new ArrayList<String>();
        opcion.add(solucion1);
        opcion.add(solucion2);

        assertThrows(SolucionInvalidaException.class,
                () -> {
                    VerdaderoFalsoConPenalidad pregunta = new VerdaderoFalsoConPenalidad(opcion);
                });
    }

    @Test
    public void test03VerdaderoFalsoConPenalidadRecibeUnaEleccionAcertadaYDevuelveUnCertificadoCorrecto(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion = new ArrayList<String>();
        opcion.add(texto);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcion);

        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(true);

        (verdaderoFalsoConPenalidad.evaluarEleccion(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test04VerdaderoFalsoConPenalidadRecibeUnaEleccionDesacertadaYDevuelveUnCertificadoIncorrecto(){

        String texto = "2+2 = Pez";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(false);

        Certificado certificado = verdaderoFalsoConPenalidad.evaluarEleccion(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(1);
    }

    @Test
    public void test05VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidasComoSolucion(){

        String opcion = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opciones);

        assert(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test06VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        String opcion1 = "Falso";
        String opcion2 = "Verdadero";

        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add(opcion1);

        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcionesCorrectas);


        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test07VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        String opcion1 = "Falso";
        String opcion2 = "Verdadero";

        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add(opcion1);

        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcionesCorrectas);

        List<String> opciones = new ArrayList<String>();
        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }


    @Test
    public void test8VerdaderoFalsoConPenalidadConPuntajeParcialPuedeInstanciarseConUnaListaDeOpcionesCorrectasEInstanciarUna(){

        String enunciado = new String("La Pampa es una provincia de Argentina");
        String opcion1 = new String("Verdadero");
        String opcion2 = new String("Falso");


        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);


        TipoDePregunta verdaderoFalso = new VerdaderoFalsoConPenalidad(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);
        Certificado certificado = verdaderoFalso.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }
}
