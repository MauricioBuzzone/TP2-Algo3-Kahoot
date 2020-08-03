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
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(eleccionCorrecta);

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
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        assertThrows(SolucionInvalidaException.class,
                () -> {
                    VerdaderoFalsoConPenalidad pregunta = new VerdaderoFalsoConPenalidad(eleccionCorrecta);
                });
    }

    @Test
    public void test03VerdaderoFalsoConPenalidadRecibeUnaEleccionAcertadaYDevuelveUnCertificadoCorrecto(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (verdaderoFalsoConPenalidad.evaluarEleccion(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test04VerdaderoFalsoConPenalidadRecibeUnaEleccionDesacertadaYDevuelveUnCertificadoIncorrecto(){

        String texto = "2+2 = Pez";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Certificado certificado = verdaderoFalsoConPenalidad.evaluarEleccion(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(1);
    }

    @Test
    public void test05VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidasComoSolucion(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(mockedEleccion);

        String opcion = "Verdadero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        assert(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test06VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(mockedEleccion);

        String opcion1 = "Falso";
        String opcion2 = "Verdadero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test07VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        when(mockedEleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(mockedEleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }
}
