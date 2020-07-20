package edu.fiuba.algo3.modelo;

import java.util.*;

public class Jugador {

    private String nombre;
    private List<Double> puntosPorRespuesta;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntosPorRespuesta = new ArrayList<Double>();
    }

    public void responderBien(){
        puntosPorRespuesta.add(1.0);
    }

    public void responderMal(){
        puntosPorRespuesta.add(0.0);
    }

    public void responderParcial(){
        puntosPorRespuesta.add(0.5);
    }

    public Double puntosTotales(){

        Double puntosTotales = 0.0;
        Iterator<Double> iterador = puntosPorRespuesta.iterator();
        while(iterador.hasNext()){
            puntosTotales += iterador.next();
        }
        return puntosTotales;
    }


}
