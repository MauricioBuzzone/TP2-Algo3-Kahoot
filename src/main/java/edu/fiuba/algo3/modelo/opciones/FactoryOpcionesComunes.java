package edu.fiuba.algo3.modelo.opciones;

import com.google.gson.*;

import java.util.List;
import java.util.ArrayList;

public class FactoryOpcionesComunes implements FactoryOpciones{

    @Override
    public List<Opcion> crearOpciones( JsonArray arrayOpcion){

        List<Opcion> opciones = new ArrayList<Opcion>();
        for (JsonElement jsonOpcion : arrayOpcion) {
            Opcion opcion = OpcionComun.recuperar(jsonOpcion.getAsJsonObject());
            opciones.add(opcion);
        }
        return opciones;
    }
}