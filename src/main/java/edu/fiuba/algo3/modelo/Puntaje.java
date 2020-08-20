package edu.fiuba.algo3.modelo;
public class Puntaje {

    private int puntos;

    private Puntaje(int unosPuntos){
        puntos=unosPuntos;
    }

    public static Puntaje crearPuntajeFavorable(int unosPuntos){
        return new Puntaje(unosPuntos);
    }

    public static Puntaje crearPuntajeDesfavorable(int unosPuntos){
        return new Puntaje(unosPuntos*(-1));
    }

    public int aplicarBonificador(Bonificador bonificador){
        return bonificador.bonificarPuntos(this.puntos);
    }
}