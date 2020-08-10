package edu.fiuba.algo3.modelo;

import java.util.List;

public class ValidadorOpcionUnica implements ValidadorDeOpciones {

    private static final int CANTIDAD_DE_SOLUCIONES_VALIDAS = 1;

    @Override
    public boolean opcionesValidasComoSolucion(List<Opcion> opciones){
        return (opciones.size() == CANTIDAD_DE_SOLUCIONES_VALIDAS);
    }
}