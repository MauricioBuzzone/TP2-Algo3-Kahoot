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
}