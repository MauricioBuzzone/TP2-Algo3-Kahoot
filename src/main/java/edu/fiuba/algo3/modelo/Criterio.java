package edu.fiuba.algo3.modelo;
import java.util.List;

public interface Criterio {

    Certificado validarCriterio(Eleccion eleccion);

    boolean sonOpcionesValidas(List<String> opciones);
}
