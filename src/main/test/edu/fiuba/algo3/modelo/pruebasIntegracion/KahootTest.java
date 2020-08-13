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
import static org.junit.jupiter.api.Assertions.assertEquals;



public class KahootTest{

    @Test
    public void test01(){

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        Kahoot kahoot = new Kahoot(jugadores);
        try {
            kahoot.agregarRonda("Rondas.json");
        } catch (IOException ex) {
            System.out.println(ex);
        }


        assert(kahoot.haySiguienteRonda());

        kahoot.siguienteRonda();

        String enunciado = kahoot.getEnunciado();
        List<String> opciones = kahoot.getOpciones();
        int tipoDePregunta = kahoot.tipoDePregunta();

        assert(tipoDePregunta == Kahoot.VERDADERO_FALSO);

        assert(kahoot.haySiguienteJugador());

        //Timer
        Jugador jugador1 = kahoot.getSiguienteJugador();

        List<Opcion> opcionDiegoUno = new ArrayList<Opcion>();
        opcionDiegoUno.add(new OpcionComun("Falso"));
        Eleccion primeraEleccionDiego = new Eleccion(opcionDiegoUno);
        Bonificador bonificadorDiego = new Bonificador();
        Respuesta primeraRespuestaDiego = new Respuesta(jugador1, primeraEleccionDiego, bonificadorDiego);


        kahoot.agregarRespuesta(primeraRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        Jugador jugador2 = kahoot.getSiguienteJugador();

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
        jugador1 = kahoot.getSiguienteJugador();

        List<Opcion> opcionDiegoDos = new ArrayList<Opcion>();
        opcionDiegoDos.add(new OpcionComun("Falso"));
        Eleccion segundaEleccionDiego = new Eleccion(opcionDiegoDos);
        Bonificador segundoBonificadorDiego = new Bonificador();

        Respuesta segundaRespuestaDiego = new Respuesta(jugador1, segundaEleccionDiego, segundoBonificadorDiego);

        kahoot.agregarRespuesta(segundaRespuestaDiego);

        assert(kahoot.haySiguienteJugador());

        jugador2 = kahoot.getSiguienteJugador();

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
}

