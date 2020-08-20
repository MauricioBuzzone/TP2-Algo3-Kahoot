package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jugador {

    private static final int USOS_DE_EXCLUSIVIDAD_MAXIMA = 2;
    private static final int USOS_DE_BONIFICADORES_MAXIMA = 1;
    private static final int PUNTAJE_POR_DEFECTO = 0;

    private List<Integer> puntosPorRespuesta = new ArrayList<Integer>();
    private int ultimoPuntaje = PUNTAJE_POR_DEFECTO;
    private int usosDeExclusividad = USOS_DE_EXCLUSIVIDAD_MAXIMA;
    private int usosDeX2 = USOS_DE_BONIFICADORES_MAXIMA;
    private int usosDeX3 = USOS_DE_BONIFICADORES_MAXIMA;

    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public int getUltimoPuntaje(){
        return ultimoPuntaje;
    }

    public int getPuntos(){
        return this.puntosTotales();
    }

    public void responder(Puntaje puntaje, Bonificador bonificador){
        ultimoPuntaje = puntaje.aplicarBonificador(bonificador);
        puntosPorRespuesta.add(ultimoPuntaje);
    }

    public int puntosTotales(){

        int puntosTotales = 0;

        for(Integer puntos : puntosPorRespuesta){
            puntosTotales = puntosTotales + puntos;
        }

        if(puntosTotales < 0) {
            return PUNTAJE_POR_DEFECTO;
        }
        return puntosTotales;
    }

    public void activarExclusividad() {
        usosDeExclusividad--;
    }

    public void activarx2() {
        usosDeX2--;
    }
    public void activarx3() {
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

    public boolean tieneMasPuntosQue(Jugador otroJugador){
        return otroJugador.tieneMenosOLosMismosPuntosQue(this.puntosTotales());
    }

    private boolean tieneMenosOLosMismosPuntosQue(int otrosPuntos){
        return (this.puntosTotales() <= otrosPuntos);
    }

    public boolean mismosPuntosQue(Jugador otroJugador){
        return otroJugador.mismosPuntos(this.puntosTotales());
    }

    private boolean mismosPuntos(int otroPuntaje){
        return (this.puntosTotales() == otroPuntaje);
    }

    public boolean mismoNombreQue(Jugador otroJugador){
        return otroJugador.mismosNombre(this.nombre);
    }

    private boolean mismosNombre(String unNombre){
        return this.nombre.equals(unNombre);
    }

    //TestOnly
    public void asignarPuntos(int puntos){
        puntosPorRespuesta.add(puntos);
    }
}
