package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonificadorTest{

    @Test
    public void test01BonificadorX2RecibeUnPuntajeYLoMuntiplicaPorSuFactor(){

        int puntos = 10;
        Bonificador bonificador = new Bonificador();
        bonificador.cambiarFactorX2();

        assertEquals( bonificador.bonificarPuntos(puntos), 20);
    }

    @Test
    public void test02BonificadorX3RecibeUnPuntajeYLoMuntiplicaPorSuFactor(){

        int puntos = 10;
        Bonificador bonificador = new Bonificador();
        bonificador.cambiarFactorX3();

        assertEquals( bonificador.bonificarPuntos(puntos), 30);
    }
    @Test
    public void test02BonificadorDefaultRecibeUnPuntajeYLoMuntiplicaPorSuFactor(){

        int puntos = 10;
        Bonificador bonificador = new Bonificador();

        assertEquals( bonificador.bonificarPuntos(puntos), 10);
    }
}