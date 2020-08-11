package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Eleccion {

    private List<Opcion> opciones;

    public Eleccion(List<Opcion> unasOpciones){

        this.opciones = unasOpciones;
    }

    public boolean igualA(Eleccion otraEleccion){

        return(this.mismasOpciones(otraEleccion) && otraEleccion.mismasOpciones(this));
    }

    private boolean mismasOpciones(Eleccion otraEleccion){
        return otraEleccion.mismasOpciones(this.opciones);
    }

    private boolean mismasOpciones(List<Opcion> otrasOpciones) {
        for(Opcion miOpcion : this.opciones){
            int contador = 0;
            for(Opcion otraOpcion : otrasOpciones){
                if(miOpcion.igualA(otraOpcion)){
                    contador++;
                }
            }
            if(contador != 1){
                return false;
            }
        }
        return true;
    }

    public int cantidadCoincidencias(Eleccion otraEleccion){

       return otraEleccion.cantidadMismasOpciones(opciones);
    }

    private int cantidadMismasOpciones(List<Opcion> otrasOpciones){

        int coincidencias = 0;
        for (Opcion opcion : otrasOpciones ){
            if (opcion.estaContenidoEn(this.opciones)){
                coincidencias++;
            }
        }
        return coincidencias;
    }

    /*
     *   Devuelve la cantidad de SUS opciones que no coincidan respecto de las MIAS.
     */
    public int cantidadDeNoCoincidentes(Eleccion otraEleccion){

        return otraEleccion.cantidadDeOpcionesQueNoEstanContenidas(opciones);
    }

    /*
     *   Devuelve la cantidad de opciones MIAS que no pertenecen a la lista de opciones recibida
     */
    private int cantidadDeOpcionesQueNoEstanContenidas(List<Opcion> otrasOpciones){

        int cantidadOpcionesNoCoincidentes = 0;
        for(Opcion miOpcion : opciones){
            if(!miOpcion.estaContenidoEn(otrasOpciones)){
                cantidadOpcionesNoCoincidentes++;
            }
        }
        return cantidadOpcionesNoCoincidentes;
    }

    public boolean contieneA(Eleccion otraEleccion){

        return otraEleccion.contenidoEn(opciones);
    }

    public Boolean esUnaEleccionValidaComoSolucion(Evaluador unEvaluador){
        return (unEvaluador.sonOpcionesValidasComoSolucion(opciones));
    }

    private boolean contenidoEn(List<Opcion> otrasOpciones){

        for(Opcion miOpcion : this.opciones){
            if(!miOpcion.estaContenidoEn(otrasOpciones)){
                return false;
            }
        }
        return true;
    }
}