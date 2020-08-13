package edu.fiuba.algo3.modelo;


import java.util.List;

public abstract class TipoDePregunta implements Evaluador {
    protected Eleccion eleccionCorrecta;
    protected ValidadorDeOpciones validador;


    public void responderPregunta(Respuesta respuesta) {

        respuesta.responderSegunEvaluador(this);
    }

    protected boolean esUnaEleccionCorrecta(Eleccion eleccion){

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

    @Override
    public boolean sonOpcionesValidasComoSolucion(List<Opcion> opciones){
        return validador.opcionesValidasComoSolucion(opciones);
    }



    public boolean esCorrecta(Eleccion eleccion){
        return eleccion.igualA(eleccionCorrecta);
    }
}
