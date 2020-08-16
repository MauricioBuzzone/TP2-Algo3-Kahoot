package edu.fiuba.algo3.modelo.validadores;

import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.List;

public interface ValidadorDeOpciones{

    public boolean opcionesValidasComoSolucion(List<Opcion> opciones);

}