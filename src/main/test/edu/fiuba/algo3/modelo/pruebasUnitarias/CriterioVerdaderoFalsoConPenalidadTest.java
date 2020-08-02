package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CriterioVerdaderoFalsoConPenalidadTest {

    @Test
    public void test01CriterioRecibeUnaOpcionCorrectaYDevuelveLaValidezCorrecta(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalsoConPenalidad criterioVerdaderoFalsoConPenalidad = new CriterioVerdaderoFalsoConPenalidad(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (criterioVerdaderoFalsoConPenalidad.validarCriterio(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test02CriterioRecibeUnaOpcionIncorrectaYDevuelveLaValidezIncorrecta(){

        String texto = "2+2 = Pez";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalsoConPenalidad criterioVerdaderoFalsoConPenalidad = new CriterioVerdaderoFalsoConPenalidad(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Certificado certificado = criterioVerdaderoFalsoConPenalidad.validarCriterio(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(1);
    }
    @Test
    public void test03CriterioVFPAlRecibirUnaEleccionConMasDeUnaOpcionYLanzaUnaExcepcion(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalsoConPenalidad criterioVerdaderoFalsoConPenalidad = new CriterioVerdaderoFalsoConPenalidad(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.cantidadDeOpciones()).thenReturn(3);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);


        assertThrows(EleccionInvalidaException.class,
                ()->{
                    Certificado certificado = criterioVerdaderoFalsoConPenalidad.validarCriterio(eleccion);
                });

    }

    @Test
    public void test04UnCriterioVFPRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioVerdaderoFalsoConPenalidad(mockedEleccion);

        String opcion = "Verdadero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        assert(criterio.sonOpcionesValidas(opciones));
    }
    @Test
    public void test05UnCriterioVFPRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioVerdaderoFalsoConPenalidad(mockedEleccion);

        String opcion1 = "Falso";
        String opcion2 = "Verdadero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(criterio.sonOpcionesValidas(opciones));
    }
    @Test
    public void test06UnCriterioVFPRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioVerdaderoFalsoConPenalidad(mockedEleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(criterio.sonOpcionesValidas(opciones));
    }


}