package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso extends TipoDePregunta{
    public VerdaderoFalso(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    public VerdaderoFalso(Eleccion eleccion){
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion otraEleccion){

        if(otraEleccion.igualA(this.eleccionCorrecta)){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(1);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(0);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return (opciones.size() == 1);
    }

    @Override
    public void mostrar(){}
}
