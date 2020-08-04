package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EleccionTest {

    @Test
    public void test01UnaEleccionDevuelveSerIgualASiMisma() {

        String texto = new String("El cabildo de Buenos Aires");
        List<String> jugada = new ArrayList<String>();
        jugada.add(texto);
        Eleccion eleccion = new Eleccion(jugada);
        assert (eleccion.igualA(eleccion));
    }

    @Test
    public void test02DosEleccionesDelMismoTextoSonIguales() {

        String texto = new String("El cabildo de Buenos Aires");

        List<String> jugadaUno = new ArrayList<String>();
        jugadaUno.add(texto);
        Eleccion eleccion = new Eleccion(jugadaUno);

        List<String> jugadaDos = new ArrayList<String>();
        jugadaDos.add(texto);
        Eleccion otraEleccion = new Eleccion(jugadaDos);

        assert (eleccion.igualA(otraEleccion));
    }

    @Test
    public void test03DosEleccionesConDistintoTextoNoSonIguales() {

        String texto = new String("El cabildo de Buenos Aires");

        List<String> jugadaUno = new ArrayList<String>();
        jugadaUno.add(texto);
        Eleccion eleccion = new Eleccion(jugadaUno);


        String otroTexto = new String("La Casa Rosada");

        List<String> jugadaDos = new ArrayList<String>();
        jugadaDos.add(otroTexto);
        Eleccion otraEleccion = new Eleccion(jugadaDos);


        assertFalse(eleccion.igualA(otraEleccion));
    }

    @Test
    public void test04UnaEleccionDeMasDeUnaOpcionEsIgualASiMisma() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");

        List<String> jugada = new ArrayList<String>();
        jugada.add(texto1);
        jugada.add(texto2);
        jugada.add(texto3);
        jugada.add(texto4);
        Eleccion eleccion = new Eleccion(jugada);
        assert (eleccion.igualA(eleccion));
    }

    @Test
    public void test05UnaEleccionDeMasDeUnaOpcionYOtraEleccionConLasMismasOpcionesSonIguales() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto1);
        jugada1.add(texto2);
        jugada1.add(texto3);
        jugada1.add(texto4);

        jugada2.add(texto1);
        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);
        assert (eleccion1.igualA(eleccion2));
    }

    @Test
    public void test06UnaEleccionDeMasDeUnaOpcionYOtraEleccionConLasMismasOpcionesDesordenadasSonIguales() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto4);
        jugada1.add(texto3);
        jugada1.add(texto2);
        jugada1.add(texto1);

        jugada2.add(texto1);
        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);
        assert (eleccion1.igualA(eleccion2));
    }

    @Test
    public void test07UnaEleccionDeMasDeUnaOpcionYOtraEleccionConDistintasOpcionesNoSonIguales() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto5);
        jugada1.add(texto3);
        jugada1.add(texto2);

        jugada2.add(texto1);
        jugada2.add(texto2);
        jugada2.add(texto4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);
        assertFalse(eleccion1.igualA(eleccion2));
    }

    @Test
    public void test08EleccionRecibeOtraEleccionYDevuelveLaCantidadDeCoincidencias() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto1);
        jugada1.add(texto3);
        jugada1.add(texto4);

        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 1);

    }

    @Test
    public void test09EleccionRecibeOtraEleccionSinCoincidenciasYDevuelveCero() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto1);
        jugada1.add(texto4);

        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 0);
    }

    @Test
    public void test10EleccionRecibeOtraEleccionConTresCoincidenciasYDevuelveTresCoincidencias() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto2);
        jugada1.add(texto3);
        jugada1.add(texto5);

        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto5);
        jugada2.add(texto4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 3);
    }

    @Test
    public void test11EleccionRecibeOtraEleccionConLasMismasOpcionesYDevuelveLaCantidadDeOpciones() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto2);
        jugada1.add(texto3);
        jugada1.add(texto5);

        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 3);
    }

    @Test
    public void test12EleccionRecibeOtraEleccionQueEstaContenidaYDevuelveQueEstaContenida() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto2);
        jugada1.add(texto3);
        jugada1.add(texto5);

        jugada2.add(texto3);
        jugada2.add(texto5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assert (eleccion1.contieneA(eleccion2));
    }

    @Test
    public void test13EleccionRecibeOtraEleccionQueNoEstaContenidaYDevuelveQueNoEstaContenida() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto2);
        jugada1.add(texto3);
        jugada1.add(texto5);

        jugada2.add(texto3);
        jugada2.add(texto4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertFalse(eleccion1.contieneA(eleccion2));
    }

    @Test
    public void test14EleccionRecibeOtraEleccionQueEsIgualYDevuelveQueEstaContenido() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto2);
        jugada1.add(texto3);
        jugada1.add(texto5);

        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assert (eleccion1.contieneA(eleccion2));
    }

    @Test
    public void test15EleccionRecibeOtraEleccionQueEsMayorYDevuelveQueNoEstaContenido() {
        String texto1 = new String("El cabildo de Buenos Aires");
        String texto2 = new String("La casa rosada");
        String texto3 = new String("El gran Rex");
        String texto4 = new String("El obelisco");
        String texto5 = new String("La cancha de Boca");

        List<String> jugada1 = new ArrayList<String>();
        List<String> jugada2 = new ArrayList<String>();

        jugada1.add(texto2);

        jugada2.add(texto2);
        jugada2.add(texto3);
        jugada2.add(texto5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertFalse(eleccion1.contieneA(eleccion2));
    }
    @Test
    public void test16UnaEleccionDeUnaUnicaOpcionRecibeUnEvaluadorVFYDevuelveQueSusOpcionesSonValidasParaElEvaluadorVF(){

        // Creación de elementos necesarios para hacer la prueba
        String opcionCorrecta = new String("Falso");
        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add(opcionCorrecta);

        Evaluador evaluadorVF = new VerdaderoFalso(opcionesCorrectas);

        // Creo la opción a evalúar
        String opcion = new String("Verdadero");
        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion);
        Eleccion eleccion = new Eleccion(opciones);

        assert(eleccion.esUnaEleccionValidaComoSolucion(evaluadorVF));
    }

    @Test
    public void test17UnaEleccionDe6OpcionesRecibeUnEvaluadorMultipleChoiceClasicoDevuelveQueSusOpcionesNoSonValidasParaElEvaluador(){

        // Creación de elementos necesarios para hacer la prueba
        String opcionCorrecta = new String("Jaime Lannister");
        List<String> opcionesCorrectas = new ArrayList<String>();
        opcionesCorrectas.add(opcionCorrecta);
        Eleccion eleccionCorrecta = new Eleccion(opcionesCorrectas);
        Evaluador evaluadorMCC = new MultipleChoiceClasico(eleccionCorrecta);

        // Creo la opción a evaluar
        String opcion1 = new String("Jaime Lannister");
        String opcion2 = new String("Tyrion Lannister");
        String opcion3 = new String("Cersei Lannister");
        String opcion4 = new String("Tywin Lannister");
        String opcion5 = new String("Lancel Lannister");
        String opcion6 = new String("Joffrey Lannister");

        List<String> opciones = new ArrayList<String>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);
        opciones.add(opcion6);
        Eleccion eleccion = new Eleccion(opciones);

        assertFalse(eleccion.esUnaEleccionValidaComoSolucion(evaluadorMCC));
    }
    @Test
    public void test18UnaEleccionDeCuatroOpcionesYOtraOpcionDeTresOpcionesSePideLaCantidadDeNoCoincidenciasYDevuelveLaCantidadDeDiferenciasCorrecta(){

        String opcion1 = new String("Jaime Lannister");
        String opcion2 = new String("Tyrion Lannister");
        String opcion3 = new String("Cersei Lannister");
        String opcion4 = new String("Tywin Lannister");
        String opcion5 = new String("Lancel Lannister");
        String opcion6 = new String("Joffrey Lannister");

        List<String> opciones1 = new ArrayList<String>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<String> opciones2 = new ArrayList<String>();
        opciones2.add(opcion1);
        opciones2.add(opcion5);
        opciones2.add(opcion6);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion2), 2);
    }
    @Test
    public void test18UnaEleccionDeDosOpcionesYOtraOpcionDeCuatroOpcionesSePideLaCantidadDeNoCoincidenciasYDevuelveLaCantidadDeDiferenciasCorrecta(){

        String opcion1 = new String("Jaime Lannister");
        String opcion2 = new String("Tyrion Lannister");
        String opcion3 = new String("Cersei Lannister");
        String opcion4 = new String("Tywin Lannister");
        String opcion5 = new String("Lancel Lannister");
        String opcion6 = new String("Joffrey Lannister");

        List<String> opciones1 = new ArrayList<String>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<String> opciones2 = new ArrayList<String>();
        opciones2.add(opcion1);
        opciones2.add(opcion2);
        opciones2.add(opcion3);
        opciones2.add(opcion4);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion2), 2);
    }
    @Test
    public void test19UnaEleccionSePideLaCantidadDeNoCoincidenciasConOtraEleccionIgualYDevuelveCero(){

        String opcion1 = new String("Jaime Lannister");
        String opcion2 = new String("Tyrion Lannister");
        String opcion3 = new String("Cersei Lannister");
        String opcion4 = new String("Tywin Lannister");
        String opcion5 = new String("Lancel Lannister");
        String opcion6 = new String("Joffrey Lannister");

        List<String> opciones1 = new ArrayList<String>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        Eleccion eleccion1 = new Eleccion(opciones1);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion1), 0);
    }

    @Test
    public void test20UnaEleccionSeLePideLaCantidadDeNoCoincidenciasConOtraEleccionContenidaEnEllaYDevuelveCero(){

        String opcion1 = new String("Jaime Lannister");
        String opcion2 = new String("Tyrion Lannister");
        String opcion3 = new String("Cersei Lannister");
        String opcion4 = new String("Tywin Lannister");
        String opcion5 = new String("Lancel Lannister");
        String opcion6 = new String("Joffrey Lannister");

        List<String> opciones1 = new ArrayList<String>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<String> opciones2 = new ArrayList<String>();
        opciones2.add(opcion1);
        opciones2.add(opcion2);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion2), 0);
    }

    @Test
    public void test21AEleccionSeLePideVerficiarOtraEleccionIdenticaEstaEnOrdenDevuelveTrue(){

        String opcion1 = new String("Jaime Lannister");
        String opcion2 = new String("Tyrion Lannister");
        String opcion3 = new String("Cersei Lannister");
        String opcion4 = new String("Tywin Lannister");


        List<String> opciones1 = new ArrayList<String>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<String> opciones2 = new ArrayList<String>();
        opciones2.add(opcion1);
        opciones2.add(opcion2);
        opciones2.add(opcion3);
        opciones2.add(opcion4);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertTrue(eleccion1.estaEnOrden(eleccion2));
    }
    @Test
    public void test21AEleccionSeLePideVerficiarOtraEleccionDistintaEstaEnOrdenDevuelveFalse(){

        String opcion1 = new String("Jaime Lannister");
        String opcion2 = new String("Tyrion Lannister");
        String opcion3 = new String("Cersei Lannister");
        String opcion4 = new String("Tywin Lannister");


        List<String> opciones1 = new ArrayList<String>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<String> opciones2 = new ArrayList<String>();
        opciones2.add(opcion1);
        opciones2.add(opcion2);
        opciones2.add(opcion4);
        opciones2.add(opcion3);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertFalse(eleccion1.estaEnOrden(eleccion2));
    }
}