package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends TipoDePregunta{

    public OrderedChoice(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    public OrderedChoice(Eleccion eleccion){
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Certificado evaluarEleccion(Eleccion eleccion){

        if(eleccion.estaEnOrden(eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(0);
        return incorrecta;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() > 1 && opciones.size() <= 5);
    }
    @Override
    public void mostrar(){}
}