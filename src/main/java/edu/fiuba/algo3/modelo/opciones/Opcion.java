package edu.fiuba.algo3.modelo.opciones;

import java.util.List;

public abstract class Opcion {

    protected String descripcion;

    public abstract boolean igualA(Opcion unaOpcion);

    public boolean estaContenidoEn(List<Opcion> opciones){
        return opciones.stream().anyMatch(opcion -> opcion.igualA(this));
    }

    public boolean mismaDescripcion(Opcion opcion){
        return opcion.mismaDescripcion(this.descripcion);
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    protected boolean mismaDescripcion(String unaDescripcion){
        return this.descripcion.equals(unaDescripcion);
    }

    protected boolean mismoGrupo(String unGrupo) {
        return false;
    }

    protected boolean mismoIndice(int unIndice){
        return false;
    }

    public int cantidadDeConcurrencias(List<Opcion> opciones){
        int contador = 0;
        for(Opcion opcion : opciones){
            if(this.igualA(opcion)){
                contador++;
            }
        }
        return contador;
    }
}
