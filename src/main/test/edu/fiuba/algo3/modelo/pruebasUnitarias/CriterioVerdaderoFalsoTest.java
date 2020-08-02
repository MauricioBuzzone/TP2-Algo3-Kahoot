package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CriterioVerdaderoFalsoTest {

    @Test
    public void test01CriterioRecibeUnaOpcionCorrectaYDevuelveLaValidezCorrecta(){

        String texto = "Vamos a aprobar la entrega 0";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(true);

        (criterioVerdaderoFalso.validarCriterio(eleccion)).responder(mockedJugador);

        verify(mockedJugador, times(1)).responderBien(1);
    }

    @Test
    public void test02CriterioRecibeUnaOpcionIncorrectaYDevuelveLaValidezIncorrecta(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);

        Certificado certificado = criterioVerdaderoFalso.validarCriterio(eleccion);
        certificado.responder(mockedJugador);

        verify(mockedJugador, times(1)).responderMal(0);
    }
    @Test
    public void test03CriterioVFAlRecibirUnaEleccionConMasDeUnaOpcionYLanzaUnaExcepcion(){

        String texto = " 2+2 = 4 ";
        List<String> opcion= new ArrayList<String>();
        opcion.add(texto);
        Eleccion eleccionCorrecta = new Eleccion(opcion);
        CriterioVerdaderoFalso criterioVerdaderoFalso = new CriterioVerdaderoFalso(eleccionCorrecta);

        Jugador mockedJugador = mock(Jugador.class);
        Eleccion eleccion = mock(Eleccion.class);
        when(eleccion.cantidadDeOpciones()).thenReturn(3);
        when(eleccion.igualA(eleccionCorrecta)).thenReturn(false);


        assertThrows(EleccionInvalidaException.class,
                ()->{
                    Certificado certificado = criterioVerdaderoFalso.validarCriterio(eleccion);
                });

    }
    @Test
    public void test04UnCriterioVFRecibeUnaListaDeOpcionesConUnUnicoElementoYDevuelveQueLasOpcionesSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioVerdaderoFalso(mockedEleccion);

        String opcion = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);

        assert(criterio.sonOpcionesValidas(opciones));
    }
    @Test
    public void test05UnCriterioVFRecibeUnaListaDeOpcionesConDosElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioVerdaderoFalso(mockedEleccion);

        String opcion1 = "Para cualquier campo conservativo la circulación sobre una curva cerrada resulta en cero";
        String opcion2 = "Para cualquier grafo se cumple la relación Suma[d(v_i)] = 2|E(G)|";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(criterio.sonOpcionesValidas(opciones));
    }
    @Test
    public void test06UnCriterioVFRecibeUnaListaDeOpcionesConCeroElementosYDevuelveQueLasOpcionesNoSonValidas(){
        Eleccion mockedEleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioVerdaderoFalso(mockedEleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(criterio.sonOpcionesValidas(opciones));
    }
    @Test
    public void test06UnCriterioMCCRecibeUnaListaCon3OpcionesYDevuelveQueEsasOpcionesSonValidas(){
        Eleccion eleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioMultipleChoiceClasico(eleccion);
        String opcion1 = "Mike Wazowski";
        String opcion2 = "James P. Sullivan";
        String opcion3 = "Randall Boggs";
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        assert(criterio.sonOpcionesValidas(opciones));
    }

    @Test
    public void test07UnCriterioMCCecibeUnaListaCon6OpcionesYDevuelveQueEsasOpcionesNoSonValidas(){
        Eleccion eleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioMultipleChoiceClasico(eleccion);
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
        assertFalse(criterio.sonOpcionesValidas(opciones));
    }
    @Test
    public void test08UnCriterioMCCecibeUnaListaCon0OpcionesYDevuelveQueEsasOpcionesNoSonValidas(){
        Eleccion eleccion = mock(Eleccion.class);
        Criterio criterio = new CriterioMultipleChoiceClasico(eleccion);
        List<String> opciones = new ArrayList<String>();
        assertFalse(criterio.sonOpcionesValidas(opciones));
    }
}