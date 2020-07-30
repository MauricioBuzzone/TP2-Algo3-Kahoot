package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CriterioMultipleChoiceParcialTest{

    @Test
    public void test01CriterioMultipleChoiceParcialRecibeUnaEleccionBienContestadaDevuelveValidezCorrecta() {

        //Enunciado: Tema de Fisica II

        String texto1 = new String("Induccion magnetica");
        String texto2 = new String("Fuerza De Lorenz");
        String texto3 = new String("Diferenciacion");
        String texto4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(texto1);
        solucion.add(texto2);
        Eleccion eleccionCorrecta = new Eleccion(solucion);
        Eleccion eleccionJugador = new Eleccion(solucion);

        CriterioMultipleChoiceParcial criterio = new CriterioMultipleChoiceParcial(eleccionCorrecta);


        Certificado certificado = criterio.validarCriterio(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(2);
    }

    @Test
    public void test02CriterioMultipleChoiceParcialRecibeUnaEleccionParcialmenteCorrectaDevuelveValidezCorrecta() {

        //Enunciado: Tema de Fisica II

        String texto1 = new String("Induccion magnetica");
        String texto2 = new String("Fuerza De Lorenz");
        String texto3 = new String("Diferenciacion");
        String texto4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(texto1);
        solucion.add(texto2);

        List<String> solucionJugador = new ArrayList<String>();
        solucionJugador.add(texto1);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        CriterioMultipleChoiceParcial criterio = new CriterioMultipleChoiceParcial(eleccionCorrecta);

        Certificado certificado = criterio.validarCriterio(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }
    @Test
    public void test03CriterioMultipleChoiceParcialRecibeUnaEleccionParcialmenteIncorrectaDevuelveValidezIncorrecta() {

        //Enunciado: Tema de Fisica II

        String texto1 = new String("Induccion magnetica");
        String texto2 = new String("Fuerza De Lorenz");
        String texto3 = new String("Diferenciacion");
        String texto4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(texto1);
        solucion.add(texto2);

        List<String> solucionJugador = new ArrayList<String>();
        solucionJugador.add(texto3);
        solucionJugador.add(texto2);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        CriterioMultipleChoiceParcial criterio = new CriterioMultipleChoiceParcial(eleccionCorrecta);

        Certificado certificado = criterio.validarCriterio(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
    @Test
    public void test04CriterioMultipleChoiceParcialRecibeUnaEleccionIncorrectaDevuelveValidezIncorrecta() {

        //Enunciado: Tema de Fisica II

        String texto1 = new String("Induccion magnetica");
        String texto2 = new String("Fuerza De Lorenz");
        String texto3 = new String("Diferenciacion");
        String texto4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(texto1);
        solucion.add(texto2);

        List<String> solucionJugador = new ArrayList<String>();
        solucionJugador.add(texto3);
        solucionJugador.add(texto4);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        CriterioMultipleChoiceParcial criterio = new CriterioMultipleChoiceParcial(eleccionCorrecta);

        Certificado certificado = criterio.validarCriterio(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }

    @Test
    public void test05CriterioMultipleChoiceParcialRecibeUnaEleccionConMasOpcionesDevuelveValidezIncorrecta(){

        //Enunciado: Tema de Fisica II

        String texto1 = new String("Induccion magnetica");
        String texto2 = new String("Fuerza De Lorenz");
        String texto3 = new String("Diferenciacion");
        String texto4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(texto1);
        solucion.add(texto2);

        List<String> solucionJugador = new ArrayList<String>();
        solucionJugador.add(texto3);
        solucionJugador.add(texto4);
        solucionJugador.add(texto1);
        solucionJugador.add(texto2);

        Eleccion eleccionCorrecta = new Eleccion(solucion);
        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        CriterioMultipleChoiceParcial criterio = new CriterioMultipleChoiceParcial(eleccionCorrecta);

        Certificado certificado = criterio.validarCriterio(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
}