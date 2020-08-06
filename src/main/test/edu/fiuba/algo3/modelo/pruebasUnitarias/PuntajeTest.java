package edu.fiuba.algo3.modelo.pruebasUnitarias;
import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PuntajeTest{

    @Test
    public void test01PuntajeSeCreaConAciertoYSeCalculaCorrectamente(){
        int unosPuntos=15;
        Puntaje puntaje= Puntaje.crearPuntajeFavorable(unosPuntos);
        Bonificador bonificador = new Bonificador();
        assertEquals(puntaje.aplicarBonificador(bonificador), 15);
    }
    @Test
    public void test02PuntajeSeCreaConDesaciertoYSecalculaCorrectamente(){
        int unosPuntos=15;
        Puntaje puntaje= Puntaje.crearPuntajeDesfavorable(unosPuntos);
        Bonificador bonificador = new Bonificador();
        assertEquals(puntaje.aplicarBonificador(bonificador), -15);
    }
    @Test
    public void test03PuntajeRecibeUnBonificadorX2YDevuelveLosPuntosASumar(){
        int unosPuntos=15;
        Puntaje puntaje= Puntaje.crearPuntajeFavorable(unosPuntos);

        Bonificador mockBonificador = mock(Bonificador.class);
        when(mockBonificador.bonificarPuntos(any(Integer.class))).thenReturn(30);

        assertEquals(puntaje.aplicarBonificador(mockBonificador), 30);

    }
}