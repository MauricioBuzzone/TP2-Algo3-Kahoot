package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Integer> puntosPorRespuesta;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntosPorRespuesta = new ArrayList<Integer>();
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

    //TestOnly
    public void asignarPuntos(int puntos){
        puntosPorRespuesta.add(puntos);
    }
}
