package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class RespondedorPorDefecto extends Observable {

    private Ronda ronda;
    public RespondedorPorDefecto(Ronda ronda){
        this.ronda = ronda;
    }

    public void responder() {

        this.ronda.agregarRespuesta(this.respuestaPorDefecto());
    }


    private Respuesta respuestaPorDefecto(){
        Jugador unJugador = this.ronda.getJugadorActivo();
        Opcion opcionVacia = new OpcionComun("");
        List<Opcion> opcionesVacias = new ArrayList<>();
        opcionesVacias.add(opcionVacia);
        Eleccion eleccion = new Eleccion(opcionesVacias);
        Bonificador bonificador = new Bonificador();

        return new Respuesta(unJugador, eleccion, bonificador);
    }
}
