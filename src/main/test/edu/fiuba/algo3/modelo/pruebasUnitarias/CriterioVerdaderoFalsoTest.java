package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriterioVerdaderoFalsoTest {

    @Test
    public void test01CriterioRecibeUnaOpcionCorrectaYDevuelvaValidezCorrecta(){

        String texto = "Vamos a aprobar la entrega 0";
        Eleccion eleccionCorrecta = new Eleccion(texto);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (criterioVerdaderoFalso.validarCriterio(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test02CriterioRecibeUnaOpcionIncorrectaYDevuelvaValidezIncorrecta(){

        String texto = " 2+2 = 4 ";
        Eleccion eleccionCorrecta = new Eleccion(texto);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Validez validez = criterioVerdaderoFalso.validarCriterio(eleccion);
        validez.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
}