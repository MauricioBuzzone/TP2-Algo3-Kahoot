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
    public Certificado evaluarEleccion(Eleccion eleccion){
        int cantidadCorrectas = eleccionCorrecta.cantidadCoincidencias(eleccion);
        int cantidadIncorrectas = eleccionCorrecta.cantidadDeNoCoincidentes(eleccion);
        if(cantidadCorrectas > cantidadIncorrectas){
            Certificado correcta = new Correcta(cantidadCorrectas - cantidadIncorrectas);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(cantidadIncorrectas - cantidadCorrectas);
        return incorrecta;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }

    @Override
    public void mostrar(){}
}
