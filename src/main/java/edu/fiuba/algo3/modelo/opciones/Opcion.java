package edu.fiuba.algo3.modelo.opciones;

import java.util.List;

public abstract class Opcion {

    protected String descripcion;

    public abstract boolean igualA(Opcion unaOpcion);

    protected boolean mismaDescripcion(String unaDescripcion){
        return this.descripcion.equals(unaDescripcion);
    }

    protected boolean mismoGrupo(String unGrupo) {
        return false;
    }

    protected boolean mismoIndice(int unIndice){
        return false;
    }

    public boolean estaContenidoEn(List<Opcion> opciones){
        for(Opcion opcion : opciones){
            if(this.igualA(opcion)){
                return true;
            }
        }
        return false;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public boolean mismaDescripcion(Opcion opcion){
        return opcion.mismaDescripcion(this.descripcion);
    }
}
