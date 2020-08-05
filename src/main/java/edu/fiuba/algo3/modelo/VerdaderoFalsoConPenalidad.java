package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoConPenalidad extends TipoDePregunta{

    public VerdaderoFalsoConPenalidad(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        if(eleccion.igualA(this.eleccionCorrecta)){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(1);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(1);
        return puntaje;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return (opciones.size() == 1);
    }


    @Override
    public void mostrar(){}
}
