package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceConPenalidad extends TipoDePregunta{
    public MultipleChoiceConPenalidad(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        int cantidadCorrectas = eleccionCorrecta.cantidadCoincidencias(eleccion);
        int cantidadIncorrectas = eleccionCorrecta.cantidadDeNoCoincidentes(eleccion);
        if(cantidadCorrectas > cantidadIncorrectas){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(cantidadCorrectas - cantidadIncorrectas);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(cantidadIncorrectas - cantidadCorrectas);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }

    @Override
    public void mostrar(){}
}
