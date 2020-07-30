package edu.fiuba.algo3.modelo;

public class CriterioVerdaderoFalso implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioVerdaderoFalso(Eleccion eleccionCorrecta){

        this.eleccionCorrecta = eleccionCorrecta;
    }

    public Certificado validarCriterio(Eleccion eleccion){
        if(eleccion.cantidadDeOpciones() > 1){
            throw new EleccionInvalidaException();
        }

        if(eleccion.igualA(this.eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(0);
        return incorrecta;
    }

}
