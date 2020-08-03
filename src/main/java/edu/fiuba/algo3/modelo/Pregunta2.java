package edu.fiuba.algo3.modelo;

import java.util.List;

public class Pregunta2 {
    private TipoDePregunta tipo;
    private String enunciado;
    private List<String> opciones;

    public Pregunta2(String enunciado, List<String> opciones, TipoDePregunta tipo){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            tipo.responderPregunta(respuesta);
        }
    }
}
