package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;
import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;

import java.util.List;
import java.util.ArrayList;

public class FactoryOpciones{

    public List<Opcion> crearOpciones(String tipoDePregunta, JsonArray arrayOpcion){

        List<Opcion> opciones = new ArrayList<Opcion>();

        if(tipoDePregunta.equals("OrderedChoice")) {
            for (JsonElement jsonOpcion : arrayOpcion) {
                Opcion opcion = OpcionOrdenada.recuperar(jsonOpcion.getAsJsonObject());
                opciones.add(opcion);
            }
        }
        else if(tipoDePregunta.equals("GroupChoice")){
            for (JsonElement jsonOpcion : arrayOpcion) {
                Opcion opcion = OpcionDeGrupo.recuperar(jsonOpcion.getAsJsonObject());
                opciones.add(opcion);
            }
        }
        else{
            for (JsonElement jsonOpcion : arrayOpcion) {
                Opcion opcion = OpcionComun.recuperar(jsonOpcion.getAsJsonObject());
                opciones.add(opcion);
            }
        }
        return opciones;
    }
}