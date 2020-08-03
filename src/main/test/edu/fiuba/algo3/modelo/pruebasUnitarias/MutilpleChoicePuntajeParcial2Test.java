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

public class MutilpleChoicePuntajeParcial2Test {
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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        MultipleChoicePuntajeParcial2 multipleChoicePuntajeParcial=new MultipleChoicePuntajeParcial2(eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);

        multipleChoicePuntajeParcial.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderConEvaluador(any(Evaluador.class));

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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoicePuntajeParcial2 multipleChoice = new MultipleChoicePuntajeParcial2(eleccionCorrecta);
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

        Eleccion eleccionCorrecta = new Eleccion(correctas);

        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoicePuntajeParcial2 multipleChoice = new MultipleChoicePuntajeParcial2(eleccionCorrecta);
                });
    }
    @Test
    public void test04MultipleChoicePuntajeParcialRecibeUnaEleccionBienContestadaDevuelveUnCertifiadoCorrecto() {

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

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccionCorrecta);


        Certificado certificado = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(2);
    }

    @Test
    public void test05MultipleChoicePuntajeParcialRecibeUnaEleccionParcialmenteCorrectaDevuelveValidezCorrecta() {

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

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccionCorrecta);

        Certificado certificado = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }
    @Test
    public void test06MultipleChoicePuntajeParcialRecibeUnaEleccionParcialmenteIncorrectaDevuelveValidezIncorrecta() {

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

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccionCorrecta);

        Certificado certificado = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
    @Test
    public void test07MultipleChoicePuntajeParcialRecibeUnaEleccionIncorrectaDevuelveUnCertificadoIncorrecto() {

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

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccionCorrecta);

        Certificado certificado = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }

    @Test
    public void test08MultipleChoicePuntajeParcialRecibeUnaEleccionConMasOpcionesDevuelveUnCertificadoIncorrecto(){

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

        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccionCorrecta);

        Certificado certificado = multipleChoicePuntajeParcial.evaluarEleccion(eleccionJugador);

        Jugador mockedJugador = mock(Jugador.class);

        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
    @Test
    public void test09MultipleChoicePuntajeParcialRecibeUnaListaConTresOpcionesYDevuelveQueEsasOpcionesSonValidas(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccion);
        String opcion1 = "Mike Wazowski";
        String opcion2 = "James P. Sullivan";
        String opcion3 = "Randall Boggs";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        assert(multipleChoicePuntajeParcial.sonOpcionesValidas(opciones));
    }

    @Test
    public void test10MultipleChoicePuntajeParcialecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidas(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccion);
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
        assertFalse(multipleChoicePuntajeParcial.sonOpcionesValidas(opciones));
    }

    @Test
    public void test11MultipleChoicePuntajeParcialRecibeUnaListaCon0OpcionesYDevuelveQueEsasOpcionesNoSonValidas(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esValida(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial2(eleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(multipleChoicePuntajeParcial.sonOpcionesValidas(opciones));
    }
}
