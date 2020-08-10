package edu.fiuba.algo3.modelo;

import java.util.List;

public class Pregunta implements Mostrable {
    private TipoDePregunta tipo;
    private String enunciado;
    private List<Opcion> opciones;

    public Pregunta(String enunciado, List<Opcion> opciones, TipoDePregunta tipo){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            tipo.responderPregunta(respuesta);
        }
    }
    @Override
    public void mostrar(){
        tipo.mostrar(this.enunciado, this.opciones);
    }

}
