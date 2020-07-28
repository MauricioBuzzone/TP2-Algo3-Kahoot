package edu.fiuba.algo3.modelo;

public class CriterioMultipleChoiceParcial implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioMultipleChoiceParcial(Eleccion eleccionCorrecta){
        this.eleccionCorrecta = eleccionCorrecta;
    }
    public  Validez validarCriterio(Eleccion eleccion){

        if( eleccionCorrecta.contieneA(eleccion) ){
            //Totalmente correcta o Parcialmente correcta
            int cantidadCoincidencias = eleccionCorrecta.cantidadCoincidencias(eleccion);
            Validez correcta = new Correcta(cantidadCoincidencias);
            return correcta;
        }
        Validez incorrecta = new Incorrecta(0);
        return incorrecta;
    }
}