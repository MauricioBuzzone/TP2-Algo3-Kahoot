package edu.fiuba.algo3.modelo;

import java.util.*;

public class Kahoot {

    public static final int VERDADERO_FALSO = Pregunta.VERDADERO_FALSO;
    public static final int VERDADERO_FALSO_CON_PENALIDAD = Pregunta.VERDADERO_FALSO_CON_PENALIDAD;
    public static final int MULTIPLE_CHOICE_CLASICO = Pregunta.MULTIPLE_CHOICE_CLASICO;
    public static final int MULTIPLE_CHOICE_CON_PENALIDAD = Pregunta.MULTIPLE_CHOICE_CON_PENALIDAD;
    public static final int MULTIPLE_CHOICE_PUNTAJE_PARCIAL = Pregunta.MULTIPLE_CHOICE_PUNTAJE_PARCIAL;
    public static final int ORDERED_CHOICE = Pregunta.ORDERED_CHOICE;
    public static final int GROUP_CHOICE = Pregunta.GROUP_CHOICE;

    private Ronda rondaActiva;
    private Queue<Ronda> rondas = new LinkedList<Ronda>();
    private Tabla tablaJugadores;
    private CuentaAtras cuentaAtras;

    public Kahoot(List<Jugador> jugadores){
        tablaJugadores = new Tabla(jugadores);
        this.agregarPreguntas();

    }

    //TestOnly
    public Kahoot(List<Jugador> jugadores, Pregunta pregunta){
        tablaJugadores = new Tabla(jugadores);
        this.agregarPregunta(pregunta);
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

    public void jugadorVaAResponder(RespondedorPorDefecto respondedor){
        Timer timer = new Timer();
        this.cuentaAtras = new CuentaAtras(respondedor);
        timer.schedule(this.cuentaAtras, 15000);
    }

    public void jugadorYaRespondio(){
        cuentaAtras.cancel();
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
        return rondaActiva.tipoDePregunta();
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
