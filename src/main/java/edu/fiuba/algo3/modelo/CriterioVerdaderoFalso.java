package edu.fiuba.algo3.modelo;

public class CriterioVerdaderoFalso {
    private  Opcion opcionCorrecta;

    public CriterioVerdaderoFalso(Opcion opcionCorrecta){
        this.opcionCorrecta = opcionCorrecta;
    }

    public Validez validarCriterio(Opcion opcion){

        if(opcion.igualA(this.opcionCorrecta)){
            Correcta correcta = new Correcta(1);
            return correcta;
        }
        Incorrecta incorrecta = new Incorrecta(0);
        return incorrecta;
    }

}
