package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        Eleccion eleccionCorrecta = new Eleccion(solucion);
        Eleccion eleccionJugador = new Eleccion(solucion);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccionCorrecta);

        Certificado certificado = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(3);
    }

    @Test
    public void test02MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteAcertadaConDosAciertosDevuelveUnCertificadoCorrectoDeValorDos(){
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
        Eleccion eleccionCorrecta = new Eleccion(solucion);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion3);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccionCorrecta);

        Certificado certificado = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(2);
    }

    @Test
    public void test03MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteDesacertadaConMasCorrectasQueIncorrectasDevuelveUnCertificadoCorrecto(){
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
        Eleccion eleccionCorrecta = new Eleccion(solucion);


        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccionCorrecta);

        Certificado certificado = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test04MultipleChoiceConPenalidadRecibeUnaEleccionParcialmenteDesacertadaConMasIncorrectasQueCorrectasDevuelveUnCertificadoIncorrecto() {
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
        Eleccion eleccionCorrecta = new Eleccion(solucion);

        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccionCorrecta);

        Certificado certificado = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(1);
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
        Eleccion eleccionCorrecta = new Eleccion(solucion);

        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccionCorrecta);

        Certificado certificado = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(2);
    }

    @Test
    public void test06MultipleChoiceConPenalidadRecibeUnaEleccionConTantosAciertosComoDesaciertosYDevuelveUnCertificadoIncorrectoDeValorCero(){
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
        Eleccion eleccionCorrecta = new Eleccion(solucion);

        List<String> opcionesJugador = new ArrayList<String>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        opcionesJugador.add(opcion4);
        Eleccion eleccionJugador = new Eleccion(opcionesJugador);

        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccionCorrecta);

        Certificado certificado = multipleChoiceConPenalidad.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }

    @Test
    public void test07MultipleChoiceConPenalidadRecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccion);
        String opcion1 = "Mulán";
        String opcion2 = "Pocahontas";
        String opcion3 = "Blancanieves";
        String opcion4 = "Elsa";
        String opcion5 = "Mérida";
        String opcion6 = "Moana";

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);
        opciones.add(opcion6);
        assertFalse(multipleChoiceConPenalidad.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test11MultipleChoiceConPenalidadRecibeUnaListaConCeroOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(eleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(multipleChoiceConPenalidad.sonOpcionesValidasComoSolucion(opciones));
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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceConPenalidad multipleChoice = new MultipleChoiceConPenalidad(eleccionCorrecta);
                });

    }
    @Test
    public void test13UnTipoDePreguntaMultipleChoiceConPenalidadAlTratarDeInstanciarseConCeroEleccionesComoSolucionLevantaLaExcepcionSolucionInvalida(){
        List<String> correctas = new ArrayList<String>();
        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceConPenalidad multipleChoice = new MultipleChoiceConPenalidad(eleccionCorrecta);
                });

    }


}