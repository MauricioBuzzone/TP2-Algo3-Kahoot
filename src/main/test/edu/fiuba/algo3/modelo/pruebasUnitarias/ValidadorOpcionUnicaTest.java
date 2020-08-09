package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;



public class ValidadorOpcionUnicaTest {

    @Test
    public void test01UnValidadorOpcionUnicaRecibeUnaUnicaOpcionYDevuelveTrue(){

        String enunciado = "La Pampa es una provincia de Argentina";
        String opcion1 = "Verdadero";
        String opcion2 = "Falso";


        List<String> opcion = new ArrayList<String>();
        opcion.add(opcion1);

        ValidadorDeOpciones validador = new ValidadorOpcionUnica();

        assertTrue(validador.opcionesValidasComoSolucion(opcion));
    }

    @Test
    public void test01UnValidadorOpcionUnicaRecibeVariasOpcionYDevuelveFalse(){

        String enunciado = "La Pampa es una provincia de Argentina";
        String opcion1 = "Verdadero";
        String opcion2 = "Falso";


        List<String> opcion = new ArrayList<String>();
        opcion.add(opcion1);
        opcion.add(opcion2);

        ValidadorDeOpciones validador = new ValidadorOpcionUnica();

        assertFalse(validador.opcionesValidasComoSolucion(opcion));
    }


}