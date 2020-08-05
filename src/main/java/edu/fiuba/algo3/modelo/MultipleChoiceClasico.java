package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends TipoDePregunta{
    public MultipleChoiceClasico(List<String> opcionesCorrectas){
        Eleccion eleccion = new Eleccion(opcionesCorrectas);

        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
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
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(0);
        return puntaje;
    }
    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }

    @Override
    public void mostrar(){}
}
