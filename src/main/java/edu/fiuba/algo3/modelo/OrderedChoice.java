package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends TipoDePregunta{

    private static final int PUNTAJE_FAVORABLE= 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public OrderedChoice(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){

        if(eleccion.estaEnOrden(eleccionCorrecta)){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(PUNTAJE_FAVORABLE);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(PUNTAJE_DESFAVORABLE);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() > CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS && opciones.size() <=   CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);
    }

    public void mostrar(){}
}