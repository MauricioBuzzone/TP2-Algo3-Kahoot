package edu.fiuba.algo3.modelo;

public class Opcion {
    private String texto;

    public Opcion(String texto){
        this.texto = texto;
    }

    public boolean igualA(Opcion otraOpcion){
        return (otraOpcion.mismoTexto(texto));
    }
    private boolean mismoTexto(String otroTexto){
        return (texto == otroTexto);
    }

}