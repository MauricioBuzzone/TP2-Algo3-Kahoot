package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriterioVerdaderoFalsoTest {

    @Test
    public void test01CriterioRecibeUnaOpcionCorrectaYDevuelvaValidezCorrecta(){

        String texto = "Vamos a aprobar la entrega 0";
        Opcion opcionCorrecta = new Opcion(texto);
        CriterioVF criterioVF = new CriterioVF(opcionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Opcion opcion = mock(Opcion.class);
        when(opcion.igualA(opcionCorrecta)).thenReturn(true);

        (criterioVF.validarCriterio(opcion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test02CriterioRecibeUnaOpcionIncorrectaYDevuelvaValidezIncorrecta(){

        String texto = " 2+2 = 4 ";
        Opcion opcionCorrecta = new Opcion(texto);
        CriterioVF criterioVF = new CriterioVF(opcionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Opcion opcion = mock(Opcion.class);
        when(opcion.igualA(opcionCorrecta)).thenReturn(false);

        Validez validez = criterioVF.validarCriterio(opcion);
        validez.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
}