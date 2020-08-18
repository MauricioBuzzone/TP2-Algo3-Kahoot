package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jugador {

    private static final int USOS_DE_EXCLUSIVIDAD_MAXIMA = 2;
    private static final int USOS_DE_BONIFICADORES_MAXIMA = 1;

    private String nombre;
    private List<Integer> puntosPorRespuesta;
    private int ultimoPuntaje;
    private int usosDeExclusividad;
    private int usosDeX2;
    private int usosDeX3;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntosPorRespuesta = new ArrayList<Integer>();
        this.usosDeExclusividad = USOS_DE_EXCLUSIVIDAD_MAXIMA;
        this.usosDeX2 = USOS_DE_BONIFICADORES_MAXIMA;
        this.usosDeX3 = USOS_DE_BONIFICADORES_MAXIMA;
    }

    public String getNombre(){
        return nombre;
    }

    //para la tabla
    public int getUltimoPuntaje(){
        return ultimoPuntaje;
    }
    public int getPuntos(){
        return this.puntosTotales();
    }
    //

    public void responder(Puntaje puntaje, Bonificador bonificador){
        ultimoPuntaje = puntaje.aplicarBonificador(bonificador);
        puntosPorRespuesta.add(puntaje.aplicarBonificador(bonificador));
    }

    public int puntosTotales(){

        int puntosTotales = 0;
        Iterator<Integer> iterador = puntosPorRespuesta.iterator();
        while(iterador.hasNext()){
            puntosTotales += iterador.next();
        }
        if(puntosTotales < 0)
            return 0;
        return puntosTotales;
    }

    public void activarExclusividad() {
        usosDeExclusividad--;
    }

    public  void activarx2() {
        usosDeX2--;
    }
    public  void activarx3() {
        usosDeX3--;
    }

    public boolean puedeUtilizarExclusividad() {
        return usosDeExclusividad > 0;
    }

    public boolean puedeUtilizarx2() {
        return usosDeX2 > 0;
    }
    public boolean puedeUtilizarx3() {
        return usosDeX3 > 0;
    }

    public int usosDisponiblesX2(){
        return usosDeX2;
    }
    public int usosDisponiblesX3(){
        return usosDeX3;
    }
    public int usosDisponiblesExclusividad(){
        return usosDeExclusividad;
    }

    //TestOnly
    public void asignarPuntos(int puntos){
        puntosPorRespuesta.add(puntos);
    }
}
