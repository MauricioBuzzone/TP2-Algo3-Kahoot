package edu.fiuba.algo3.modelo;

import java.util.List;

public class CriterioMultipleChoiceClasico implements Criterio {

    private Eleccion eleccionCorrecta;

    public CriterioMultipleChoiceClasico(Eleccion eleccionCorrecta){
        this.eleccionCorrecta = eleccionCorrecta;
    }

    @Override
    public Certificado validarCriterio(Eleccion eleccion){

        if(eleccion.igualA(this.eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
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
