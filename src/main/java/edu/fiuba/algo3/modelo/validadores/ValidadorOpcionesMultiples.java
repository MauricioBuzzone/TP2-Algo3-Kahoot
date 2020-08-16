package edu.fiuba.algo3.modelo.validadores;

import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.List;

public class ValidadorOpcionesMultiples implements ValidadorDeOpciones {

    private int cantidadSolucionesMinima;
    private int cantidadSolucionesMaxima;

    public ValidadorOpcionesMultiples(int cantidadSolucionesMinima, int cantidadSolucionesMaxima){
        this.cantidadSolucionesMinima = cantidadSolucionesMinima;
        this.cantidadSolucionesMaxima = cantidadSolucionesMaxima;

    }
    @Override
    public boolean opcionesValidasComoSolucion(List<Opcion> opciones){
        return(opciones.size() >= cantidadSolucionesMinima && opciones.size() <= cantidadSolucionesMaxima);
    }
}