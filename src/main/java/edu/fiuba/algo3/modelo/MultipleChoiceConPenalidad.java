package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceConPenalidad extends TipoDePregunta{

    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

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
        return(opciones.size() >= CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS && opciones.size() <= CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);
    }

    @Override
    public void mostrar(){}
}
