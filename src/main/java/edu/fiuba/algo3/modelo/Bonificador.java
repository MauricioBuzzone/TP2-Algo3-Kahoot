package edu.fiuba.algo3.modelo;

public class Bonificador {

    private int factor;

    public Bonificador(){
        this.factor=1;
    }

    public void cambiarFactorX2(){
       this.factor=2;
    }

    public void cambiarFactorX3(){
        this.factor=3;
    }

    public void cambiarFactor(int factor){ this.factor=factor; }

    public int bonificarPuntos(int puntos){
        return puntos * factor;
    }
}