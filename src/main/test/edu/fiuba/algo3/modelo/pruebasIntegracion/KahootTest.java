package edu.fiuba.algo3.modelo.pruebasIntegracion;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class KahootTest{

    @Test
    public void test01KahootConDosJugadoresYRondasDeRondasJsonYLosJugaresPuedenJugar(){

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        Kahoot kahoot = new Kahoot(jugadores, "Rondas.json");


        assert(kahoot.haySiguienteRonda());

        kahoot.siguienteRonda();

        String enunciado = kahoot.getEnunciado();
        List<String> opciones = kahoot.getOpciones();
        int tipoDePregunta = kahoot.tipoDePregunta();

        assert(tipoDePregunta == Kahoot.VERDADERO_FALSO);

        assert(kahoot.haySiguienteJugador());

        //Timer
        kahoot.siguienteJugador();
        Jugador jugador1 = kahoot.getJugador();

        List<Opcion> opcionDiegoUno = new ArrayList<Opcion>();
        opcionDiegoUno.add(new OpcionComun("Falso"));
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);
        Bonificador bonificadorDiego = new Bonificador();
        Respuesta primeraRespuestaDiego = new Respuesta(jugador1, primeraEleccionDiego, bonificadorDiego);


        kahoot.agregarRespuesta(primeraRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        kahoot.siguienteJugador();
        Jugador jugador2 = kahoot.getJugador();

        List<Opcion> opcionTomasUno = new ArrayList<Opcion>();
        opcionTomasUno.add(new OpcionComun("Verdadero"));
        Eleccion primeraEleccionTomas = new Eleccion(opcionTomasUno);
        Bonificador bonificadorTomas = new Bonificador();
        Respuesta primeraRespuestaTomas = new Respuesta(jugador2, primeraEleccionTomas, bonificadorTomas);

        kahoot.agregarRespuesta(primeraRespuestaTomas);


        assertFalse(kahoot.haySiguienteJugador());

        kahoot.responder();


        assert(kahoot.haySiguienteRonda());

        kahoot.siguienteRonda();

        String enunciado2 = kahoot.getEnunciado();
        List<String> opciones2 = kahoot.getOpciones();
        int tipoDePregunta2 = kahoot.tipoDePregunta();

        assert(tipoDePregunta == Kahoot.VERDADERO_FALSO);

        assert(kahoot.haySiguienteJugador());

        //Timer
        kahoot.siguienteJugador();
        jugador1 = kahoot.getJugador();

        List<Opcion> opcionDiegoDos = new ArrayList<Opcion>();
        opcionDiegoDos.add(new OpcionComun("Falso"));
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);
        Bonificador segundoBonificadorDiego = new Bonificador();

        Respuesta segundaRespuestaDiego = new Respuesta(jugador1, segundaEleccionDiego, segundoBonificadorDiego);

        kahoot.agregarRespuesta(segundaRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        kahoot.siguienteJugador();
        jugador2 = kahoot.getJugador();

        List<Opcion> opcionTomasDos = new ArrayList<Opcion>();
        opcionTomasDos.add(new OpcionComun("Falso"));
        Eleccion segundaEleccionTomas = new Eleccion(opcionTomasDos);
        Bonificador segundoBonificadorTomas = new Bonificador();

        Respuesta segundaRespuestaTomas = new Respuesta(jugador2, segundaEleccionTomas, segundoBonificadorTomas);

        assertFalse(kahoot.haySiguienteJugador());

        kahoot.responder();

        assertFalse(kahoot.haySiguienteRonda());

        Tabla tabla = kahoot.terminarJuego();
    }

    @Test
    public void test02KahootConDosJugadoresYRondsMultipleChoicePuedenSerJugadasYAsignanCorectamenteLosPuntosAlosJugadores(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);


        Kahoot kahoot = new Kahoot(jugadores,"Rondas01.json");

        assert(kahoot.haySiguienteRonda());
        kahoot.siguienteRonda();

        assert(kahoot.haySiguienteJugador());

        //Timer
        kahoot.siguienteJugador();
        Jugador jugador1 = kahoot.getJugador();

        List<Opcion> opcionDiegoUno = new ArrayList<Opcion>();
        opcionDiegoUno.add(new OpcionComun("opcion1"));
        opcionDiegoUno.add(new OpcionComun("opcion2"));
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);
        Bonificador bonificadorDiego = new Bonificador();
        Respuesta primeraRespuestaDiego = new Respuesta(jugador1, primeraEleccionDiego, bonificadorDiego);


        kahoot.agregarRespuesta(primeraRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        kahoot.siguienteJugador();
        Jugador jugador2 = kahoot.getJugador();

        List<Opcion> opcionTomasUno = new ArrayList<Opcion>();
        opcionTomasUno.add(new OpcionComun("opcion2"));
        opcionTomasUno.add(new OpcionComun("opcion3"));
        Eleccion primeraEleccionTomas = new Eleccion(opcionTomasUno);
        Bonificador bonificadorTomas = new Bonificador();
        Respuesta primeraRespuestaTomas = new Respuesta(jugador2, primeraEleccionTomas, bonificadorTomas);

        kahoot.agregarRespuesta(primeraRespuestaTomas);


        assertFalse(kahoot.haySiguienteJugador());

        kahoot.responder();

        assertEquals(jugador1.puntosTotales(),1);
        assertEquals(jugador2.puntosTotales(),0);

        assert(kahoot.haySiguienteRonda());
        kahoot.siguienteRonda();

        //Timer
        kahoot.siguienteJugador();
        jugador1 = kahoot.getJugador();

        List<Opcion> opcionDiegoDos = new ArrayList<Opcion>();
        opcionDiegoDos.add(new OpcionComun("opcion2"));
        opcionDiegoDos.add(new OpcionComun("opcion3"));
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);
        Bonificador segundoBonificadorDiego = new Bonificador();

        Respuesta segundaRespuestaDiego = new Respuesta(jugador1, segundaEleccionDiego, segundoBonificadorDiego);

        kahoot.agregarRespuesta(segundaRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        kahoot.siguienteJugador();
        jugador2 = kahoot.getJugador();

        List<Opcion> opcionTomasDos = new ArrayList<Opcion>();
        opcionTomasDos.add(new OpcionComun("opcion1"));
        opcionTomasDos.add(new OpcionComun("opcion2"));
        Eleccion segundaEleccionTomas = new Eleccion(opcionTomasDos);
        Bonificador segundoBonificadorTomas = new Bonificador();

        Respuesta segundaRespuestaTomas = new Respuesta(jugador2, segundaEleccionTomas, segundoBonificadorTomas);

        assertFalse(kahoot.haySiguienteJugador());

        kahoot.responder();

        assertFalse(kahoot.haySiguienteRonda());
        assertEquals(jugador1.puntosTotales(),2);
        assertEquals(jugador2.puntosTotales(),0);
        Tabla tabla = kahoot.terminarJuego();
    }
    @Test
    public void test03KahootConDosJugadoresYRondasOrderedYGroupPuedenSerJugadasYAsignanCorectamenteLosPuntosAlosJugadores(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        Kahoot kahoot = new Kahoot(jugadores,"Rondas02.json");


        assert(kahoot.haySiguienteRonda());
        kahoot.siguienteRonda();

        assert(kahoot.haySiguienteJugador());

        //Timer
        kahoot.siguienteJugador();
        Jugador jugador1 = kahoot.getJugador();

        List<Opcion> opcionDiegoUno = new ArrayList<Opcion>();
        opcionDiegoUno.add(new OpcionOrdenada("opcion1",1));
        opcionDiegoUno.add(new OpcionOrdenada("opcion2",2));
        opcionDiegoUno.add(new OpcionOrdenada("opcion3",3));
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);
        Bonificador bonificadorDiego = new Bonificador();
        Respuesta primeraRespuestaDiego = new Respuesta(jugador1, primeraEleccionDiego, bonificadorDiego);


        kahoot.agregarRespuesta(primeraRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        kahoot.siguienteJugador();
        Jugador jugador2 = kahoot.getJugador();

        List<Opcion> opcionTomasUno = new ArrayList<Opcion>();
        opcionTomasUno.add(new OpcionOrdenada("opcion1",1));
        opcionTomasUno.add(new OpcionOrdenada("opcion3",2));
        opcionTomasUno.add(new OpcionOrdenada("opcion2",3));
        Eleccion primeraEleccionTomas = new Eleccion(opcionTomasUno);
        Bonificador bonificadorTomas = new Bonificador();
        Respuesta primeraRespuestaTomas = new Respuesta(jugador2, primeraEleccionTomas, bonificadorTomas);

        kahoot.agregarRespuesta(primeraRespuestaTomas);


        assertFalse(kahoot.haySiguienteJugador());

        kahoot.responder();

        assertEquals(jugador1.puntosTotales(),1);
        assertEquals(jugador2.puntosTotales(),0);

        assert(kahoot.haySiguienteRonda());
        kahoot.siguienteRonda();

        //Timer
        kahoot.siguienteJugador();
        jugador1 = kahoot.getJugador();

        List<Opcion> opcionDiegoDos = new ArrayList<Opcion>();
        opcionDiegoDos.add(new OpcionDeGrupo("opcion1","A"));
        opcionDiegoDos.add(new OpcionDeGrupo("opcion2","A"));
        opcionDiegoDos.add(new OpcionDeGrupo("opcion3","B"));
        opcionDiegoDos.add(new OpcionDeGrupo("opcion4","B"));
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);
        Bonificador segundoBonificadorDiego = new Bonificador();

        Respuesta segundaRespuestaDiego = new Respuesta(jugador1, segundaEleccionDiego, segundoBonificadorDiego);

        kahoot.agregarRespuesta(segundaRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        kahoot.siguienteJugador();
        jugador2 = kahoot.getJugador();

        List<Opcion> opcionTomasDos = new ArrayList<Opcion>();
        opcionTomasDos.add(new OpcionDeGrupo("opcion1","A"));
        opcionTomasDos.add(new OpcionDeGrupo("opcion2","B"));
        opcionTomasDos.add(new OpcionDeGrupo("opcion3","B"));
        opcionTomasDos.add(new OpcionDeGrupo("opcion4","B"));
        Eleccion segundaEleccionTomas = new Eleccion(opcionTomasDos);
        Bonificador segundoBonificadorTomas = new Bonificador();

        Respuesta segundaRespuestaTomas = new Respuesta(jugador2, segundaEleccionTomas, segundoBonificadorTomas);

        assertFalse(kahoot.haySiguienteJugador());

        kahoot.responder();

        assertFalse(kahoot.haySiguienteRonda());
        assertEquals(jugador1.puntosTotales(),2);
        assertEquals(jugador2.puntosTotales(),0);
        Tabla tabla = kahoot.terminarJuego();
    }
}