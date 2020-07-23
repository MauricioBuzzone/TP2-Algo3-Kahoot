package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionTest {
    @Test
    public void test01UnaOpcionDevuelveSerIgualASiMisma() {
        String texto = new String("El cabildo de Buenos Aires");
        Opcion opcion = new Opcion(texto);
        assert(opcion.igualA(opcion));
    }
    @Test
    public void test02DosOpcionesDelMismoTextoSonIguales(){
        String texto = new String("El cabildo de Buenos Aires");
        Opcion opcion = new Opcion(texto);
        Opcion otraOpcion = new Opcion(texto);
        assert(opcion.igualA(otraOpcion));
    }
    @Test
    public void test03DosOpcionesConDistintoTextoNoSonIguales() {
        String texto = new String("El cabildo de Buenos Aires");
        String otroTexto = new String("La Casa Rosada");
        Opcion opcion = new Opcion(texto);
        Opcion otraOpcion = new Opcion(otroTexto);
        assert (opcion.igualA(otraOpcion) == false);
    }
}