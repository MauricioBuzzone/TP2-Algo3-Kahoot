package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void test01GroupChoiceRecibeUnaEleccionAcertadaYDevuelvePuntajeDeValorUno(){

        String enunciado = "A grupar los siguientes pilotos";


        Opcion opcion1 = new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion2 = new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con 1 DWC");
        Opcion opcion3 = new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion4 = new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC");
        Opcion opcion5 = new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);
        solucion.add(opcion4);
        solucion.add(opcion5);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Evaluador groupChoice = new GroupChoice(solucion);

        Puntaje puntaje = groupChoice.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }

    @Test
    public void test02GroupChoiceRecibeUnaEleccionDesacertadaYDevuelvePuntajeDeValorCero(){

        String enunciado = "A grupar los siguientes pilotos";


        Opcion opcion1 = new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion2 = new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con 1 DWC");
        Opcion opcion3 = new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion4 = new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC");
        Opcion opcion5 = new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);
        solucion.add(opcion4);
        solucion.add(opcion5);
        Evaluador groupChoice = new GroupChoice(solucion);


        Opcion opcion6 = new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con 1 DWC");
        Opcion opcion7 = new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con 1 DWC");
        Opcion opcion8 = new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion9 = new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion10 = new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC");

        List<Opcion> solucionJugador = new ArrayList<Opcion>();
        solucionJugador.add(opcion6);
        solucionJugador.add(opcion7);
        solucionJugador.add(opcion8);
        solucionJugador.add(opcion9);
        solucionJugador.add(opcion10);
        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Puntaje puntaje = groupChoice.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
}
