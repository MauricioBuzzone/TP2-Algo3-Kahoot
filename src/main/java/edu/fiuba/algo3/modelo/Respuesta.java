package edu.fiuba.algo3.modelo;

public class Respuesta {

    private Jugador jugador;
    private Validez validez;
    private Opcion opcion;
}

public Respuesta(Jugador jugador, Opcion opcion){
    this.opcion = opcion;
    this.jugador = jugador;
    this.validez = null; //hay q crear la clase invalida? o lo dejamos sin inicializar
}

public void evaluarConCriterio(Criterio criterio){
    validez = criterio.validarCriterio(opcion);
}

public void responder(){
    validez.responder(jugador);
}

