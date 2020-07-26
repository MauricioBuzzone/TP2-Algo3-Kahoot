package edu.fiuba.algo3.modelo;

public class CriterioVerdaderoFalso implements Criterio {
    private  Opcion opcionCorrecta;

    public CriterioVerdaderoFalso(Opcion opcionCorrecta){
        this.opcionCorrecta = opcionCorrecta;
    }

    public Validez validarCriterio(Opcion opcion){

        if(opcion.igualA(this.opcionCorrecta)){
            Validez correcta = new Correcta(1);
            return correcta;
        }
        Validez incorrecta = new Incorrecta(0);
        return incorrecta;
    }

}
