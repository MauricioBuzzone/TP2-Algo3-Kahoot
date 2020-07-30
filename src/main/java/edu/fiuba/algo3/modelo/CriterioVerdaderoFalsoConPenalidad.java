package edu.fiuba.algo3.modelo;

public class CriterioVerdaderoFalsoConPenalidad implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioVerdaderoFalsoConPenalidad(Eleccion eleccionCorrecta){
        this.eleccionCorrecta = eleccionCorrecta;
    }
    @Override
    public Certificado validarCriterio(Eleccion eleccion){
        if(eleccion.igualA(this.eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(1);
        return incorrecta;
    }
}