package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial extends TipoDePregunta{

    public MultipleChoicePuntajeParcial(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    public MultipleChoicePuntajeParcial(Eleccion eleccion){

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        if( eleccionCorrecta.contieneA(eleccion) ){
            //Totalmente correcta o Parcialmente correcta
            int cantidadCoincidencias = eleccionCorrecta.cantidadCoincidencias(eleccion);
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(cantidadCoincidencias);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(0);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }

    @Override
    public void mostrar(){}
}
