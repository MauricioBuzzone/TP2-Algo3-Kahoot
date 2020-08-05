package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeTest{
    public void test01PuntajeSeCreaConAciertoYSeCalculaCorrectamente(){
        int unosPuntos=15;
        Puntaje puntaje= Puntaje.crearPuntajeFavorable(unosPuntos);
        assertEquals(puntaje.calcularPuntaje(), 15);
    }

    public void test02PuntajeSeCreaConDesaciertoYSecalculaCorrectamente(){
        int unosPuntos=15;
        Puntaje puntaje= Puntaje.crearPuntajeDesfavorable(unosPuntos);
        assertEquals(puntaje.calcularPuntaje(), -15);
    }

}