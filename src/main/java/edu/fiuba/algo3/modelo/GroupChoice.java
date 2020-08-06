package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE= 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;
    private static final int CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS = 1;
    private static final int CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS = 5;

    public Eleccion eleccionGrupoA;
    public Eleccion eleccionGrupoB;

    public GroupChoice(List<String> solucion){

        Eleccion eleccion = new Eleccion(solucion);
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        this.eleccionGrupoA = this.parsearListaGrupo(solucion, "A", ":");
        this.eleccionGrupoB = this.parsearListaGrupo(solucion, "B", ":");
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        if(eleccion.esEleccionCorrecta(this)){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(PUNTAJE_FAVORABLE);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(PUNTAJE_DESFAVORABLE);
        return puntaje;
    }
    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= CANTIDAD_DE_SOLUCIONES_MINIMAS_VALIDAS && opciones.size() <= CANTIDAD_DE_SOLUCIONES_MAXIMAS_VALIDAS);
    }


    public boolean sonOpcionesCorrectas(List<String> unasOpciones){
        Eleccion grupoA = this.parsearListaGrupo(unasOpciones, "A", ":");
        Eleccion grupoB = this.parsearListaGrupo(unasOpciones, "B", ":");
        return (this.eleccionGrupoA.igualA(grupoA) && this.eleccionGrupoB.igualA(grupoB));
    }

    private Eleccion parsearListaGrupo(List<String> unasOpciones, String grupo, String separador){
        List<String> opcionesGrupo = new ArrayList<String>();
        for(String opcion : unasOpciones){
            String[] informacion = opcion.split(separador);
            if(informacion[0].equals(grupo)){

                String opcionJugador = informacion[1];
                opcionesGrupo.add(opcionJugador);
            }
        }
        return new Eleccion(opcionesGrupo);
    }

}
