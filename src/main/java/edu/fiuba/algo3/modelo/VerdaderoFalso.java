package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;

public class VerdaderoFalso extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE= 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;

    public VerdaderoFalso(List<Opcion> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionUnica();

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        return this.evaluarEleccion(eleccion, PUNTAJE_FAVORABLE, PUNTAJE_DESFAVORABLE);
    }

    public static VerdaderoFalso recuperar(JsonObject jsonObjectSolucion){

        List<Opcion> opciones = new ArrayList<Opcion>();
        JsonArray arrayOpciones = jsonObjectSolucion.getAsJsonArray("solucion");
        for (JsonElement jsonOpcion : arrayOpciones) {
            Opcion opcion = OpcionComun.recuperar(jsonOpcion.getAsJsonObject());
            opciones.add(opcion);
        }
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso(opciones);
        return verdaderoFalso;
    }
}
