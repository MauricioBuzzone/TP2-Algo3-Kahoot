package edu.fiuba.algo3.modelo;

import java.security.spec.ECField;
import java.util.List;

public class VerdaderoFalso extends TipoDePregunta{
    public VerdaderoFalso(Eleccion eleccion){
        if(!eleccion.esValida(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Certificado evaluarEleccion(Eleccion otraEleccion){
        if(otraEleccion.cantidadDeOpciones() > 1){
            throw new EleccionInvalidaException();
        }

        if(otraEleccion.igualA(this.eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(0);
        return incorrecta;
    }

    public Boolean sonOpcionesValidas(List<String> opciones){
        return (opciones.size() == 1);
    }
}
