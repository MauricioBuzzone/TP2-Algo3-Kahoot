package edu.fiuba.algo3.modelo;

public class OpcionComun extends Opcion {

    public OpcionComun(String descripcion){
        this.descripcion = descripcion;
    }

    @Override
    public boolean igualA(Opcion unaOpcion){
        return unaOpcion.mismaDescripcion(this.descripcion);
    }

}
