package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VerdaderoFalsoTest {
    @Test
    public void test01responderPreguntaConDosRespuestasAplicaResponderSegunEvaluadorACadaRespuestaEnviada(){

        String enunciado = "Se aprueba la entrega 0?";
        Opcion solucion = new OpcionComun("Seeee");
        List<Opcion> opcion= new ArrayList<Opcion>();
        opcion.add(solucion);

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(opcion);

        Respuesta mockRespuesta = mock(Respuesta.class);

        verdaderoFalso.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void test02UnaPreguntaVerdaderoFalsoCuandoSeLaCreaConMasDeDosRespuestasCorrectasLanzaExcepcion(){

        String enunciado = "El gato de Schrodinger esta muerto";
        Opcion solucion1 = new OpcionComun("Verdadero");
        Opcion solucion2 = new OpcionComun("Falso");
        List<Opcion> opcion= new ArrayList<Opcion>();
        opcion.add(solucion1);
        opcion.add(solucion2);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    VerdaderoFalso pregunta = new VerdaderoFalso(opcion);
                });
    }

    @Test
    public void test03VerdaderoFalsoRecibeUnaEleccionAcertadaYDevuelvePuntajeDeValorUno(){

        String enunciado = "Se aprueba la entrega 0?";
        Opcion solucion = new OpcionComun("Seeee");
        List<Opcion> opcion= new ArrayList<Opcion>();
        opcion.add(solucion);
        Evaluador verdaderoFalso = new VerdaderoFalso(opcion);

        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(true);

        Puntaje puntaje = verdaderoFalso.evaluarEleccion(eleccion);


        Bonificador bonificador = new Bonificador();


        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }

    @Test
    public void test04VerdaderoFalsoRecibeUnaEleccioDesacertadaYDevuelvePuntajeDeValorCero(){

        Opcion opcion = new OpcionComun(" 2+2 = 4 ");
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion);

        Evaluador verdaderoFalso = new VerdaderoFalso(opciones);
        Eleccion eleccionCorrecta = new Eleccion(opciones);

        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(false);

        Puntaje puntaje = verdaderoFalso.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
    @Test
    public void test05VerdaderoFalsoRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidasComoSolucion(){

        Opcion opcion = new OpcionComun("Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero");
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion);

        Evaluador verdaderoFalso = new VerdaderoFalso(opciones);

        assert(verdaderoFalso.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test06VerdaderoFalsoRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){

        Opcion opcion1 = new OpcionComun("Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero");
        Opcion opcion2 = new OpcionComun("Para cualquier grafo se cumple la relación Suma[d(v_i)] = 2|E(G)|");
        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcion1);

        Evaluador verdaderoFalso = new VerdaderoFalso(opcionesCorrectas);

        List<Opcion> opcionesInvalidas = new ArrayList<Opcion>();
        opcionesInvalidas.add(opcion1);
        opcionesInvalidas.add(opcion2);
        assertFalse(verdaderoFalso.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }
    @Test
    public void test07VerdaderoFalsoRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){

        Opcion opcion1 = new OpcionComun("Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero");
        Opcion opcion2 = new OpcionComun("Para cualquier grafo se cumple la relación Suma[d(v_i)] = 2|E(G)|");
        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcion1);


        List<Opcion> opciones = new ArrayList<Opcion>();
        Evaluador verdaderoFalso = new VerdaderoFalso(opcionesCorrectas);
        assertFalse(verdaderoFalso.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test8VerdaderoFalsoEvaluaEleccionCorrectaDevuelvePuntajeDevalorUno(){

        String enunciado = new String("La Pampa es una provincia de Argentina");
        Opcion opcion1 = new OpcionComun("Verdadero");
        Opcion opcion2 = new OpcionComun("Falso");


        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);


        TipoDePregunta verdaderoFalso = new VerdaderoFalso(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Puntaje puntaje = verdaderoFalso.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }
}
