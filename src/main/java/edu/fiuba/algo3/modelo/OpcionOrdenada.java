package edu.fiuba.algo3.modelo;

public class OpcionOrdenada extends Opcion {

    int indice;

    public OpcionOrdenada(String unaDescripcion, int unIndice){
        this.descripcion = unaDescripcion;
        this.indice = unIndice;
    }

    @Override
    public boolean igualA(Opcion unaOpcion){
        return (unaOpcion.mismaDescripcion(this.descripcion) &&
                unaOpcion.mismoIndice(this.indice));
    }

    @Override
    protected boolean mismoIndice(int unIndice){
        return this.indice == unIndice;
    }
}
