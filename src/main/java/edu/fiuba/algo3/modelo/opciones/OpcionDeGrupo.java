package edu.fiuba.algo3.modelo.opciones;

import com.google.gson.*;

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

    public static OpcionDeGrupo recuperar(JsonObject jsonObjectOpcion){
        String descripcion = jsonObjectOpcion.get("descripcion").getAsString();
        String grupo = jsonObjectOpcion.get("grupo").getAsString();
        OpcionDeGrupo opcionDeGrupo = new OpcionDeGrupo(descripcion, grupo);
        return opcionDeGrupo;
    }
}
