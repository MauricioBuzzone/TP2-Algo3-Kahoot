package edu.fiuba.algo3.modelo;

public class CriterioMultipleChoiceClasico implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioMultipleChoiceClasico(Eleccion eleccionCorrecta){
        this.eleccionCorrecta = eleccionCorrecta;
    }

    @Override
    public Validez validarCriterio(Eleccion eleccion){

        if(eleccion.igualA(this.eleccionCorrecta)){
            Validez correcta = new Correcta(1);
            return correcta;
        }
        Validez incorrecta = new Incorrecta(0);
        return incorrecta;
    }

}
