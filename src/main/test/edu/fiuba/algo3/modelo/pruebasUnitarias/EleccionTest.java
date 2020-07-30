package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EleccionTest {

    @Test
    public void test01UnaEleccionDevuelveSerIgualASiMisma() {

        String texto = new String("El cabildo de Buenos Aires");
        List<String> jugada = new ArrayList<String>();
        jugada.add(texto);
        Eleccion eleccion = new Eleccion(jugada);
        assert(eleccion.igualA(eleccion));
    }
    @Test
    public void test02DosEleccionesDelMismoTextoSonIguales(){

        String texto = new String("El cabildo de Buenos Aires");

        List<String> jugadaUno = new ArrayList<String>();
        jugadaUno.add(texto);
        Eleccion eleccion = new Eleccion(jugadaUno);

        List<String> jugadaDos = new ArrayList<String>();
        jugadaDos.add(texto);
        Eleccion otraEleccion = new Eleccion(jugadaDos);

        assert(eleccion.igualA(otraEleccion));
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
    public void test04UnaEleccionDeMasDeUnaOpcionEsIgualASiMisma(){
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
        assert(eleccion.igualA(eleccion));
    }

    @Test
    public void test05UnaEleccionDeMasDeUnaOpcionYOtraEleccionConLasMismasOpcionesSonIguales(){
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
        assert(eleccion1.igualA(eleccion2));
    }

    @Test
    public void test06UnaEleccionDeMasDeUnaOpcionYOtraEleccionConLasMismasOpcionesDesordenadasSonIguales(){
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
        assert(eleccion1.igualA(eleccion2));
    }

    @Test
    public void test07UnaEleccionDeMasDeUnaOpcionYOtraEleccionConDistintasOpcionesNoSonIguales(){
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
    public void test08EleccionRecibeOtraEleccionYDevuelveLaCantidadDeCoincidencias(){
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

        assertEquals (eleccion1.cantidadCoincidencias(eleccion2), 1);

    }
    @Test
    public void test09EleccionRecibeOtraEleccionSinCoincidenciasYDevuelveCero(){
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

        assertEquals (eleccion1.cantidadCoincidencias(eleccion2), 0);
    }
    @Test
    public void test10EleccionRecibeOtraEleccionConTresCoincidenciasYDevuelveTresCoincidencias(){
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

        assertEquals (eleccion1.cantidadCoincidencias(eleccion2), 3);
    }
    @Test
    public void test11EleccionRecibeOtraEleccionConLasMismasOpcionesYDevuelveLaCantidadDeOpciones(){
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

        assertEquals (eleccion1.cantidadCoincidencias(eleccion2), 3);
    }
    @Test
    public void test12EleccionRecibeOtraEleccionQueEstaContenidaYDevuelveQueEstaContenida(){
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
    public void test13EleccionRecibeOtraEleccionQueNoEstaContenidaYDevuelveQueNoEstaContenida(){
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

        assertFalse (eleccion1.contieneA(eleccion2));
    }
    @Test
    public void test14EleccionRecibeOtraEleccionQueEsIgualYDevuelveQueEstaContenido(){
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
    public void test15EleccionRecibeOtraEleccionQueEsMayorYDevuelveQueNoEstaContenido(){
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

        assertFalse (eleccion1.contieneA(eleccion2));
    }
}