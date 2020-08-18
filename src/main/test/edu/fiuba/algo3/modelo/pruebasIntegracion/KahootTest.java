package edu.fiuba.algo3.modelo.pruebasIntegracion;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opciones.*;

import edu.fiuba.algo3.modelo.respuestas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KahootTest {

    @Test
    public void test01CuandoSeJuegaElSiguienteKahoot_VF_MCC_LosPuntajesDeLosJugadoresSonLosSiguientes(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomás");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(diego);
        jugadores.add(tomas);

        String rutaDeLaPrueba = "Kahoots/KahootTest01.json";
        Kahoot kahoot = new Kahoot(jugadores, rutaDeLaPrueba);

        //Verdadero Falso
        kahoot.proximaRonda();

        Ronda rondaActiva = kahoot.getRondaActiva();

        rondaActiva.proximoJugador();
        Jugador diegoRonda1 = rondaActiva.getJugadorActivo();

        RespondedorPorDefecto respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Diego
        Opcion opcionDiego = new OpcionComun("Verdadero");
        List<Opcion> opcionesDiego = new ArrayList<>();
        opcionesDiego.add(opcionDiego);
        Eleccion eleccionDiego = new Eleccion(opcionesDiego);
        Bonificador bonificadorDiego = new Bonificador();
        Respuesta respuestaDiego = new Respuesta(diegoRonda1, eleccionDiego, bonificadorDiego);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaDiego);

        rondaActiva.proximoJugador();
        Jugador tomasRonda1 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Tomas
        Opcion opcionTomas = new OpcionComun("Falso");
        List<Opcion> opcionesTomas = new ArrayList<>();
        opcionesTomas.add(opcionTomas);
        Eleccion eleccionTomas = new Eleccion(opcionesTomas);
        Bonificador bonificadorTomas = new Bonificador();
        Respuesta respuestaTomas = new Respuesta(tomasRonda1, eleccionTomas, bonificadorTomas);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaTomas);

        assert(kahoot.jugadorConMasPuntos().equals(diegoRonda1));

        //Multiple Choice
        kahoot.proximaRonda();

        rondaActiva = kahoot.getRondaActiva();
        rondaActiva.proximoJugador();

        Jugador diegoRonda2 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Diego
        opcionDiego = new OpcionComun("Opcion incorrecta 1");
        opcionesDiego = new ArrayList<>();
        opcionesDiego.add(opcionDiego);
        eleccionDiego = new Eleccion(opcionesDiego);
        bonificadorDiego = new Bonificador();
        respuestaDiego = new Respuesta(diegoRonda2, eleccionDiego, bonificadorDiego);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaDiego);

        rondaActiva.proximoJugador();
        Jugador tomasRonda2 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Tomas
        opcionTomas = new OpcionComun("Opcion correcta 1");
        opcionesTomas = new ArrayList<>();
        opcionesTomas.add(opcionTomas);
        eleccionTomas = new Eleccion(opcionesTomas);
        bonificadorTomas = new Bonificador();
        respuestaTomas = new Respuesta(tomasRonda2, eleccionTomas, bonificadorTomas);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaTomas);

        jugadores = kahoot.terminarJuego();

        assertEquals(jugadores.get(0).getPuntos(), 1);
        assertEquals(jugadores.get(1).getPuntos(), 1);
    }

    @Test
    public void test02CuandoSeJuegaElSiguienteKahoot_MCP_MCPP_LosPuntajesDeLosJugadoresSonLosSiguientes(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomás");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(diego);
        jugadores.add(tomas);

        String rutaDeLaPrueba = "Kahoots/KahootTest02.json";
        Kahoot kahoot = new Kahoot(jugadores, rutaDeLaPrueba);

        //Multiple Choice con Penalidad
        kahoot.proximaRonda();

        Ronda rondaActiva = kahoot.getRondaActiva();

        rondaActiva.proximoJugador();
        Jugador diegoRonda1 = rondaActiva.getJugadorActivo();

        RespondedorPorDefecto respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Diego
        Opcion opcionDiego = new OpcionComun("Opcion correcta 1");
        List<Opcion> opcionesDiego = new ArrayList<>();
        opcionesDiego.add(opcionDiego);
        Eleccion eleccionDiego = new Eleccion(opcionesDiego);
        Bonificador bonificadorDiego = new Bonificador();
        Respuesta respuestaDiego = new Respuesta(diegoRonda1, eleccionDiego, bonificadorDiego);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaDiego);

        rondaActiva.proximoJugador();
        Jugador tomasRonda1 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Tomas
        Opcion opcionTomas = new OpcionComun("Opcion incorrecta 1");
        List<Opcion> opcionesTomas = new ArrayList<>();
        opcionesTomas.add(opcionTomas);
        Eleccion eleccionTomas = new Eleccion(opcionesTomas);
        Bonificador bonificadorTomas = new Bonificador();
        Respuesta respuestaTomas = new Respuesta(tomasRonda1, eleccionTomas, bonificadorTomas);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaTomas);

        assert(kahoot.jugadorConMasPuntos().equals(diegoRonda1));

        //Multiple Choice con Puntaje Parcial
        kahoot.proximaRonda();

        rondaActiva = kahoot.getRondaActiva();
        rondaActiva.proximoJugador();

        Jugador diegoRonda2 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Diego
        opcionDiego = new OpcionComun("Opcion correcta 1");
        opcionesDiego = new ArrayList<>();
        opcionesDiego.add(opcionDiego);
        eleccionDiego = new Eleccion(opcionesDiego);
        bonificadorDiego = new Bonificador();
        respuestaDiego = new Respuesta(diegoRonda2, eleccionDiego, bonificadorDiego);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaDiego);

        rondaActiva.proximoJugador();
        Jugador tomasRonda2 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Tomas
        opcionTomas = new OpcionComun("Opcion correcta 1");
        opcionesTomas = new ArrayList<>();
        opcionesTomas.add(opcionTomas);
        eleccionTomas = new Eleccion(opcionesTomas);
        bonificadorTomas = new Bonificador();
        respuestaTomas = new Respuesta(tomasRonda2, eleccionTomas, bonificadorTomas);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaTomas);

        jugadores = kahoot.terminarJuego();

        assertEquals(jugadores.get(0).getPuntos(), 2);
        assertEquals(jugadores.get(1).getPuntos(), 0);
    }

    @Test
    public void test03CuandoSeJuegaElSiguienteKahoot_GC_OC_VFCP_LosPuntajesDeLosJugadoresSonLosSiguientes(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomás");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(diego);
        jugadores.add(tomas);

        String rutaDeLaPrueba = "Kahoots/KahootTest03.json";
        Kahoot kahoot = new Kahoot(jugadores, rutaDeLaPrueba);

        //Group Choice
        kahoot.proximaRonda();

        Ronda rondaActiva = kahoot.getRondaActiva();

        rondaActiva.proximoJugador();
        Jugador diegoRonda1 = rondaActiva.getJugadorActivo();

        RespondedorPorDefecto respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Diego
        Opcion opcion1Diego = new OpcionDeGrupo("grupoA1", "A");
        Opcion opcion2Diego = new OpcionDeGrupo("grupoA2", "A");
        Opcion opcion3Diego = new OpcionDeGrupo("grupoB1", "B");
        Opcion opcion4Diego = new OpcionDeGrupo("grupoB2", "B");

        List<Opcion> opcionesDiego = new ArrayList<>();
        opcionesDiego.add(opcion1Diego);
        opcionesDiego.add(opcion2Diego);
        opcionesDiego.add(opcion3Diego);
        opcionesDiego.add(opcion4Diego);

        Eleccion eleccionDiego = new Eleccion(opcionesDiego);
        Bonificador bonificadorDiego = new Bonificador();
        Respuesta respuestaDiego = new Respuesta(diegoRonda1, eleccionDiego, bonificadorDiego);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaDiego);

        rondaActiva.proximoJugador();
        Jugador tomasRonda1 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Tomas
        List<Opcion> opcionesTomas = new ArrayList<>();
        Opcion opcion1Tomas = new OpcionDeGrupo("grupoA1", "A");
        Opcion opcion2Tomas = new OpcionDeGrupo("grupoA2", "A");
        Opcion opcion3Tomas = new OpcionDeGrupo("grupoB1", "A");
        Opcion opcion4Tomas = new OpcionDeGrupo("grupoB2", "B");

        opcionesTomas.add(opcion1Tomas);
        opcionesTomas.add(opcion2Tomas);
        opcionesTomas.add(opcion3Tomas);
        opcionesTomas.add(opcion4Tomas);

        Eleccion eleccionTomas = new Eleccion(opcionesTomas);
        Bonificador bonificadorTomas = new Bonificador();
        Respuesta respuestaTomas = new Respuesta(tomasRonda1, eleccionTomas, bonificadorTomas);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaTomas);

        assert(kahoot.jugadorConMasPuntos().equals(diegoRonda1));

        //Ordered Choice
        kahoot.proximaRonda();

        rondaActiva = kahoot.getRondaActiva();
        rondaActiva.proximoJugador();

        Jugador diegoRonda2 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Diego
        opcion1Diego = new OpcionOrdenada("Primera", 1);
        opcion2Diego = new OpcionOrdenada("Segunda", 2);
        opcion3Diego = new OpcionOrdenada("Tercera", 3);

        opcionesDiego = new ArrayList<>();
        opcionesDiego.add(opcion1Diego);
        opcionesDiego.add(opcion2Diego);
        opcionesDiego.add(opcion3Diego);

        eleccionDiego = new Eleccion(opcionesDiego);
        bonificadorDiego = new Bonificador();
        respuestaDiego = new Respuesta(diegoRonda2, eleccionDiego, bonificadorDiego);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaDiego);

        rondaActiva.proximoJugador();
        Jugador tomasRonda2 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Tomas
        opcionesTomas = new ArrayList<>();
        opcion1Tomas = new OpcionOrdenada("Primera", 1);
        opcion2Tomas = new OpcionOrdenada("Segunda", 2);
        opcion3Tomas = new OpcionOrdenada("Tercera", 3);

        opcionesTomas.add(opcion1Tomas);
        opcionesTomas.add(opcion2Tomas);
        opcionesTomas.add(opcion3Tomas);

        eleccionTomas = new Eleccion(opcionesTomas);
        bonificadorTomas = new Bonificador();
        respuestaTomas = new Respuesta(tomasRonda2, eleccionTomas, bonificadorTomas);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaTomas);

        //Verdadero Falso con Penalidad
        kahoot.proximaRonda();

        rondaActiva = kahoot.getRondaActiva();
        rondaActiva.proximoJugador();

        Jugador diegoRonda3 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Diego
        Opcion opcionDiego = new OpcionComun("Falso");
        opcionesDiego = new ArrayList<>();
        opcionesDiego.add(opcionDiego);

        eleccionDiego = new Eleccion(opcionesDiego);
        bonificadorDiego = new Bonificador();
        respuestaDiego = new Respuesta(diegoRonda3, eleccionDiego, bonificadorDiego);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaDiego);

        rondaActiva.proximoJugador();
        Jugador tomasRonda3 = rondaActiva.getJugadorActivo();

        respondedor = new RespondedorPorDefecto(rondaActiva);
        rondaActiva.jugadorVaAResponder(respondedor);

        //Respuesta de Tomas
        Opcion opcionTomas = new OpcionComun("Verdadero");
        opcionesTomas = new ArrayList<>();
        opcionesTomas.add(opcionTomas);
        eleccionTomas = new Eleccion(opcionesTomas);
        bonificadorTomas = new Bonificador();
        respuestaTomas = new Respuesta(tomasRonda3, eleccionTomas, bonificadorTomas);

        rondaActiva.jugadorYaRespondio();
        rondaActiva.agregarRespuesta(respuestaTomas);


        jugadores = kahoot.terminarJuego();

        assertEquals(jugadores.get(0).getPuntos(), 1);
        assertEquals(jugadores.get(1).getPuntos(), 2);
    }

}