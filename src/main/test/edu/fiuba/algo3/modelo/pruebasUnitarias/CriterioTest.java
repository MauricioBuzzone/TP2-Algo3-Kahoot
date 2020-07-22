package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriterioTest{

    @Test
    public void test01CriterioRecibeUnaOpcionCorrectaYDevuelvaValidezCorrecta(){

        String texto = "Vamos a aprobar la entrega 0";
        Opcion opcionCorrecta = new Opcion(texto);
        Criterio criterio = new Criterio(opcionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Opcion opcion = mock(Opcion.class);
        when(opcion.igualA(opcionCorrecta)).thenReturn(true);

        (criterio.validarCriterio(opcion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien();
    }

    @Test
    public void test02CriterioRecibeUnaOpcionIncorrectaYDevuelvaValidezIncorrecta(){

        String texto = " 2+2 = 4 ";
        Opcion opcionCorrecta = new Opcion(texto);
        Criterio criterio = new Criterio(opcionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Opcion opcion = mock(Opcion.class);
        when(opcion.igualA(opcionCorrecta)).thenReturn(false);

        (criterio.validarCriterio(opcion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal();
    }
}