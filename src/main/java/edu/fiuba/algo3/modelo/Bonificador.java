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

    public void cambiarFactorX4(){
        this.factor=4;
    }

    public void anular(){
        this.factor = 0;
    }

    public int bonificarPuntos(int puntos){
        return puntos * factor;
    }

    public int getFactor() {return factor;}
}