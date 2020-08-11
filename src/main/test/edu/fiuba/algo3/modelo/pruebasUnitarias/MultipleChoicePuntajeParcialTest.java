package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MultipleChoicePuntajeParcialTest {
    @Test
    public void test01MCPPAlResponderPreguntaConUnaRespuestaAEstaLePasaElEvaluadorCorrespondiente(){
        String enunciado = "¿Quiénes son profesores de AMII?";

        Opcion opcion1 = new OpcionComun("Sirne");
        Opcion opcion2 = new OpcionComun("Acero");
        Opcion opcion3 = new OpcionComun("Unger");
        Opcion opcion4 = new OpcionComun("Vargas");
        Opcion opcion5 = new OpcionComun("Piva");

        List<Opcion> correctas = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionComun("p'.q");
        Opcion opcion2 = new OpcionComun("q'-> p'");
        Opcion opcion3 = new OpcionComun("(p + q')'");
        Opcion opcion4 = new OpcionComun("p'.q + p.p'");
        Opcion opcion5 = new OpcionComun("p'.(q + p)");
        Opcion opcion6 = new OpcionComun("(p + (q'.p'))'");

        List<Opcion> correctas = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionComun("Si");
        Opcion opcion2 = new OpcionComun("Claramente no");
        Opcion opcion3 = new OpcionComun("Un poquito");
        Opcion opcion4 = new OpcionComun("Pablo = NicoPaez (?");
        Opcion opcion5 = new OpcionComun(":SonLoMismo:");

        List<Opcion> correctas = new ArrayList<Opcion>();

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoicePuntajeParcial multipleChoice = new MultipleChoicePuntajeParcial(correctas);
                });
    }
    @Test
    public void test04MultipleChoicePuntajeParcialRecibeUnaEleccionAcertadaYDevuelveUnPuntajeDeValorDos() {

        //Enunciado: Tema de Fisica II

        Opcion opcion1 = new OpcionComun("Induccion magnetica");
        Opcion opcion2 = new OpcionComun("Fuerza De Lorenz");
        Opcion opcion3 = new OpcionComun("Diferenciacion");
        Opcion opcion4 = new OpcionComun("Cuerpo Rigido");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        Eleccion eleccionJugador = new Eleccion(solucion);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);


        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 2);
    }

    @Test
    public void test05MultipleChoicePuntajeParcialRecibeUnaEleccionParcialmenteAcertadaDevuelveUnPuntajeDeValorUno() {

        //Enunciado: Tema de Fisica II

        Opcion opcion1 = new OpcionComun("Induccion magnetica");
        Opcion opcion2 = new OpcionComun("Fuerza De Lorenz");
        Opcion opcion3 = new OpcionComun("Diferenciacion");
        Opcion opcion4 = new OpcionComun("Cuerpo Rigido");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> solucionJugador = new ArrayList<Opcion>();
        solucionJugador.add(opcion1);


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }
    @Test
    public void test06MultipleChoicePuntajeParcialRecibeUnaEleccionParcialmenteDesacertadaDevuelveUnPuntajeDeValorCero() {

        //Enunciado: Tema de Fisica II

        Opcion opcion1 = new OpcionComun("Induccion magnetica");
        Opcion opcion2 = new OpcionComun("Fuerza De Lorenz");
        Opcion opcion3 = new OpcionComun("Diferenciacion");
        Opcion opcion4 = new OpcionComun("Cuerpo Rigido");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> solucionJugador = new ArrayList<Opcion>();
        solucionJugador.add(opcion3);
        solucionJugador.add(opcion2);


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
    @Test
    public void test07MultipleChoicePuntajeParcialRecibeUnaEleccionDesacertadaYDevuelveUnPuntajeDeValorCero() {

        //Enunciado: Tema de Fisica II

        Opcion opcion1 = new OpcionComun("Induccion magnetica");
        Opcion opcion2 = new OpcionComun("Fuerza De Lorenz");
        Opcion opcion3 = new OpcionComun("Diferenciacion");
        Opcion opcion4 = new OpcionComun("Cuerpo Rigido");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> solucionJugador = new ArrayList<Opcion>();
        solucionJugador.add(opcion3);
        solucionJugador.add(opcion4);


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);

    }

    @Test
    public void test08MultipleChoicePuntajeParcialRecibeUnaEleccionConMasOpcionesQueLasCorrectasDevuelvePuntajeCero(){

        //Enunciado: Tema de Fisica II

        Opcion opcion1 = new OpcionComun("Induccion magnetica");
        Opcion opcion2 = new OpcionComun("Fuerza De Lorenz");
        Opcion opcion3 = new OpcionComun("Diferenciacion");
        Opcion opcion4 = new OpcionComun("Cuerpo Rigido");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> solucionJugador = new ArrayList<Opcion>();
        solucionJugador.add(opcion3);
        solucionJugador.add(opcion4);
        solucionJugador.add(opcion1);
        solucionJugador.add(opcion2);


        Eleccion eleccionJugador = new Eleccion(solucionJugador);

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Puntaje puntaje = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }
    @Test
    public void test09MultipleChoicePuntajeParcialRecibeUnaListaConTresOpcionesYDevuelveQueEsasOpcionesSonValidasComoSolucion(){

        Opcion opcion1 = new OpcionComun("Mike Wazowski");
        Opcion opcion2 = new OpcionComun("James P. Sullivan");
        Opcion opcion3 = new OpcionComun("Randall Boggs");

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(opciones);
        assert(multipleChoicePuntajeParcial.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test10MultipleChoicePuntajeParcialecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

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


        Evaluador multipleChoiceConPuntajeParcial = new MultipleChoicePuntajeParcial(opcionesValidas);

        List<Opcion> opcionesInvalidas = new ArrayList<Opcion>();
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


        Evaluador multipleChoiceConPuntajeParcial = new MultipleChoicePuntajeParcial(opcionesValidas);

        List<Opcion> opcionesInvalidas = new ArrayList<Opcion>();
        assertFalse(multipleChoiceConPuntajeParcial.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }

    @Test
    public void test12MultipleChoiceConPuntajeParcialPuedeInstanciarseConUnaListaDeOpcionesCorrectas(){

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


        TipoDePregunta multipleChoiceConPuntajeParcial = new MultipleChoicePuntajeParcial(solucion);

        Eleccion eleccionJugador = new Eleccion(solucion);
        Puntaje puntaje = multipleChoiceConPuntajeParcial.evaluarEleccion(eleccionJugador);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 3);
    }
}
