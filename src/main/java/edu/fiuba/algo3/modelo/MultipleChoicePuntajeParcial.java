package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial extends TipoDePregunta{

    public MultipleChoicePuntajeParcial(List<String> solucion){
        Eleccion eleccion = this.crearEleccion(solucion);
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
    public Certificado evaluarEleccion(Eleccion eleccion){
        if( eleccionCorrecta.contieneA(eleccion) ){
            //Totalmente correcta o Parcialmente correcta
            int cantidadCoincidencias = eleccionCorrecta.cantidadCoincidencias(eleccion);
            Certificado correcta = new Correcta(cantidadCoincidencias);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(0);
        return incorrecta;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }

    @Override
    public void mostrar(){}
}
