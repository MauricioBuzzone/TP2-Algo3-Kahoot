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

        Set<Opcion> misOpciones = new HashSet<>(this.opciones);
        return (otraEleccion.mismasOpciones(misOpciones));
    }

    private boolean mismasOpciones(Set<Opcion> otrasOpciones){

        Set<Opcion> misOpciones = new HashSet<>(this.opciones);
        return (misOpciones.equals(otrasOpciones));
    }

    public int cantidadCoincidencias(Eleccion otraEleccion){

       return otraEleccion.cantidadMismasOpciones(opciones);
    }

    private int cantidadMismasOpciones(List<Opcion> otrasOpciones){

        int coincidencias = 0;
        for (Opcion opcion : otrasOpciones ){
            if (this.opciones.contains(opcion)){
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
            if(!otrasOpciones.contains(miOpcion)){
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

    private boolean contenidoEn(List<Opcion> opciones){

        return opciones.containsAll(this.opciones);
    }

}