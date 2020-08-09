package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE = 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;


    public Eleccion eleccionGrupoA;
    public Eleccion eleccionGrupoB;

    public GroupChoice(List<String> solucion){

        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionesMultiples(CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS,CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);

        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }

        this.eleccionGrupoA = this.crearEleccionDeGrupo(solucion, "A", ":");
        this.eleccionGrupoB = this.crearEleccionDeGrupo(solucion, "B", ":");
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        return this.evaluarEleccion(eleccion, PUNTAJE_FAVORABLE, PUNTAJE_DESFAVORABLE);
    }

    @Override
    protected boolean esUnaEleccionCorrecta(Eleccion eleccion){

        return(eleccion.contieneA(eleccionGrupoA) && eleccion.contieneA(eleccionGrupoB));
    }

    private Eleccion crearEleccionDeGrupo(List<String> unasOpciones, String grupo, String separador){

        List<String> opcionesGrupo = new ArrayList<String>();
        for(String opcion : unasOpciones){
            String[] informacion = opcion.split(separador);
            if(informacion[0].equals(grupo)){
                opcionesGrupo.add(opcion);
            }
        }
        return(new Eleccion(opcionesGrupo));
    }
}
