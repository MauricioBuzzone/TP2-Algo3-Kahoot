package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GroupChoiceTest {

    @Test
    public void test01GroupChoiceRecibeUnaEleccionAcertadaYDevuelveUnCertifiadoCorrecto(){

        String enunciado = new String(" Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");
        String opcion1 = new String("Niki Lauda");
        String opcion2 = new String("Nico Rosberg");
        String opcion3 = new String("Lewis Hamilton");
        String opcion4 = new String("Damon Hill");
        String opcion5 = new String("Fernando Alonso");

        List<String> solucionGrupoA = new ArrayList<String>();
        solucionGrupoA.add(opcion1);
        solucionGrupoA.add(opcion3);
        solucionGrupoA.add(opcion5);
        Eleccion eleccionCorrecta = new Eleccion(solucionGrupoA);
        Eleccion eleccionJugador = new Eleccion(solucionGrupoA);

        Evaluador groupChoice = new GroupChoice(eleccionCorrecta);

        Certificado certificado = groupChoice.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test02GroupChoiceRecibeUnaEleccionDesacertadaYDevuelveUnCertificadoIncorrecto(){

        String enunciado = new String(" Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");
        String opcion1 = new String("Niki Lauda");
        String opcion2 = new String("Nico Rosberg");
        String opcion3 = new String("Lewis Hamilton");
        String opcion4 = new String("Damon Hill");
        String opcion5 = new String("Fernando Alonso");


        List<String> solucionGrupoA = new ArrayList<String>();
        solucionGrupoA.add(opcion1);
        solucionGrupoA.add(opcion3);
        solucionGrupoA.add(opcion5);
        Eleccion eleccionCorrecta = new Eleccion(solucionGrupoA);

        List<String> solucionJugador = new ArrayList<String>();
        solucionJugador.add(opcion2);
        solucionJugador.add(opcion3);
        solucionJugador.add(opcion5);
        Eleccion eleccionJugador = new Eleccion(solucionJugador);


        Evaluador groupChoice = new GroupChoice(eleccionCorrecta);

        Certificado certificado = groupChoice.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }



}
