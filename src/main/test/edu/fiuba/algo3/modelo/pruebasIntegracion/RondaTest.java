package edu.fiuba.algo3.modelo.pruebasIntegracion;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class RondaTest{

    @Test
    public void test01UnaRondaSeCreaConPreguntaVerdaderoFalsoYListaDeDosJugadoresYSeJuegaCorrectamente(){
        String enunciado = "Diego es pintorRodillo (?";
        Opcion solucion = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");

        List<Opcion> opcionCorrecta = new ArrayList<Opcion>();
        opcionCorrecta.add(solucion);
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionIncorrecta);
        opciones.add(solucion);

        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(opcionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        Ronda ronda = new Ronda(pregunta, jugadores);

        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Falso"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        ronda.agregarRespuesta(eleccionDiego, bonificadorDiego);

        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Verdadero"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        ronda.agregarRespuesta(eleccionTomas, bonificadorTomas);

        ronda.evaluarRespuestas();

        assertEquals(diego.puntosTotales(), 0);
        assertEquals (tomas.puntosTotales() , 1);
    }

    @Test
    public void test02UnaRondaSeCreaConPreguntaVerdaderoFalsoYListaDeDosJugadoresConExclusividadYSeJuegaCorrectamente(){
        String enunciado = "Diego es pintorRodillo (?";
        Opcion solucion = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");

        List<Opcion> opcionCorrecta = new ArrayList<Opcion>();
        opcionCorrecta.add(solucion);
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionIncorrecta);
        opciones.add(solucion);

        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalso(opcionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        Ronda ronda = new Ronda(pregunta, jugadores);

        ronda.activarExclusividad();

        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(new OpcionComun("Falso"));
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        ronda.agregarRespuesta(eleccionDiego, bonificadorDiego);

        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(new OpcionComun("Verdadero"));
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        ronda.agregarRespuesta(eleccionTomas, bonificadorTomas);

        ronda.evaluarRespuestas();

        assertEquals(diego.puntosTotales(), 0);
        assertEquals (tomas.puntosTotales() , 2);
    }

    public void test03UnaRondaSeCreaConPreguntaMultipleChoiceYListaDeDosJugadoresYSeJuegaCorrectamente(){
        String enunciado = "Horóscopo Chino:¿Cuáles realmente pertenecen?";

        Opcion opcion1 = new OpcionComun("Perro");
        Opcion opcion2 = new OpcionComun("Gallo");
        Opcion opcion3 = new OpcionComun("Rinoceronte");
        Opcion opcion4 = new OpcionComun("Cerdo");
        Opcion opcion5 = new OpcionComun("Carpincho");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion4);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        TipoDePregunta tipoMultipleChoiceClasico = new MultipleChoiceClasico(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceClasico);

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        Ronda ronda = new Ronda(pregunta, jugadores);

        List<Opcion> opcionDiego = new ArrayList<Opcion>();
        opcionDiego.add(opcion3);
        opcionDiego.add(opcion4);
        Eleccion eleccionDiego = new Eleccion(opcionDiego);

        Bonificador bonificadorDiego = new Bonificador();

        ronda.agregarRespuesta(eleccionDiego, bonificadorDiego);

        List<Opcion> opcionTomas = new ArrayList<Opcion>();
        opcionTomas.add(opcion1);
        opcionTomas.add(opcion2);
        opcionTomas.add(opcion4);
        Eleccion eleccionTomas = new Eleccion(opcionTomas);

        Bonificador bonificadorTomas = new Bonificador();

        ronda.agregarRespuesta(eleccionTomas, bonificadorTomas);

        ronda.evaluarRespuestas();

        assertEquals(diego.puntosTotales(), 0);
        assertEquals (tomas.puntosTotales() , 1);
    }
}