package edu.fiuba.algo3.modelo;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Kahoot {

    public static final int VERDADERO_FALSO = 1;

    private Ronda rondaActiva;
    private Queue<Ronda> rondas = new LinkedList<Ronda>();
    private Tabla tablaJugadores;

    public Kahoot(List<Jugador> jugadores){
        tablaJugadores = new Tabla(jugadores);
        this.agregarPreguntas();
    }
    private void agregarPreguntas(){

        String enunciadoUno = "Diego es pintorRodillo";
        Opcion solucionUno = new OpcionComun("Verdadero");
        Opcion opcionIncorrectaUno = new OpcionComun("Falso");

        List<Opcion> opcionCorrectaUno = new ArrayList<Opcion>();
        opcionCorrectaUno.add(solucionUno);

        List<Opcion> opcionesUno = new ArrayList<Opcion>();
        opcionesUno.add(solucionUno);
        opcionesUno.add(opcionIncorrectaUno);

        TipoDePregunta tipoVerdaderoFalsoUno = new VerdaderoFalso(opcionCorrectaUno);
        Pregunta preguntaUno = new Pregunta(enunciadoUno, opcionesUno, tipoVerdaderoFalsoUno);

        String enunciadoDos = "Tomás nunca pintó con salsa de tomate";
        Opcion solucionDos = new OpcionComun("Falso");
        Opcion opcionIncorrectaDos = new OpcionComun("Verdadero");
        List<Opcion> opcionCorrectaDos = new ArrayList<Opcion>();
        opcionCorrectaDos.add(solucionDos);

        List<Opcion> opcionesDos = new ArrayList<Opcion>();
        opcionesDos.add(opcionIncorrectaDos);
        opcionesDos.add(solucionDos);


        TipoDePregunta tipoVerdaderoFalsoDos = new VerdaderoFalso(opcionCorrectaDos);
        Pregunta preguntaDos = new Pregunta(enunciadoDos, opcionesDos, tipoVerdaderoFalsoDos);

        this.agregarPregunta(preguntaUno);
        this.agregarPregunta(preguntaDos);
    }

    public void agregarPregunta(Pregunta pregunta){
        Ronda ronda = new Ronda(pregunta, tablaJugadores.jugadores());
        rondas.add(ronda);
    }

    public boolean haySiguienteRonda(){
        return(!rondas.isEmpty());
    }

    public void siguienteRonda(){
        rondaActiva = rondas.poll();
    }

    public String getEnunciado(){
        return rondaActiva.getEnunciado();
    }

    public List<String> getOpciones(){
        return rondaActiva.getOpciones();
    }

    public int tipoDePregunta(){
        return 1; // cambiar lógica
    }

    public boolean haySiguienteJugador(){
        return rondaActiva.haySiguienteJugador();
    }

    public void siguienteJugador(){
        rondaActiva.siguienteJugador();
    }

    public Jugador getJugador(){
        return rondaActiva.getJugador();
    }

    public void agregarRespuesta(Respuesta respuesta){
        rondaActiva.agregarRespuesta(respuesta);
    }

    public void responder(){
        rondaActiva.responder();
    }

    public Tabla terminarJuego(){
        return tablaJugadores;
    }
}
