package edu.fiuba.algo3.modelo;

public class OpcionDeGrupo extends Opcion {

    protected String grupo;

    public OpcionDeGrupo(String descripcion, String grupo){
        this.descripcion = descripcion;
        this.grupo = grupo;
    }

    @Override
    public boolean igualA(Opcion unaOpcion){
        return (unaOpcion.mismaDescripcion(this.descripcion) &&
                unaOpcion.mismoGrupo(this.grupo));
    }

    @Override
    protected boolean mismoGrupo(String unGrupo) {
        return this.grupo.equals(unGrupo);
    }


}
