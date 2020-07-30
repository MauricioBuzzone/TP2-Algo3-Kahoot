package edu.fiuba.algo3.modelo;

import java.util.*;

public class Eleccion {

    private List<String> opciones;

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

    public int cantidadCoincidencias(Eleccion otraEleccion){

       return otraEleccion.cantidadMismasOpciones(opciones);

    }

    private int cantidadMismasOpciones(List<String> otrasOpciones){

        int coincidencias = 0;
        for (String opcion : otrasOpciones ){
            if (this.opciones.contains(opcion)){
                coincidencias++;
            }
        }
        return coincidencias;
    }
    private boolean contenidoEn(List<String> opciones){

        return opciones.containsAll(this.opciones);
    }
    public boolean contieneA(Eleccion otraEleccion){

        return otraEleccion.contenidoEn(opciones);
    }

    public int cantidadDeOpciones(){
        return this.opciones.size();
    }

}