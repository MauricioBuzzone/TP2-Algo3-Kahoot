package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoicePuntajeParcial2 extends TipoDePregunta{
    public MultipleChoicePuntajeParcial2(Eleccion eleccion){
        if(!eleccion.esValida(this)){
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
    public Boolean sonOpcionesValidas(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }

}
