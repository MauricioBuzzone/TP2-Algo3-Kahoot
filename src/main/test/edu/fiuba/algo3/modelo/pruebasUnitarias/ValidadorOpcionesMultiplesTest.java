package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;


public class ValidadorOpcionesMultiplesTest {

    @Test
    public void test01UnValidadorOpcionesMultiplesRecibeUnasCantidadDeOpcionesValidaYDevuelveTrue(){
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

        ValidadorDeOpciones validador = new ValidadorOpcionesMultiples(1,5);

        assertTrue(validador.opcionesValidasComoSolucion(opciones));
    }

    @Test
    public void test02UnValidadorOpcionesMultiplesRecibeUnasCantidadDeOpcionesInvalidaYDevuelveFalse(){
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

        ValidadorDeOpciones validador = new ValidadorOpcionesMultiples(1,5);

        assertFalse(validador.opcionesValidasComoSolucion(opciones));
    }
}