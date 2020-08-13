package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Evaluador {

    public Puntaje evaluarEleccion(Eleccion eleccion);


    public boolean sonOpcionesValidasComoSolucion(List<Opcion> opciones);
  
    public boolean esCorrecta(Eleccion eleccion);

}