package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class Pregunta {
    private TipoDePregunta tipo;
    private String enunciado;
    private List<Opcion> opciones;

    public Pregunta(String enunciado, List<Opcion> opciones, TipoDePregunta tipo){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
    }

    public void responderPregunta(Respuestas respuestas) {
        respuestas.responder(tipo);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getOpciones() {
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }


}
