package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.VistaPreguntaClasica;

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
        return this.evaluarEleccion(eleccion, cantidadCorrectas - cantidadIncorrectas, cantidadIncorrectas - cantidadCorrectas);
    }

    @Override
    public boolean esUnaEleccionCorrecta(Eleccion eleccion){
        int cantidadCorrectas = eleccionCorrecta.cantidadCoincidencias(eleccion);
        int cantidadIncorrectas = eleccionCorrecta.cantidadDeNoCoincidentes(eleccion);
        return(cantidadCorrectas > cantidadIncorrectas);
    }


    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS && opciones.size() <= CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);
    }

    @Override
    public void mostrar(String enunciado, List<String> opciones){
        VistaPreguntaClasica vista = new VistaPreguntaClasica(enunciado, opciones);
        vista.setBonificadores();
        vista.mostrar();
    }
}
