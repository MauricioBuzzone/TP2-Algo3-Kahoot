package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Eleccion;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.List;

public interface Evaluador {

    public Puntaje evaluarEleccion(Eleccion eleccion);

    public boolean sonOpcionesValidasComoSolucion(List<Opcion> opciones);
  
    public boolean esCorrecta(Eleccion eleccion);

}