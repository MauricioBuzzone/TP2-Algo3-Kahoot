package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico2 extends TipoDePregunta{
    public MultipleChoiceClasico2(Eleccion eleccion){
        if(!(eleccion.esValida(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Certificado evaluarEleccion(Eleccion eleccion){
        if(eleccion.igualA(this.eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(0);
        return incorrecta;
    }
    @Override
    public Boolean sonOpcionesValidas(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }
}
