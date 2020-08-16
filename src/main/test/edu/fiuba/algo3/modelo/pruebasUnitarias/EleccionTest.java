package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;
import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EleccionTest {

    @Test
    public void test01UnaEleccionDevuelveSerIgualASiMisma() {

        String texto = "El cabildo de Buenos Aires";
        Opcion opcion = new OpcionComun(texto);
        List<Opcion> jugada = new ArrayList<Opcion>();
        jugada.add(opcion);
        Eleccion eleccion = new Eleccion(jugada);
        assert (eleccion.igualA(eleccion));
    }

    @Test
    public void test02DosEleccionesDeLaMismaOpcionSonIguales() {

        Opcion opcion = new OpcionComun("El cabildo de Buenos Aires");

        List<Opcion> jugadaUno = new ArrayList<Opcion>();
        jugadaUno.add(opcion);
        Eleccion eleccion = new Eleccion(jugadaUno);

        List<Opcion> jugadaDos = new ArrayList<Opcion>();
        jugadaDos.add(opcion);
        Eleccion otraEleccion = new Eleccion(jugadaDos);

        assert (eleccion.igualA(otraEleccion));
    }

    @Test
    public void test03DosEleccionesConDistintoOpcionNoSonIguales() {

        Opcion unaOpcion = new OpcionComun("El cabildo de Buenos Aires");

        List<Opcion> jugadaUno = new ArrayList<Opcion>();
        jugadaUno.add(unaOpcion);
        Eleccion eleccion = new Eleccion(jugadaUno);


        Opcion otroOpcion = new OpcionComun("La Casa Rosada");

        List<Opcion> jugadaDos = new ArrayList<Opcion>();
        jugadaDos.add(otroOpcion);
        Eleccion otraEleccion = new Eleccion(jugadaDos);


        assertFalse(eleccion.igualA(otraEleccion));
    }

    @Test
    public void test04UnaEleccionDeMasDeUnaOpcionEsIgualASiMisma() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");

        List<Opcion> jugada = new ArrayList<Opcion>();
        jugada.add(opcion1);
        jugada.add(opcion2);
        jugada.add(opcion3);
        jugada.add(opcion4);
        Eleccion eleccion = new Eleccion(jugada);
        assert (eleccion.igualA(eleccion));
    }


    @Test
    public void test06UnaEleccionDeMasDeUnaOpcionComunYOtraEleccionConLasMismasOpcionesComunesDesordenadasSonIguales() {

        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion2);
        jugada1.add(opcion3);
        jugada1.add(opcion4);
        jugada1.add(opcion1);

        jugada2.add(opcion1);
        jugada2.add(opcion2);
        jugada2.add(opcion3);
        jugada2.add(opcion4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);
        assert (eleccion1.igualA(eleccion2));
    }

    @Test
    public void test07UnaEleccionDeMasDeUnaOpcionYOtraEleccionConDistintasOpcionesNoSonIguales() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion5);
        jugada1.add(opcion3);
        jugada1.add(opcion2);

        jugada2.add(opcion1);
        jugada2.add(opcion2);
        jugada2.add(opcion4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);
        assertFalse(eleccion1.igualA(eleccion2));
    }

    @Test
    public void test08EleccionRecibeOtraEleccionYDevuelveLaCantidadDeCoincidencias() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion1);
        jugada1.add(opcion3);
        jugada1.add(opcion4);

        jugada2.add(opcion2);
        jugada2.add(opcion3);
        jugada2.add(opcion5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 1);

    }

    @Test
    public void test09EleccionRecibeOtraEleccionSinCoincidenciasYDevuelveCero() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion1);
        jugada1.add(opcion4);

        jugada2.add(opcion2);
        jugada2.add(opcion3);
        jugada2.add(opcion5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 0);
    }

    @Test
    public void test10EleccionRecibeOtraEleccionConTresCoincidenciasYDevuelveTresCoincidencias() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion2);
        jugada1.add(opcion3);
        jugada1.add(opcion5);

        jugada2.add(opcion2);
        jugada2.add(opcion3);
        jugada2.add(opcion5);
        jugada2.add(opcion4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 3);
    }

    @Test
    public void test11EleccionRecibeOtraEleccionConLasMismasOpcionesYDevuelveLaCantidadDeOpciones() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion2);
        jugada1.add(opcion3);
        jugada1.add(opcion5);

        jugada2.add(opcion2);
        jugada2.add(opcion3);
        jugada2.add(opcion5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertEquals(eleccion1.cantidadCoincidencias(eleccion2), 3);
    }

    @Test
    public void test12EleccionRecibeOtraEleccionQueEstaContenidaYDevuelveQueEstaContenida() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion2);
        jugada1.add(opcion3);
        jugada1.add(opcion5);

        jugada2.add(opcion3);
        jugada2.add(opcion5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assert (eleccion1.contieneA(eleccion2));
    }

    @Test
    public void test13EleccionRecibeOtraEleccionQueNoEstaContenidaYDevuelveQueNoEstaContenida() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion2);
        jugada1.add(opcion3);
        jugada1.add(opcion5);

        jugada2.add(opcion3);
        jugada2.add(opcion4);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertFalse(eleccion1.contieneA(eleccion2));
    }

    @Test
    public void test14EleccionRecibeOtraEleccionQueEsIgualYDevuelveQueEstaContenido() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion2);
        jugada1.add(opcion3);
        jugada1.add(opcion5);

        jugada2.add(opcion2);
        jugada2.add(opcion3);
        jugada2.add(opcion5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assert (eleccion1.contieneA(eleccion2));
    }

    @Test
    public void test15EleccionRecibeOtraEleccionQueEsMayorYDevuelveQueNoEstaContenido() {
        Opcion opcion1 = new OpcionComun("El cabildo de Buenos Aires");
        Opcion opcion2 = new OpcionComun("La casa rosada");
        Opcion opcion3 = new OpcionComun("El gran Rex");
        Opcion opcion4 = new OpcionComun("El obelisco");
        Opcion opcion5 = new OpcionComun("La cancha de Boca");

        List<Opcion> jugada1 = new ArrayList<Opcion>();
        List<Opcion> jugada2 = new ArrayList<Opcion>();

        jugada1.add(opcion2);

        jugada2.add(opcion2);
        jugada2.add(opcion3);
        jugada2.add(opcion5);

        Eleccion eleccion1 = new Eleccion(jugada1);
        Eleccion eleccion2 = new Eleccion(jugada2);

        assertFalse(eleccion1.contieneA(eleccion2));
    }

    @Test
    public void test16UnaEleccionDeUnaUnicaOpcionRecibeUnEvaluadorVFYDevuelveQueSusOpcionesSonValidasParaElEvaluadorVF(){

        // Creación de elementos necesarios para hacer la prueba
        Opcion opcionCorrecta = new OpcionComun("Falso");
        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcionCorrecta);

        Evaluador evaluadorVF = new VerdaderoFalso(opcionesCorrectas);

        // Creo la opción a evalúar
        Opcion opcion = new OpcionComun("Verdadero");
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion);
        Eleccion eleccion = new Eleccion(opciones);

        assert(eleccion.esUnaEleccionValidaComoSolucion(evaluadorVF));
    }

    @Test
    public void test17UnaEleccionDe6OpcionesRecibeUnEvaluadorMultipleChoiceClasicoDevuelveQueSusOpcionesNoSonValidasParaElEvaluador(){

        // Creación de elementos necesarios para hacer la prueba
        Opcion opcionCorrecta = new OpcionComun("Jaime Lannister");
        List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcionCorrecta);

        Evaluador evaluadorMCC = new MultipleChoiceClasico(opcionesCorrectas);

        // Creo la opción a evaluar
        Opcion opcion1 = new OpcionComun("Jaime Lannister");
        Opcion opcion2 = new OpcionComun("Tyrion Lannister");
        Opcion opcion3 = new OpcionComun("Cersei Lannister");
        Opcion opcion4 = new OpcionComun("Tywin Lannister");
        Opcion opcion5 = new OpcionComun("Lancel Lannister");
        Opcion opcion6 = new OpcionComun("Joffrey Lannister");

        List<Opcion> opciones = new ArrayList<Opcion>();
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

        Opcion opcion1 = new OpcionComun("Jaime Lannister");
        Opcion opcion2 = new OpcionComun("Tyrion Lannister");
        Opcion opcion3 = new OpcionComun("Cersei Lannister");
        Opcion opcion4 = new OpcionComun("Tywin Lannister");
        Opcion opcion5 = new OpcionComun("Lancel Lannister");
        Opcion opcion6 = new OpcionComun("Joffrey Lannister");

        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcion1);
        opciones2.add(opcion5);
        opciones2.add(opcion6);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion2), 2);
    }


    @Test
    public void test18UnaEleccionDeDosOpcionesYOtraOpcionDeCuatroOpcionesSePideLaCantidadDeNoCoincidenciasYDevuelveLaCantidadDeDiferenciasCorrecta(){

        Opcion opcion1 = new OpcionComun("Jaime Lannister");
        Opcion opcion2 = new OpcionComun("Tyrion Lannister");
        Opcion opcion3 = new OpcionComun("Cersei Lannister");
        Opcion opcion4 = new OpcionComun("Tywin Lannister");
        Opcion opcion5 = new OpcionComun("Lancel Lannister");
        Opcion opcion6 = new OpcionComun("Joffrey Lannister");

        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcion1);
        opciones2.add(opcion2);
        opciones2.add(opcion3);
        opciones2.add(opcion4);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion2), 2);
    }

    @Test
    public void test19UnaEleccionSePideLaCantidadDeNoCoincidenciasConOtraEleccionIgualYDevuelveCero(){

        Opcion opcion1 = new OpcionComun("Jaime Lannister");
        Opcion opcion2 = new OpcionComun("Tyrion Lannister");
        Opcion opcion3 = new OpcionComun("Cersei Lannister");
        Opcion opcion4 = new OpcionComun("Tywin Lannister");
        Opcion opcion5 = new OpcionComun("Lancel Lannister");
        Opcion opcion6 = new OpcionComun("Joffrey Lannister");

        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        Eleccion eleccion1 = new Eleccion(opciones1);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion1), 0);
    }

    @Test
    public void test20UnaEleccionSeLePideLaCantidadDeNoCoincidenciasConOtraEleccionContenidaEnEllaYDevuelveCero(){

        Opcion opcion1 = new OpcionComun("Jaime Lannister");
        Opcion opcion2 = new OpcionComun("Tyrion Lannister");
        Opcion opcion3 = new OpcionComun("Cersei Lannister");
        Opcion opcion4 = new OpcionComun("Tywin Lannister");
        Opcion opcion5 = new OpcionComun("Lancel Lannister");
        Opcion opcion6 = new OpcionComun("Joffrey Lannister");

        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcion1);
        opciones2.add(opcion2);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertEquals(eleccion1.cantidadDeNoCoincidentes(eleccion2), 0);
    }

    @Test
    public void test21AEleccionConOpcionesOrdenadasSeLePideVerficarOtraEleccionIdenticaConOpcionesOrdenadasSiEstaEnOrdenDevuelveTrue(){

        Opcion opcion1 = new OpcionOrdenada("Jaime Lannister", 1);
        Opcion opcion2 = new OpcionOrdenada("Tyrion Lannister", 2);
        Opcion opcion3 = new OpcionOrdenada("Cersei Lannister", 3);
        Opcion opcion4 = new OpcionOrdenada("Tywin Lannister", 4);


        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcion2);
        opciones2.add(opcion1);
        opciones2.add(opcion3);
        opciones2.add(opcion4);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assert(eleccion1.igualA(eleccion2));
    }

    @Test
    public void test21AEleccionConOpcionesOrdenadasSeLePideVerficarOtraEleccionConOpcionesOrdenadasDeFormaDistintaAlNoEstarEnOrdenDevuelveFalse(){

        Opcion opcion1 = new OpcionOrdenada("Jaime Lannister", 1);
        Opcion opcion2 = new OpcionOrdenada("Tyrion Lannister", 2);
        Opcion opcion3 = new OpcionOrdenada("Cersei Lannister", 3);
        Opcion opcion4 = new OpcionOrdenada("Tywin Lannister", 4);


        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        opciones1.add(opcion4);
        Eleccion eleccion1 = new Eleccion(opciones1);

        Opcion opcion5 = new OpcionOrdenada("Jaime Lannister", 3);
        Opcion opcion6 = new OpcionOrdenada("Tyrion Lannister", 2);
        Opcion opcion7 = new OpcionOrdenada("Cersei Lannister", 1);
        Opcion opcion8 = new OpcionOrdenada("Tywin Lannister",4);


        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcion5);
        opciones2.add(opcion6);
        opciones2.add(opcion7);
        opciones2.add(opcion8);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertFalse(eleccion1.igualA(eleccion2));
    }

    @Test
    public void test22DosEleccionesConOpcionesDeGrupoConLasMismasOpcionesEnLosMismosGruposSonIguales(){

        Opcion opcion1 = new OpcionDeGrupo("Alonso", "Campeones de F1");
        Opcion opcion2 = new OpcionDeGrupo("Jenson", "Campeones de F1");
        Opcion opcion3 = new OpcionDeGrupo("Marc Marques", "Campeones de MotoGP");

        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        Eleccion eleccion1 = new Eleccion(opciones1);

        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcion2);
        opciones2.add(opcion1);
        opciones2.add(opcion3);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assert(eleccion1.igualA(eleccion2));
    }

    @Test
    public void test23DosEleccionesConOpcionesDeGrupoConLasMismasOpcionesEnDistintosGruposSonIguales(){

        Opcion opcion1 = new OpcionDeGrupo("Alonso", "Campeones de F1");
        Opcion opcion2 = new OpcionDeGrupo("Jenson", "Campeones de F1");
        Opcion opcion3 = new OpcionDeGrupo("Marc Marques", "Campeones de MotoGP");

        List<Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcion1);
        opciones1.add(opcion2);
        opciones1.add(opcion3);
        Eleccion eleccion1 = new Eleccion(opciones1);

        Opcion opcion4 = new OpcionDeGrupo("Alonso", "Campeones de F1");
        Opcion opcion5 = new OpcionDeGrupo("Jenson", "Campeones de MotoGP");
        Opcion opcion6 = new OpcionDeGrupo("Marc Marques", "Campeones de F1");

        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcion4);
        opciones2.add(opcion6);
        opciones2.add(opcion5);
        Eleccion eleccion2 = new Eleccion(opciones2);

        assertFalse(eleccion1.igualA(eleccion2));
    }

}