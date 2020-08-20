package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import java.util.List;
import java.util.ArrayList;

public interface FactoryOpciones {

    public List<Opcion> crearOpciones( JsonArray arrayOpcion);
}