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

        String enunciado = "Situar cronologicamente [de pasado a futuro]";

        Opcion opcion1 = new OpcionOrdenada("Gallina", 2);
        Opcion opcion2 = new OpcionOrdenada("Huevo", 1);
        Opcion opcion3 = new OpcionOrdenada("Muerte de Mirtha", 4);
        Opcion opcion4 = new OpcionOrdenada("El huevo frito", 3);

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);
        solucion.add(opcion4);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);


        TipoDePregunta orderedChoice = new OrderedChoice(solucion);
        Pregunta preguntaOC = new Pregunta(enunciado, opciones, orderedChoice);
        this.agregarPregunta(preguntaOC);

        String enunciado2 = "A Diego el gusta lo simple";
        Opcion solucion2 = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");

        List<Opcion> opcionCorrecta = new ArrayList<Opcion>();
        opcionCorrecta.add(solucion2);
        List<Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcionIncorrecta);
        opciones2.add(solucion2);
        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(opcionCorrecta);
        Pregunta preguntaVF = new Pregunta(enunciado2, opciones2, tipoVerdaderoFalso);

        this.agregarPregunta(preguntaVF);
    }

    public void agregarPregunta(Pregunta pregunta){
        Ronda ronda = new Ronda(pregunta, tablaJugadores.jugadores());
        rondas.add(ronda);
    }

    public void jugadorVaAResponder(){
        Timer timer = new Timer();
        RespondedorPorDefecto respondedor = new RespondedorPorDefecto(this);
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
