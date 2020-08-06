package edu.fiuba.algo3.modelo;

import java.util.List;



public class VerdaderoFalso extends TipoDePregunta{

    private static final int PUNTAJE_FAVORABLE= 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_VALIDAS = 1;


    public VerdaderoFalso(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion otraEleccion){

        if(otraEleccion.igualA(this.eleccionCorrecta)){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(PUNTAJE_FAVORABLE);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(PUNTAJE_DESFAVORABLE);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return (opciones.size() == CANTIDAD_DE_SOLUCIONES_VALIDAS);
    }


    public void mostrar(){}
}
