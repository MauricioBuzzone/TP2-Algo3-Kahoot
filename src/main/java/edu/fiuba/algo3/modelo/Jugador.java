package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jugador {

    private static final int USOS_DE_EXCLUSIVIDAD_MAXIMA = 2;

    private String nombre;
    private List<Integer> puntosPorRespuesta;
    private int usosDeExclusividad;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntosPorRespuesta = new ArrayList<Integer>();
        this.usosDeExclusividad = USOS_DE_EXCLUSIVIDAD_MAXIMA;
    }

    public String getNombre(){
        return nombre;
    }

    public void responder(Puntaje puntaje, Bonificador bonificador){
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

    public boolean puedeUtilizarExclusividad() {
        return usosDeExclusividad > 0;
    }

    //TestOnly
    public void asignarPuntos(int puntos){
        puntosPorRespuesta.add(puntos);
    }
}
