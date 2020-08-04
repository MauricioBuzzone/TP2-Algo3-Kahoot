package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice extends TipoDePregunta {

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

    public GroupChoice(Eleccion eleccion){
        if(!(eleccion.esUnaEleccionValidaComoSolucion(this))){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Certificado evaluarEleccion(Eleccion eleccion){
        if(eleccion.esEleccionCorrecta(this)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(0);
        return incorrecta;
    }
    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return(opciones.size() >= 1 && opciones.size() <= 5);
    }

    @Override
    public void mostrar(){}

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
