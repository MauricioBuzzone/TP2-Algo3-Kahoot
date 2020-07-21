package edu.fiuba.algo3.modelo;

import java.util.*;


public class Criterio {
    private  Opcion opcionCorrecta;

    public Criterio(Opcion opcionCorrecta){
        this.opcionCorrecta = opcionCorrecta;
    }

    public Validez validarCriterio(Opcion opcion){

        if(opcion.igualA(this.opcionCorrecta)){
            Correcta correcta = new Correcta();
            return correcta;
        }
        Incorrecta incorrecta = new Incorrecta();
        return incorrecta;
    }

}