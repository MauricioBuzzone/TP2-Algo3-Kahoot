package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
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

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(opcion);

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

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    VerdaderoFalso pregunta = new VerdaderoFalso(opcion);
                });
    }

    @Test
    public void test03VerdaderoFalsoRecibeUnaEleccionAcertadaYDevuelvePuntajeDeValorUno(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
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

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Evaluador verdaderoFalso = new VerdaderoFalso(opcion);
        Eleccion eleccionCorrecta = new Eleccion(opcion);

        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(false);

        Puntaje puntaje = verdaderoFalso.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
    @Test
    public void test05VerdaderoFalsoRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidasComoSolucion(){

        String opcion = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        Evaluador verdaderoFalso = new VerdaderoFalso(opciones);

        assert(verdaderoFalso.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test06VerdaderoFalsoRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){

        String opcion1 = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        String opcion2 = "Para cualquier grafo se cumple la relación Suma[d(v_i)] = 2|E(G)|";
        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add(opcion1);

        Evaluador verdaderoFalso = new VerdaderoFalso(opcionesCorrectas);

        List<String> opcionesInvalidas = new ArrayList<String>();
        opcionesInvalidas.add(opcion1);
        opcionesInvalidas.add(opcion2);
        assertFalse(verdaderoFalso.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }
    @Test
    public void test07VerdaderoFalsoRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidasComoSolucion(){

        String opcion1 = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        String opcion2 = "Para cualquier grafo se cumple la relación Suma[d(v_i)] = 2|E(G)|";
        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add(opcion1);


        List<String> opciones = new ArrayList<String>();
        Evaluador verdaderoFalso = new VerdaderoFalso(opcionesCorrectas);
        assertFalse(verdaderoFalso.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test8VerdaderoFalsoEvaluaEleccionCorrectaDevuelvePuntajeDevalorUno(){

        String enunciado = new String("La Pampa es una provincia de Argentina");
        String opcion1 = new String("Verdadero");
        String opcion2 = new String("Falso");


        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);


        TipoDePregunta verdaderoFalso = new VerdaderoFalso(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Puntaje puntaje = verdaderoFalso.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }
}
