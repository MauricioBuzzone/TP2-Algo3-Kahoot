package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CriterioMultipleChoiceClasicoTest {

    @Test
    public void test01CriterioRecibeUnaOpcionCorrectaYDevuelveLaValidezCorrecta() {


        String enunciado = "¿Cuales son los Pilares de POO?";
        String opcion1 = "Polimorfismo";
        String opcion2 = "Bajo acoplamiento";
        String opcion3 = "Alta cohesion";
        String opcion4 = "Herencia";
        String opcion5 = "Abstraccion";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion4);
        correctas.add(opcion5);

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        CriterioMultipleChoiceClasico criterioMultipleChoice = new CriterioMultipleChoiceClasico(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);

        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (criterioMultipleChoice.validarCriterio(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test02CriterioRecibeUnaOpcionIncorrectaYDevuelvaValidezIncorrecta(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioMultipleChoiceClasico criterioVerdaderoFalso = new CriterioMultipleChoiceClasico(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Validez validez = criterioVerdaderoFalso.validarCriterio(eleccion);
        validez.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
}
