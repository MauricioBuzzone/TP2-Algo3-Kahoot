package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;

import java.util.List;

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
        boolean mismasOpciones = true;

        for(Opcion miOpcion : this.opciones){
            if(miOpcion.cantidadDeConcurrencias(otrasOpciones) != 1){
                mismasOpciones = false;
            }
        }

        return mismasOpciones;
    }


    public int cantidadCoincidencias(Eleccion otraEleccion){

       return otraEleccion.cantidadDeMismasOpciones(opciones);
    }

    private int cantidadDeMismasOpciones(List<Opcion> otrasOpciones){

        int coincidencias = 0;
        for (Opcion opcion : otrasOpciones){
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

        return otraEleccion.cantidadDeOpcionesQueNoEstanContenidasEn(opciones);
    }

    /*
     *   Devuelve la cantidad de opciones PROPIAS que no pertenecen a la lista de opciones RECIBIDA
     */
    private int cantidadDeOpcionesQueNoEstanContenidasEn(List<Opcion> otrasOpciones){

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
        boolean estaContenido = true;
        for(Opcion miOpcion : this.opciones){
            if(!miOpcion.estaContenidoEn(otrasOpciones)){
                estaContenido = false;
            }
        }
        return estaContenido;
    }
}