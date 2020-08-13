package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RespondedorPorDefecto {

    private Kahoot kahoot;
    public RespondedorPorDefecto(Kahoot kahoot){
        this.kahoot = kahoot;
    }

    public void responder() {

        this.kahoot.agregarRespuesta(this.respuestaPorDefecto());
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
