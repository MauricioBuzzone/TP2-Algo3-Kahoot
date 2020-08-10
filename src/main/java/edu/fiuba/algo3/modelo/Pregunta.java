package edu.fiuba.algo3.modelo;

import java.util.List;

public class Pregunta implements Mostrable{
    private TipoDePregunta tipo;
    private String enunciado;
    private List<String> opciones;

    private Exclusividad exclusividad = new Exclusividad();

    public Pregunta(String enunciado, List<String> opciones, TipoDePregunta tipo){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            tipo.responderPregunta(respuesta);
        }
        this.repartirPuntos(respuestas);
    }
    public void repartirPuntos(List<Respuesta> respuestas){
        exclusividad.aplicar(respuestas);
    }
    public void aplicarExclusividad(){
        exclusividad.upgrade();
    }

    @Override
    public void mostrar(){
        tipo.mostrar(this.enunciado, this.opciones);
    }

}
