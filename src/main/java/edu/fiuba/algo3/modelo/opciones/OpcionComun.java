package edu.fiuba.algo3.modelo.opciones;

import com.google.gson.*;

public class OpcionComun extends Opcion {

    public OpcionComun(String descripcion){
        this.descripcion = descripcion;
    }

    @Override
    public boolean igualA(Opcion unaOpcion){
        return unaOpcion.mismaDescripcion(this.descripcion);
    }

    public static OpcionComun recuperar(JsonObject jsonObjectOpcion){
        String descripcion = jsonObjectOpcion.get("descripcion").getAsString();
        OpcionComun opcionComun = new OpcionComun(descripcion);
        return opcionComun;
    }
}
