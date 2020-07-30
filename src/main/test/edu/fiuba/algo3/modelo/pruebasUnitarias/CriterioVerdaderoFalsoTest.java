package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CriterioVerdaderoFalsoTest {

    @Test
    public void test01CriterioRecibeUnaOpcionCorrectaYDevuelveLaValidezCorrecta(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (criterioVerdaderoFalso.validarCriterio(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test02CriterioRecibeUnaOpcionIncorrectaYDevuelveLaValidezIncorrecta(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Certificado certificado = criterioVerdaderoFalso.validarCriterio(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
    @Test
    public void test03CriterioVFAlRecibirUnaEleccionConMasDeUnaOpcionYLanzaUnaExcepcion(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.cantidadDeOpciones()).thenReturn(3);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);


        assertThrows(EleccionInvalidaException.class,
                ()->{
                    Certificado certificado = criterioVerdaderoFalso.validarCriterio(eleccion);
                });

    }
}