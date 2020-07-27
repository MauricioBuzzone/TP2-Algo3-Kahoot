package edu.fiuba.algo3.modelo;

public class CriterioVerdaderoFalso implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioVerdaderoFalso(Eleccion eleccionCorrecta){
        this.eleccionCorrecta = eleccionCorrecta;
    }

    public Validez validarCriterio(Eleccion eleccion){

        if(eleccion.igualA(this.eleccionCorrecta)){
            Validez correcta = new Correcta(1);
            return correcta;
        }
        Validez incorrecta = new Incorrecta(0);
        return incorrecta;
    }

}
