package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoConPenalidad2 extends TipoDePregunta{
    public VerdaderoFalsoConPenalidad2(Eleccion eleccion){
        if(!eleccion.esValida(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Certificado evaluarEleccion(Eleccion eleccion){
        if(eleccion.cantidadDeOpciones() > 1){
            throw new EleccionInvalidaException();
        }
        if(eleccion.igualA(this.eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(1);
        return incorrecta;
    }

    public Boolean sonOpcionesValidas(List<String> opciones){
        return (opciones.size() == 1);
    }
}
