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

public class MultipleChoiceClasicoTest {
    @Test
    public void test01ResponderPreguntaConDosRespuestasAplicaResponderConEvaluadorACadaRespuestaEnviada() {

        String enunciado = "¿Quien creo el patron Poxi?";

        String opcion1 = "Diego";
        String opcion2 = "Tomas";
        String opcion3 = "Pablo";
        String opcion4 = "Pablo";
        String opcion5 = "Eugenio";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion3);
        correctas.add(opcion4);


        Eleccion eleccionCorrecta = new Eleccion(correctas);
        MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(eleccionCorrecta);

        Respuesta mockRespuesta = mock(Respuesta.class);

        multipleChoice.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void test02UnMultipleChoiceClasicolLanzaUnaExcepcionCuandoSeIntentaInicializarConMasDe5pcionesCorrectas(){

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
                    MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(eleccionCorrecta);
                });
    }

    @Test
    public void test03UnMultipleChoiceClasicoLanzaUnaExcepcionCuandoSeIntentaInicializarConCeroOcionesCorrectas(){

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
                    MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(eleccionCorrecta);
                });
    }

    @Test
    public void test04MultipleChoiceClasicoRecibeUnaEleccionAcertadaYDevuelveUnCertificadoCorrecto() {


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

        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);

        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (multipleChoiceClasico.evaluarEleccion(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test05MultipleChoiceClasicoRecibeUnaEleccionDesacertadaYDevuelvaUnCertificadoIncorrecto(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Certificado certificado = multipleChoiceClasico.evaluarEleccion(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }

    @Test
    public void test06MultipleChoiceClasicoRecibeUnaListaConTresOpcionesYDevuelveQueEsasOpcionesSonValidasComoSolucion(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(eleccion);
        String opcion1 = "Mike Wazowski";
        String opcion2 = "James P. Sullivan";
        String opcion3 = "Randall Boggs";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        assert(multipleChoiceClasico.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test07MultipleChoiceClasicoecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(eleccion);
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
        assertFalse(multipleChoiceClasico.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test08multipleChoiceClasicoRecibeUnaListaCon0OpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.esUnaEleccionValidaComoSolucion(any(Evaluador.class))).thenReturn(true);
        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(eleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(multipleChoiceClasico.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test09multipleChoiceClasicoPuedeInstanciarseConUnaListaDeOpcionesCorrectas() {

        String enunciado = "¿Quien creo el patron Poxi?";

        String opcion1 = "Diego";
        String opcion2 = "Tomas";
        String opcion3 = "Pablo S";
        String opcion4 = "Pablo M";
        String opcion5 = "Eugenio";

        List<String> correctas = new ArrayList<String>();
        correctas.add(opcion3);
        correctas.add(opcion4);


        MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(correctas);

        Respuesta mockRespuesta = mock(Respuesta.class);

        multipleChoice.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));

    }

}
