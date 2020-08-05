package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


public class MultipleChoiceConPenalidadTest{
    @Test
    public void test01MultipleChoiceConPenalidadRecibeUnaEleccionCompletamenteAcertadaYDevuelveUnCertifiadoCorrecto(){

        String enunciado = new String("Provincias de Argentina");
        String opcion1 = new String("Entre Rios");
        String opcion2 = new String("Rosario");
        String opcion3 = new String("La Pampa");
        String opcion4 = new String("Bariloche");
        String opcion5 = new String("Jujuy");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), 3);
    }

    @Test
    public void test02MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteAcertadaConDosAciertosDevuelveValorDos(){
        String enunciado = new String("Provincias de Argentina");
        String opcion1 = new String("Entre Rios");
        String opcion2 = new String("Rosario");
        String opcion3 = new String("La Pampa");
        String opcion4 = new String("Bariloche");
        String opcion5 = new String("Jujuy");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion3);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), 2);
    }

    @Test
    public void test03MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteDesacertadaConMasCorrectasQueIncorrectasDevuelveValorUno(){
        String enunciado = new String("Provincias de Argentina");
        String opcion1 = new String("Entre Rios");
        String opcion2 = new String("Rosario");
        String opcion3 = new String("La Pampa");
        String opcion4 = new String("Bariloche");
        String opcion5 = new String("Jujuy");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), 1);
    }

    @Test
    public void test04MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteDesacertadaConMasIncorrectasQueCorrectasDevuelveMenosUno() {
        String enunciado = new String("Provincias de Argentina");
        String opcion1 = new String("Entre Rios");
        String opcion2 = new String("Rosario");
        String opcion3 = new String("La Pampa");
        String opcion4 = new String("Bariloche");
        String opcion5 = new String("Jujuy");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), -1);
    }

    @Test
    public void test05MultipleChoiceConPenalidadRecibeUnaEleccionDesacertadaDevuelveUnCertificadoIncorrectoDeValorDos(){
        String enunciado = new String("Provincias de Argentina");
        String opcion1 = new String("Entre Rios");
        String opcion2 = new String("Rosario");
        String opcion3 = new String("La Pampa");
        String opcion4 = new String("Bariloche");
        String opcion5 = new String("Jujuy");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), -2);
    }

    @Test
    public void test06MultipleChoiceConPenalidadRecibeUnaEleccionConTantosAciertosComoDesaciertosYDevuevePuntajeCero(){
        String enunciado = new String("Provincias de Argentina");
        String opcion1 = new String("Entre Rios");
        String opcion2 = new String("Rosario");
        String opcion3 = new String("La Pampa");
        String opcion4 = new String("Bariloche");
        String opcion5 = new String("Jujuy");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), 0);
    }

    @Test
    public void test07MultipleChoiceConPenalidadRecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

        String opcion1 = "Mulán";
        String opcion2 = "Pocahontas";
        String opcion3 = "Blancanieves";
        String opcion4 = "Elsa";
        String opcion5 = "Mérida";
        String opcion6 = "Moana";

        List<String> opcionesValidas = new ArrayList<String>();
        opcionesValidas.add(opcion1);
        opcionesValidas.add(opcion2);
        opcionesValidas.add(opcion3);
        opcionesValidas.add(opcion4);


        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(opcionesValidas);

        List<String> opcionesInvalidas = new ArrayList<String>();
        opcionesInvalidas.add(opcion1);
        opcionesInvalidas.add(opcion2);
        opcionesInvalidas.add(opcion3);
        opcionesInvalidas.add(opcion4);
        opcionesInvalidas.add(opcion5);
        opcionesInvalidas.add(opcion6);

        assertFalse(multipleChoiceConPenalidad.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }

    @Test
    public void test11MultipleChoiceConPenalidadRecibeUnaListaConCeroOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

        String opcion1 = "Mulán";
        String opcion2 = "Pocahontas";
        String opcion3 = "Blancanieves";
        String opcion4 = "Elsa";
        String opcion5 = "Mérida";
        String opcion6 = "Moana";

        List<String> opcionesValidas = new ArrayList<String>();
        opcionesValidas.add(opcion1);
        opcionesValidas.add(opcion2);
        opcionesValidas.add(opcion3);
        opcionesValidas.add(opcion4);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(opcionesValidas);

        List<String> opcionesInvalidas = new ArrayList<String>();
        assertFalse(multipleChoiceConPenalidad.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }
    @Test
    public void test12UnTipoDePreguntaMultipleChoiceConPenalidadAlTratarDeInstanciarseConSeisEleccionesComoSolucionLevantaLaExcepcionSolucionInvalida(){


        String enunciado = "Princesas de Disney";

        String opcion1 = "Mulán";
        String opcion2 = "Pocahontas";
        String opcion3 = "Blancanieves";
        String opcion4 = "Elsa";
        String opcion5 = "Mérida";
        String opcion6 = "Moana";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);
        correctas.add(opcion4);
        correctas.add(opcion5);
        correctas.add(opcion6);


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceConPenalidad multipleChoice = new MultipleChoiceConPenalidad(correctas);
                });

    }
    @Test
    public void test13UnTipoDePreguntaMultipleChoiceConPenalidadAlTratarDeInstanciarseConCeroEleccionesComoSolucionLevantaLaExcepcionSolucionInvalida(){
        List<String> correctas = new ArrayList<String>();


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceConPenalidad multipleChoice = new MultipleChoiceConPenalidad(correctas);
                });

    }

    @Test
    public void test14MultipleChoiceConPenalidadEvaluaUnaListaCorrectaDevuelvePuntajeDeValorTres(){

        String enunciado = new String("Provincias de Argentina");
        String opcion1 = new String("Entre Rios");
        String opcion2 = new String("Rosario");
        String opcion3 = new String("La Pampa");
        String opcion4 = new String("Bariloche");
        String opcion5 = new String("Jujuy");

        List<String> solucion = new ArrayList<String>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        TipoDePregunta multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);
        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        assertEquals(puntaje.calcularPuntaje(), 3);
    }

}