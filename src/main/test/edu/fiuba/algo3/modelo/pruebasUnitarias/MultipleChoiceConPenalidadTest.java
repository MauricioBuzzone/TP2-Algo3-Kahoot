package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MultipleChoiceConPenalidadTest {
    @Test
    public void test01MultipleChoiceConPenalidadRecibeUnaEleccionCompletamenteAcertadaYDevuelveUnPuntajeDeValorTres(){

        String enunciado = new String("Provincias de Argentina");
        Opcion opcion1 = new OpcionComun("Entre Rios");
        Opcion opcion2 = new OpcionComun("Rosario");
        Opcion opcion3 =new OpcionComun("La Pampa");
        Opcion opcion4 = new OpcionComun("Bariloche");
        Opcion opcion5 = new OpcionComun("Jujuy");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 3);
    }

    @Test
    public void test02MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteAcertadaConDosAciertosDevuelveValorDos(){
        String enunciado = new String("Provincias de Argentina");
        Opcion opcion1 = new OpcionComun("Entre Rios");
        Opcion opcion2 = new OpcionComun("Rosario");
        Opcion opcion3 =new OpcionComun("La Pampa");
        Opcion opcion4 = new OpcionComun("Bariloche");
        Opcion opcion5 = new OpcionComun("Jujuy");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion3);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 2);
    }

    @Test
    public void test03MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteDesacertadaConMasCorrectasQueIncorrectasDevuelveValorUno(){
        String enunciado = new String("Provincias de Argentina");
        Opcion opcion1 = new OpcionComun("Entre Rios");
        Opcion opcion2 = new OpcionComun("Rosario");
        Opcion opcion3 =new OpcionComun("La Pampa");
        Opcion opcion4 = new OpcionComun("Bariloche");
        Opcion opcion5 = new OpcionComun("Jujuy");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);

    }

    @Test
    public void test04MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteDesacertadaConMasIncorrectasQueCorrectasDevuelveMenosUno() {
        String enunciado = new String("Provincias de Argentina");
        Opcion opcion1 = new OpcionComun("Entre Rios");
        Opcion opcion2 = new OpcionComun("Rosario");
        Opcion opcion3 =new OpcionComun("La Pampa");
        Opcion opcion4 = new OpcionComun("Bariloche");
        Opcion opcion5 = new OpcionComun("Jujuy");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), -1);
    }

    @Test
    public void test05MultipleChoiceConPenalidadRecibeUnaEleccionDesacertadaDevuelveUnCertificadoIncorrectoDeValorDos(){
        String enunciado = new String("Provincias de Argentina");
        Opcion opcion1 = new OpcionComun("Entre Rios");
        Opcion opcion2 = new OpcionComun("Rosario");
        Opcion opcion3 =new OpcionComun("La Pampa");
        Opcion opcion4 = new OpcionComun("Bariloche");
        Opcion opcion5 = new OpcionComun("Jujuy");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), -2);
    }

    @Test
    public void test06MultipleChoiceConPenalidadRecibeUnaEleccionConTantosAciertosComoDesaciertosYDevuevePuntajeCero(){
        String enunciado = new String("Provincias de Argentina");
        Opcion opcion1 = new OpcionComun("Entre Rios");
        Opcion opcion2 = new OpcionComun("Rosario");
        Opcion opcion3 =new OpcionComun("La Pampa");
        Opcion opcion4 = new OpcionComun("Bariloche");
        Opcion opcion5 = new OpcionComun("Jujuy");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        List<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }

    @Test
    public void test07MultipleChoiceConPenalidadRecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Pocahontas");
        Opcion opcion3 = new OpcionComun("Blancanieves");
        Opcion opcion4 = new OpcionComun("Elsa");
        Opcion opcion5 = new OpcionComun("Mérida");
        Opcion opcion6 = new OpcionComun("Moana");

        List<Opcion> opcionesValidas = new ArrayList<Opcion>();
        opcionesValidas.add(opcion1);
        opcionesValidas.add(opcion2);
        opcionesValidas.add(opcion3);
        opcionesValidas.add(opcion4);


        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(opcionesValidas);


        List<Opcion> opcionesInvalidas = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Pocahontas");
        Opcion opcion3 = new OpcionComun("Blancanieves");
        Opcion opcion4 = new OpcionComun("Elsa");
        Opcion opcion5 = new OpcionComun("Mérida");
        Opcion opcion6 = new OpcionComun("Moana");

        List<Opcion> opcionesValidas = new ArrayList<Opcion>();
        opcionesValidas.add(opcion1);
        opcionesValidas.add(opcion2);
        opcionesValidas.add(opcion3);
        opcionesValidas.add(opcion4);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(opcionesValidas);

        List<Opcion> opcionesInvalidas = new ArrayList<Opcion>();
        assertFalse(multipleChoiceConPenalidad.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }
    @Test
    public void test12UnTipoDePreguntaMultipleChoiceConPenalidadAlTratarDeInstanciarseConSeisEleccionesComoSolucionLevantaLaExcepcionSolucionInvalida(){


        String enunciado = "Princesas de Disney";

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Pocahontas");
        Opcion opcion3 = new OpcionComun("Blancanieves");
        Opcion opcion4 = new OpcionComun("Elsa");
        Opcion opcion5 = new OpcionComun("Mérida");
        Opcion opcion6 = new OpcionComun("Moana");

        List<Opcion> correctas = new ArrayList<Opcion>();
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
        List<Opcion> correctas = new ArrayList<Opcion>();


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceConPenalidad multipleChoice = new MultipleChoiceConPenalidad(correctas);
                });

    }

    @Test
    public void test14MultipleChoiceConPenalidadEvaluaUnaListaCorrectaDevuelvePuntajeDeValorTres(){

        Opcion enunciado = new OpcionComun("Provincias de Argentina");
        Opcion opcion1 = new OpcionComun("Entre Rios");
        Opcion opcion2 = new OpcionComun("Rosario");
        Opcion opcion3 = new OpcionComun("La Pampa");
        Opcion opcion4 = new OpcionComun("Bariloche");
        Opcion opcion5 = new OpcionComun("Jujuy");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);


        TipoDePregunta multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);
        Puntaje puntaje = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 3);
    }

}