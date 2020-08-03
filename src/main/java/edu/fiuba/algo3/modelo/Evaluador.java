package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Evaluador {
    public Certificado evaluarEleccion(Eleccion eleccion);
    public Boolean sonOpcionesValidas(List<String> opciones);
}
