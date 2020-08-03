package edu.fiuba.algo3.modelo;

import static java.lang.Math.abs;
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

    /*
      Devuelve la cantidad de SUS opciones que no coincidan respecto a las MIAS.
     */
    public int cantidadDeNoCoincidentes(Eleccion otraEleccion){

        return otraEleccion.cantidadDeOpcionesQueNoEstanContenidas(opciones);
    }

    /*
        Devuelve la cantidad de opciones MIAS que no pertenecen a la lista de opciones recibida
     */
    private int cantidadDeOpcionesQueNoEstanContenidas(List<String> otrasOpciones){

        int cantidadOpcionesNoCoincidentes = 0;
        for(String miOpcion : opciones){
            if(!otrasOpciones.contains(miOpcion)){
                cantidadOpcionesNoCoincidentes++;
            }
        }
        return cantidadOpcionesNoCoincidentes;
    }

    private boolean contenidoEn(List<String> opciones){

        return opciones.containsAll(this.opciones);
    }

    public boolean contieneA(Eleccion otraEleccion){

        return otraEleccion.contenidoEn(opciones);
    }

    public Boolean esUnaEleccionValidaComoSolucion(Evaluador unEvaluador){
        return (unEvaluador.sonOpcionesValidasComoSolucion(opciones));
    }

    public boolean estaEnOrden(Eleccion eleccion){
        return eleccion.tienenMismoOrden(this.opciones);
    }

    private  boolean tienenMismoOrden(List<String> opciones){
        return this.opciones.equals(opciones);
    }
}