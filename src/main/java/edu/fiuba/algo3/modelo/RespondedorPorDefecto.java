package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class RespondedorPorDefecto extends Observable {

    private Kahoot kahoot;
    public RespondedorPorDefecto(Kahoot kahoot){
        this.kahoot = kahoot;
    }

    public void responder() {

        this.kahoot.agregarRespuesta(this.respuestaPorDefecto());
        this.setChanged();
        this.notifyObservers();
    }


    private Respuesta respuestaPorDefecto(){
        Jugador unJugador = this.kahoot.getJugador();
        Opcion opcionVacia = new OpcionComun("");
        List<Opcion> opcionesVacias = new ArrayList<>();
        opcionesVacias.add(opcionVacia);
        Eleccion eleccion = new Eleccion(opcionesVacias);
        Bonificador bonificador = new Bonificador();

        return new Respuesta(unJugador, eleccion, bonificador);
    }
}
