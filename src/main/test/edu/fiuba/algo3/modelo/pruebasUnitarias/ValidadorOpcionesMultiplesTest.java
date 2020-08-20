package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;
import edu.fiuba.algo3.modelo.validadores.ValidadorDeOpciones;
import edu.fiuba.algo3.modelo.validadores.ValidadorOpcionesMultiples;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidadorOpcionesMultiplesTest {

    @Test
    public void test01UnValidadorOpcionesMultiplesRecibeUnasCantidadDeOpcionesValidaYDevuelveTrue(){
        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Pocahontas");
        Opcion opcion3 = new OpcionComun("Blancanieves");
        Opcion opcion4 = new OpcionComun("Elsa");
        Opcion opcion5 = new OpcionComun("Mérida");
        Opcion opcion6 = new OpcionComun("Moana");

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ValidadorDeOpciones validador = new ValidadorOpcionesMultiples(1,5);

        assertTrue(validador.opcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test02UnValidadorOpcionesMultiplesRecibeUnasCantidadDeOpcionesInvalidaYDevuelveFalse(){
        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Pocahontas");
        Opcion opcion3 = new OpcionComun("Blancanieves");
        Opcion opcion4 = new OpcionComun("Elsa");
        Opcion opcion5 = new OpcionComun("Mérida");
        Opcion opcion6 = new OpcionComun("Moana");

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);
        opciones.add(opcion6);

        ValidadorDeOpciones validador = new ValidadorOpcionesMultiples(1,5);

        assertFalse(validador.opcionesValidasComoSolucion(opciones));
    }
}