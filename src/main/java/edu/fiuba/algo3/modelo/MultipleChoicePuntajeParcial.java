package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial extends TipoDePregunta{

    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public MultipleChoicePuntajeParcial(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionesMultiples(CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS,CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        int cantidadCoincidencias = eleccionCorrecta.cantidadCoincidencias(eleccion);
        return this.evaluarEleccion(eleccion, cantidadCoincidencias, PUNTAJE_DESFAVORABLE);
    }

    @Override
    protected boolean esUnaEleccionCorrecta(Eleccion eleccion){
        return(eleccionCorrecta.contieneA(eleccion));
    }

}
