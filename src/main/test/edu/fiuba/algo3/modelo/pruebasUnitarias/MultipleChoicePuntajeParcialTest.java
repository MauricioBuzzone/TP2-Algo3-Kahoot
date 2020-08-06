package edu.fiuba.algo3.modelo.pruebasUnitarias;
import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MultipleChoicePuntajeParcialTest {
    @Test
    public void test01MCPPAlResponderPreguntaConUnaRespuestaAEstaLePasaElEvaluadorCorrespondiente(){
        String enunciado = "¿Quiénes son profesores de AMII?";

        String opcion1 = "Sirne";
        String opcion2 = "Acero";
        String opcion3 = "Unger";
        String opcion4 = "Vargas";
        String opcion5 = "Piva";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);


        MultipleChoicePuntajeParcial multipleChoicePuntajeParcial=new MultipleChoicePuntajeParcial(correctas);

        Respuesta mockRespuesta = mock(Respuesta.class);

        multipleChoicePuntajeParcial.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));

    }


    @Test
    public void test02UnMultipleChoiceConPuntajeParcialLanzaUnaExcepcionCuandoSeIntentaInicializarConMasDe5pcionesCorrectas(){

        String enunciado = "p -> q";

        String opcion1 = "p'.q";
        String opcion2 = "q'-> p'";
        String opcion3 = "(p + q')'";
        String opcion4 = "p'.q + p.p'";
        String opcion5 = "p'.(q + p)";
        String opcion6 = "(p + (q'.p'))'";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion1);
        correctas.add(opcion2);
        correctas.add(opcion3);
        correctas.add(opcion4);
        correctas.add(opcion5);
        correctas.add(opcion6);


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoicePuntajeParcial multipleChoice = new MultipleChoicePuntajeParcial(correctas);
                });
    }

    @Test
    public void test03UnMultipleChoiceConPuntajeParcialLanzaUnaExcepcionCuandoSeIntentaInicializarConCeroOcionesCorrectas(){

        String enunciado = "P = NP";

        String opcion1 = "Si";
        String opcion2 = "Claramente no";
        String opcion3 = "Un poquito";
        String opcion4 = "Pablo = NicoPaez (?";
        String opcion5 = ":SonLoMismo:";

        List<String> correctas = new ArrayList<String>();

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoicePuntajeParcial multipleChoice = new MultipleChoicePuntajeParcial(correctas);
                });
    }
    @Test
    public void test04MultipleChoicePuntajeParcialRecibeUnaEleccionAcertadaYDevuelveUnPuntajeDeValorDos() {

        //Enunciado: Tema de Fisica II

        String texto1 = new String("Induccion magnetica");
        String texto2 = new String("Fuerza De Lorenz");
        String texto3 = new String("Diferenciacion");
        String texto4 = new String("Cuerpo Rigido");

        List<String> solucion = new ArrayList<String>();
        solucion.add(texto1);
        solucion.add(texto2);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);


        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 2);
    }

    @Test
    public void test05MultipleChoicePuntajeParcialRecibeUnaEleccionParcialmenteAcertadaDevuelveUnPuntajeDeValorUno() {

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


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }
    @Test
    public void test06MultipleChoicePuntajeParcialRecibeUnaEleccionParcialmenteDesacertadaDevuelveUnPuntajeDeValorCero() {

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


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
    @Test
    public void test07MultipleChoicePuntajeParcialRecibeUnaEleccionDesacertadaYDevuelveUnPuntajeDeValorCero() {

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


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);

    }

    @Test
    public void test08MultipleChoicePuntajeParcialRecibeUnaEleccionConMasOpcionesQueLasCorrectasDevuelvePuntajeCero(){

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


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
    @Test
    public void test09MultipleChoicePuntajeParcialRecibeUnaListaConTresOpcionesYDevuelveQueEsasOpcionesSonValidasComoSolucion(){

        String opcion1 = "Mike Wazowski";
        String opcion2 = "James P. Sullivan";
        String opcion3 = "Randall Boggs";

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(opciones);
        assert(multipleChoicePuntajeParcial.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test10MultipleChoicePuntajeParcialecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

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


        Evaluador multipleChoiceConPuntajeParcial = new MultipleChoicePuntajeParcial(opcionesValidas);

        List<String> opcionesInvalidas = new ArrayList<String>();
        opcionesInvalidas.add(opcion1);
        opcionesInvalidas.add(opcion2);
        opcionesInvalidas.add(opcion3);
        opcionesInvalidas.add(opcion4);
        opcionesInvalidas.add(opcion5);
        opcionesInvalidas.add(opcion6);

        assertFalse(multipleChoiceConPuntajeParcial.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }

    @Test
    public void test11MultipleChoicePuntajeParcialRecibeUnaListaConCeroOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

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

        Evaluador multipleChoiceConPuntajeParcial = new MultipleChoicePuntajeParcial(opcionesValidas);

        List<String> opcionesInvalidas = new ArrayList<String>();
        assertFalse(multipleChoiceConPuntajeParcial.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }

    @Test
    public void test12MultipleChoiceConPuntajeParcialPuedeInstanciarseConUnaListaDeOpcionesCorrectas(){

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


        TipoDePregunta multipleChoiceConPuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);
        Puntaje puntaje = multipleChoiceConPuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 3);
    }
}
