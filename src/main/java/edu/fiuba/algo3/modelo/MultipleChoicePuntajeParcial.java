package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial extends TipoDePregunta{

    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public MultipleChoicePuntajeParcial(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
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
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(PUNTAJE_DESFAVORABLE);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS && opciones.size() <= CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);
    }


    public void mostrar(){}
}
