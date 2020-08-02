package edu.fiuba.algo3.modelo;

import java.util.List;

public class CriterioMultipleChoiceParcial implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioMultipleChoiceParcial(Eleccion eleccionCorrecta){
        this.eleccionCorrecta = eleccionCorrecta;
    }
    public Certificado validarCriterio(Eleccion eleccion){

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
    public boolean sonOpcionesValidas(List<String> opciones){
        return(opciones.size() == 1);
    }
}