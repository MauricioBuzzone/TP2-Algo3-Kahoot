package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.preguntas.FactoryOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;
import java.util.List;
import java.util.ArrayList;

public class FactoryOpcionesOrdenadas implements FactoryOpciones{

    @Override
    public List<Opcion> crearOpciones( JsonArray arrayOpcion){

        List<Opcion> opciones = new ArrayList<Opcion>();
        for (JsonElement jsonOpcion : arrayOpcion) {
            Opcion opcion = OpcionOrdenada.recuperar(jsonOpcion.getAsJsonObject());
            opciones.add(opcion);
        }
        return opciones;
    }
}