package edu.fiuba.algo3.modelo;
public class Puntaje{

    private int puntos;

    private Puntaje(int unosPuntos){
        puntos=unosPuntos;
    }

    public static Puntaje crearPuntajeFavorable(int unosPuntos){
        Puntaje puntaje=new Puntaje(unosPuntos);
        return puntaje;
    }

    public static Puntaje crearPuntajeDesfavorable(int unosPuntos){
        Puntaje puntaje=new Puntaje(unosPuntos*(-1));
        return puntaje;
    }

    public int aplicarBonificador(Bonificador bonificador){
        return bonificador.bonificarPuntos(this.puntos);
    }
}