package edu.fiuba.algo3.modelo;

import java.util.List;

public class Pregunta implements Mostrable {
    private TipoDePregunta tipo;
    private String enunciado;
    private List<Opcion> opciones;
    private Exclusividad exclusividad;

    public Pregunta(String enunciado, List<Opcion> opciones, TipoDePregunta tipo){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
        exclusividad = new Exclusividad();
    }

    public void responderPregunta(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            tipo.responderPregunta(respuesta);
        }
        this.repartirPuntos(respuestas);
    }

    public void repartirPuntos(List<Respuesta> respuestas){
        exclusividad.asignarPuntos(respuestas, tipo);
    }

    public void activarExclusividad(){
        exclusividad.mejorarExclusividad();
    }

    @Override
    public void mostrar(){
        tipo.mostrar(this.enunciado, this.opciones);
    }

}
