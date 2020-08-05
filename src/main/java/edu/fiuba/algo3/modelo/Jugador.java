package edu.fiuba.algo3.modelo;

import java.util.*;

public class Jugador {

    private String nombre;
    private List<Integer> puntosPorRespuesta;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntosPorRespuesta = new ArrayList<Integer>();
    }

    public void responder(Puntaje puntaje){
        puntosPorRespuesta.add(puntaje.calcularPuntaje());
    }
    public void responderBien(int puntos){
        puntosPorRespuesta.add(puntos);
    }

    public void responderMal(int puntos){
        puntosPorRespuesta.add(-puntos);
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
}
