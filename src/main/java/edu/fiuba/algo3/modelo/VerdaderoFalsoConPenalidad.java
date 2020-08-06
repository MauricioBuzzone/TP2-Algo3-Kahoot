package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.VistaPreguntaClasica;

import java.util.List;

public class VerdaderoFalsoConPenalidad extends TipoDePregunta{

    private static final int PUNTAJE_FAVORABLE= 1;
    private static final int PUNTAJE_DESFAVORABLE = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_VALIDAS = 1;

    public VerdaderoFalsoConPenalidad(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        return this.evaluarEleccion(eleccion, PUNTAJE_FAVORABLE, PUNTAJE_DESFAVORABLE);
    }

    @Override
    public boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return (opciones.size() == CANTIDAD_DE_SOLUCIONES_VALIDAS);
    }


    @Override
    public void mostrar(String enunciado, List<String> opciones){
        VistaPreguntaClasica vista = new VistaPreguntaClasica(enunciado, opciones);
        vista.setBonificadores();
        vista.mostrar();
    }
}
