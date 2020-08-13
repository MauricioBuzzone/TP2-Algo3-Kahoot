package edu.fiuba.algo3.modelo;

import java.util.TimerTask;

public class CuentaAtras extends TimerTask {

    RespondedorPorDefecto respondedor;

    public CuentaAtras(RespondedorPorDefecto respondedor){
        this.respondedor = respondedor;
    }

    @Override
    public void run() {
        respondedor.responder();
    }
}
