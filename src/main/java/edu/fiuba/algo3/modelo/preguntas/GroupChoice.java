package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.excepciones.SolucionInvalidaException;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.validadores.ValidadorOpcionesMultiples;
import edu.fiuba.algo3.modelo.preguntas.FactoryOpcionesDeGrupo;

public class GroupChoice extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE = 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 6;

    public GroupChoice(List<Opcion> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionesMultiples(CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS, CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        return this.evaluarEleccion(eleccion, PUNTAJE_FAVORABLE, PUNTAJE_DESFAVORABLE);
    }
  
    @Override
    public boolean esCorrecta(Eleccion eleccion){return this.esUnaEleccionCorrecta(eleccion);}

    public static GroupChoice recuperar(JsonArray jsonArraySolucion){
        FactoryOpciones factory = new FactoryOpcionesDeGrupo();
        List<Opcion> opciones = factory.crearOpciones(jsonArraySolucion);
        return new GroupChoice(opciones);
    }

    @Override
    public List<Opcion> recuperarOpciones(JsonArray arrayOpciones){
        FactoryOpciones factory = new FactoryOpcionesDeGrupo();
        return factory.crearOpciones(arrayOpciones);
    }
}
