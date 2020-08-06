package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.VistaPreguntaClasica;

import java.util.List;

public abstract class TipoDePregunta implements Evaluador{
    protected Eleccion eleccionCorrecta;

    public void responderPregunta(Respuesta respuesta) {

        respuesta.responderSegunEvaluador(this);
    }

    @Override
    public boolean esUnaEleccionCorrecta(Eleccion eleccion){

        return eleccion.igualA(this.eleccionCorrecta);
    }

    protected Puntaje evaluarEleccion(Eleccion eleccion, int puntosCasoFavorable, int puntosCasoDesfavorable){

        if(this.esUnaEleccionCorrecta(eleccion)){
            Puntaje puntaje = Puntaje.crearPuntajeFavorable(puntosCasoFavorable);
            return puntaje;
        }
        Puntaje puntaje = Puntaje.crearPuntajeDesfavorable(puntosCasoDesfavorable);
        return puntaje;
    }

    public void mostrar(String enunciado, List<String> opciones){

        VistaPreguntaClasica vista = new VistaPreguntaClasica(enunciado, opciones);
        vista.mostrar();
    }
}
