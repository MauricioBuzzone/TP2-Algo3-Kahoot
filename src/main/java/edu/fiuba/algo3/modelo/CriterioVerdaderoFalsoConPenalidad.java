package edu.fiuba.algo3.modelo;

public class CriterioVerdaderoFalsoConPenalidad implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioVerdaderoFalsoConPenalidad(Eleccion eleccionCorrecta){
        this.eleccionCorrecta = eleccionCorrecta;
    }
    @Override
    public Validez validarCriterio(Eleccion eleccion){
        if(eleccion.igualA(this.eleccionCorrecta)){
            Validez correcta = new Correcta(1);
            return correcta;
        }
        Validez incorrecta = new Incorrecta(1);
        return incorrecta;
    }
}