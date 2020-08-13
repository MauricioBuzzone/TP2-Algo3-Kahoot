package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MultipleChoiceClasicoTest {
    @Test
    public void test01ResponderPreguntaConDosRespuestasAplicaResponderConEvaluadorACadaRespuestaEnviada() {

        String enunciado = "¿Quien creo el patron Poxi?";

        Opcion opcion1 = new OpcionComun("Diego");
        Opcion opcion2 = new OpcionComun("Tomas");
        Opcion opcion3 = new OpcionComun("Pablo");
        Opcion opcion4 = new OpcionComun("Pablo");
        Opcion opcion5 = new OpcionComun("Eugenio");

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion3);
        correctas.add(opcion4);


        MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(correctas);

        Respuesta mockRespuesta = mock(Respuesta.class);

        multipleChoice.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));
    }

    @Test
    public void test02UnMultipleChoiceClasicolLanzaUnaExcepcionCuandoSeIntentaInicializarConMasDe5pcionesCorrectas(){

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
                    MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(correctas);
                });
    }

    @Test
    public void test03UnMultipleChoiceClasicoLanzaUnaExcepcionCuandoSeIntentaInicializarConCeroOcionesCorrectas(){

        String enunciado = "P = NP";

        Opcion opcion1 = new OpcionComun("Si");
        Opcion opcion2 = new OpcionComun("Claramente no");
        Opcion opcion3 = new OpcionComun("Un poquito");
        Opcion opcion4 = new OpcionComun("Pablo = NicoPaez (?");
        Opcion opcion5 = new OpcionComun(":SonLoMismo:");

        List<Opcion> correctas = new ArrayList<Opcion>();


        assertThrows(SolucionInvalidaException.class,
                ()->{
                    MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(correctas);
                });
    }

    @Test
    public void test04MultipleChoiceClasicoRecibeUnaEleccionAcertadaYDevuelvePuntajeDeValorUno() {


        String enunciado = "¿Cuales son los Pilares de POO?";
        Opcion opcion1 = new OpcionComun("Polimorfismo");
        Opcion opcion2 = new OpcionComun("Bajo acoplamiento");
        Opcion opcion3 = new OpcionComun("Alta cohesion");
        Opcion opcion4 = new OpcionComun("Herencia");
        Opcion opcion5 = new OpcionComun("Abstraccion");

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion1);
        correctas.add(opcion4);
        correctas.add(opcion5);

        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(correctas);

        Eleccion eleccion = mock(Eleccion.class);

        when(eleccion.igualA(any(Eleccion.class))).thenReturn(true);

        Puntaje puntaje = multipleChoiceClasico.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 1);
    }

    @Test
    public void test05MultipleChoiceClasicoRecibeUnaEleccionDesacertadaYDevuelvaPuntajeDeValorCero(){

        Opcion opcion = new OpcionComun(" 2+2 = 4 ");
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion);
        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(opciones);

        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(any(Eleccion.class))).thenReturn(false);

        Puntaje puntaje = multipleChoiceClasico.evaluarEleccion(eleccion);

        Bonificador bonificador = new Bonificador();

        assertEquals(puntaje.aplicarBonificador(bonificador), 0);
    }

    @Test
    public void test06MultipleChoiceClasicoRecibeUnaListaConTresOpcionesYDevuelveQueEsasOpcionesSonValidasComoSolucion(){

        Opcion opcion1 = new OpcionComun("Mike Wazowski");
        Opcion opcion2 = new OpcionComun("James P. Sullivan");
        Opcion opcion3 = new OpcionComun("Randall Boggs");

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(opciones);
        assert(multipleChoiceClasico.sonOpcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test07MultipleChoiceClasicoecibeUnaListaConSeisOpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

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

        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(opcionesValidas);
        List<Opcion> opcionesInvalidas = new ArrayList<Opcion>();
        opcionesInvalidas.add(opcion1);
        opcionesInvalidas.add(opcion2);
        opcionesInvalidas.add(opcion3);
        opcionesInvalidas.add(opcion4);
        opcionesInvalidas.add(opcion5);
        opcionesInvalidas.add(opcion6);

        assertFalse(multipleChoiceClasico.sonOpcionesValidasComoSolucion(opcionesInvalidas));
    }
    @Test
    public void test08multipleChoiceClasicoRecibeUnaListaCon0OpcionesYDevuelveQueEsasOpcionesNoSonValidasComoSolucion(){

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Pocahontas");
        List<Opcion> opcionesValidas = new ArrayList<Opcion>();
        opcionesValidas.add(opcion1);
        opcionesValidas.add(opcion2);
        Evaluador multipleChoiceClasico = new MultipleChoiceClasico(opcionesValidas);

        List<Opcion> opciones = new ArrayList<Opcion>();
        assertFalse(multipleChoiceClasico.sonOpcionesValidasComoSolucion(opciones));
    }
    @Test
    public void test09multipleChoiceClasicoPuedeInstanciarseConUnaListaDeOpcionesCorrectas() {

        String enunciado = "¿Quien creo el patron Poxi?";

        Opcion opcion1 = new OpcionComun("Diego");
        Opcion opcion2 = new OpcionComun("Tomas");
        Opcion opcion3 = new OpcionComun("Pablo S");
        Opcion opcion4 = new OpcionComun("Pablo M");
        Opcion opcion5 = new OpcionComun("Eugenio");

        List<Opcion> correctas = new ArrayList<Opcion>();
        correctas.add(opcion3);
        correctas.add(opcion4);


        MultipleChoiceClasico multipleChoice = new MultipleChoiceClasico(correctas);

        Respuesta mockRespuesta = mock(Respuesta.class);

        multipleChoice.responderPregunta(mockRespuesta);

        verify(mockRespuesta, times(1)).responderSegunEvaluador(any(Evaluador.class));

    }

}
