package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends TipoDePregunta{

    public OrderedChoice(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    public OrderedChoice(Eleccion eleccion){
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){

        if(eleccion.estaEnOrden(eleccionCorrecta)){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(1);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(0);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() > 1 && opciones.size() <= 5);
    }
    @Override
    public void mostrar(){}
}