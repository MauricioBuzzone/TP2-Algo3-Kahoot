package edu.fiuba.algo3.modelo;

import java.util.*;

public class Eleccion {

    private List<String> opciones;

    public Eleccion(String texto){

        this.opciones = new ArrayList<String>();
        this.opciones.add(texto);
    }

    public Eleccion(List<String> unasOpciones){

        this.opciones = unasOpciones;
    }

    public boolean igualA(Eleccion otraEleccion){

        Set<String> misOpciones = new HashSet<>(this.opciones);
        return (otraEleccion.mismasOpciones(misOpciones));
    }

    private boolean mismasOpciones(Set<String> otrasOpciones){

        Set<String> misOpciones = new HashSet<>(this.opciones);
        return (misOpciones.equals(otrasOpciones));
    }


}