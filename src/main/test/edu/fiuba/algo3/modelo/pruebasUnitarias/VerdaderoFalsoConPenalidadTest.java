package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.SolucionInvalidaException;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.TipoDePregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VerdaderoFalsoConPenalidadTest {
    @Test
    public void test01responderPreguntaConDosRespuestasAplicaResponderSegunEvaluadorACadaRespuestaEnviada(){

        String enunciado = "En FIUBA hay 11 carreras";
        Opcion solucion = new OpcionComun("Falso");
        List<Opcion> opcion= new ArrayList<Opcion>();
        opcion.add(solucion);

        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcion);

        Respuesta mockRespuesta = mock(Respuesta.class);

        verdaderoFalsoConPenalidad.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void test02UnaPreguntaVerdaderoFalsoConPenalidadCuandoSeLaCreaConMasDeDosRespuestasCorrectasLanzaExcepcion() {

        String enunciado = "El gato de Schrodinger esta muerto";
        Opcion solucion1 = new OpcionComun("Verdadero");
        Opcion solucion2 = new OpcionComun("Falso");
        List<Opcion> opcion= new ArrayList<Opcion>();
        opcion.add(solucion1);
        opcion.add(solucion2);

        assertThrows(SolucionInvalidaException.class,
                () -> {
                    VerdaderoFalsoConPenalidad pregunta = new VerdaderoFalsoConPenalidad(opcion);
                });
    }

    @Test
    public void test03VerdaderoFalsoConPenalidadRecibeUnaEleccionAcertadaYDevuelvePuntajeDeValorUno(){

        Opcion opcion = new OpcionComun("Vamos a aprobar la entrega 0");
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opciones);

        Eleccion eleccionCorrecta = new Eleccion(opciones);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(true);

        Puntaje puntaje = verdaderoFalsoConPenalidad.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }

    @Test
    public void test04VerdaderoFalsoConPenalidadRecibeUnaEleccionDesacertadaYDevuelveUnPuntajeDeValorMenosUno(){

        Opcion opcion = new OpcionComun("2+2 = Pez");
        List<Opcion> opciones= new ArrayList<Opcion>();
        opciones.add(opcion);
        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opciones);
        Eleccion eleccionCorrecta = new Eleccion(opciones);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(false);

        Puntaje puntaje = verdaderoFalsoConPenalidad.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), -1);
    }

    @Test
    public void test05VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidasComoSolucion(){

        Opcion opcion = new OpcionComun("Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero");
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion);

        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opciones);

        assert(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test06VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        Opcion opcion1 = new OpcionComun("Falso");
        Opcion opcion2 = new OpcionComun("Verdadero");

        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcion1);

        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcionesCorrectas);


        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test07VerdaderoFalsoConPenalidadRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){
        Opcion opcion1 = new OpcionComun("Falso");
        Opcion opcion2 = new OpcionComun("Verdadero");

        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcion1);

        Evaluador verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(opcionesCorrectas);

        List<Opcion> opciones = new ArrayList<Opcion>();
        assertFalse(verdaderoFalsoConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }


    @Test
    public void test8VerdaderoFalsoConPenalidadEvaluaEleccionYDevuelvePuntajeDeValorUno(){

        String enunciado = new String("La Pampa es una provincia de Argentina");
        Opcion opcion1 = new OpcionComun("Verdadero");
        Opcion opcion2 = new OpcionComun("Falso");


        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);


        TipoDePregunta verdaderoFalso = new VerdaderoFalsoConPenalidad(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);
        Puntaje puntaje = verdaderoFalso.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }
}
