package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Evaluador {
    public Puntaje evaluarEleccion(Eleccion eleccion);
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones);
    public boolean sonOpcionesCorrectas(List<String> unasOpciones);
}
