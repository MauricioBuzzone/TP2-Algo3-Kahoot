package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionComun;
import edu.fiuba.algo3.modelo.ValidadorDeOpciones;
import edu.fiuba.algo3.modelo.ValidadorOpcionUnica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidadorOpcionUnicaTest {

    @Test
    public void test01UnValidadorOpcionUnicaRecibeUnaUnicaOpcionYDevuelveTrue(){

        String enunciado = "La Pampa es una provincia de Argentina";
        Opcion opcion1 = new OpcionComun("Verdadero");
        Opcion opcion2 = new OpcionComun("Falso");


        List<Opcion> opcion = new ArrayList<Opcion>();
        opcion.add(opcion1);

        ValidadorDeOpciones validador = new ValidadorOpcionUnica();

        assertTrue(validador.opcionesValidasComoSolucion(opcion));
    }

    @Test
    public void test01UnValidadorOpcionUnicaRecibeVariasOpcionYDevuelveFalse(){

        String enunciado = "La Pampa es una provincia de Argentina";
        Opcion opcion1 = new OpcionComun("Verdadero");
        Opcion opcion2 = new OpcionComun("Falso");


        List<Opcion> opcion = new ArrayList<Opcion>();
        opcion.add(opcion1);
        opcion.add(opcion2);

        ValidadorDeOpciones validador = new ValidadorOpcionUnica();

        assertFalse(validador.opcionesValidasComoSolucion(opcion));
    }


}