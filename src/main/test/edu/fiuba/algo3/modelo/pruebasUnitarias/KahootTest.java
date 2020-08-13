package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

public class KahootTest {

    @Test
    public void test01UnKahootCreadoAPartirDeUnaPreguntaDeVerdaderoFalsoCuandoSeLePideElTipoCoincideConElDeUnVerdaderoFalso(){

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

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

        Kahoot kahoot = new Kahoot(jugadores, pregunta);

        kahoot.siguienteRonda();
        assertEquals(Kahoot.VERDADERO_FALSO, kahoot.tipoDePregunta());
    }

    @Test
    public void test02UnKahootCreadoAPartirDeUnaPreguntaDeVerdaderoFalsoConPenalidadCuandoSeLePideElTipoCoincideConElDeUnVerdaderoFalsoConPenalidad(){

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        String enunciado = "Diego es pintorRodillo (?";
        Opcion solucion = new OpcionComun("Verdadero");
        Opcion opcionIncorrecta = new OpcionComun("Falso");

        List<Opcion> opcionCorrecta = new ArrayList<Opcion>();
        opcionCorrecta.add(solucion);
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionIncorrecta);
        opciones.add(solucion);
        TipoDePregunta tipoVerdaderoFalso = new VerdaderoFalsoConPenalidad(opcionCorrecta);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoVerdaderoFalso);

        Kahoot kahoot = new Kahoot(jugadores, pregunta);

        kahoot.siguienteRonda();
        assertEquals(Kahoot.VERDADERO_FALSO_CON_PENALIDAD, kahoot.tipoDePregunta());
    }

    @Test
    public void test03UnKahootCreadoAPartirDeUnaPreguntaDeMultipleChoiceClasicoCuandoSeLePideElTipoCoincideConElDeUnMultipleChoiceClasico(){

        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);
        jugadores.add(pablo);

        //Se asume que venían jugando de antes y que los puntos que tiene son los siguientes
        //De manera tal que, se pueda corroborar el comportamiento deseado
        diego.asignarPuntos(3);
        tomas.asignarPuntos(6);
        pablo.asignarPuntos(5);

        String enunciado = "¿Cuáles son lunas de Jupiter?";

        Opcion opcion1 = new OpcionComun("Ío");
        Opcion opcion2 = new OpcionComun("Caronte");
        Opcion opcion3 = new OpcionComun("Ganímedes");
        Opcion opcion4 = new OpcionComun("Titán");
        Opcion opcion5 = new OpcionComun("Europa");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion5);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);


        TipoDePregunta tipoMultipleChoiceClasico = new MultipleChoiceClasico(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceClasico);

        Kahoot kahoot = new Kahoot(jugadores, pregunta);

        kahoot.siguienteRonda();
        assertEquals(Kahoot.MULTIPLE_CHOICE_CLASICO, kahoot.tipoDePregunta());
    }

    @Test
    public void test04UnKahootCreadoAPartirDeUnaPreguntaDeMultipleChoicePuntajeParcialCuandoSeLePideElTipoCoincideConElDeUnMultipleChoicePuntajeParcial(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo M");
        Jugador edson = new Jugador("Edson");

        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);
        jugadores.add(pablo);
        jugadores.add(edson);

        String enunciado = "¿Qué temas se dan en Física II?";

        Opcion opcion1 = new OpcionComun("Induccion magnetica");
        Opcion opcion2 = new OpcionComun("Fuerza De Lorenz");
        Opcion opcion3 = new OpcionComun("Diferenciacion");
        Opcion opcion4 = new OpcionComun("Cuerpo Rigido");

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);


        TipoDePregunta tipoMultipleChoicePuntajeParcial = new MultipleChoicePuntajeParcial(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoicePuntajeParcial);

        Kahoot kahoot = new Kahoot(jugadores, pregunta);

        kahoot.siguienteRonda();
        assertEquals(Kahoot.MULTIPLE_CHOICE_PUNTAJE_PARCIAL, kahoot.tipoDePregunta());
    }

    @Test
    public void test05UnKahootCreadoAPartirDeUnaPreguntaDeMultipleChoiceConPenalidadCuandoSeLePideElTipoCoincideConElDeUnMultipleChoiceConPenalidad(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        Jugador pablo = new Jugador("Pablo");
        Jugador edson = new Jugador("Edson");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);
        jugadores.add(pablo);
        jugadores.add(edson);


        String enunciado = "¿Cuáles son personajes de Disney?";

        Opcion opcion1 = new OpcionComun("Mulán");
        Opcion opcion2 = new OpcionComun("Katara");
        Opcion opcion3 = new OpcionComun("Ariel");
        Opcion opcion4 = new OpcionComun("Mérida");
        Opcion opcion5 = new OpcionComun("Chihiro");


        // Crea el tipo de pregunta y su elección correcta.
        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion3);
        solucion.add(opcion4);

        TipoDePregunta tipoMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(solucion);

        // Crea opciones de la pregunta.
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, tipoMultipleChoiceConPenalidad);

        Kahoot kahoot = new Kahoot(jugadores, pregunta);

        kahoot.siguienteRonda();
        assertEquals(Kahoot.MULTIPLE_CHOICE_CON_PENALIDAD, kahoot.tipoDePregunta());

    }

    @Test
    public void test06UnKahootCreadoAPartirDeUnaPreguntaDeOrderedChoiceCuandoSeLePideElTipoCoincideConElDeUnOrderedChoice(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        String enunciado = "Situar cronologicamente";

        Opcion opcion1 = new OpcionOrdenada("Huevo", 1);
        Opcion opcion2 = new OpcionOrdenada("Gallina", 2);

        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        TipoDePregunta orderedChoice = new OrderedChoice(solucion);
        Pregunta pregunta = new Pregunta(enunciado, opciones, orderedChoice);

        Kahoot kahoot = new Kahoot(jugadores, pregunta);

        kahoot.siguienteRonda();
        assertEquals(Kahoot.ORDERED_CHOICE, kahoot.tipoDePregunta());
    }

    @Test
    public void test07UnKahootCreadoAPartirDeUnaPreguntaDeGroupChoiceCuandoSeLePideElTipoCoincideConElDeUnGroupChoice(){
        Jugador diego = new Jugador("Diego");
        Jugador tomas = new Jugador("Tomas");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(diego);
        jugadores.add(tomas);

        String enunciado = new String(" Grupo A: Pilotos de F1 con mas de 1 DWC | Grupo B: Pilotos de F1 con 1 DWC");
        Opcion opcion1 = new OpcionDeGrupo("Niki Lauda", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion2 = new OpcionDeGrupo("Nico Rosberg", "Pilotos de F1 con 1 DWC");
        Opcion opcion3 = new OpcionDeGrupo("Lewis Hamilton", "Pilotos de F1 con mas de 1 DWC");
        Opcion opcion4 = new OpcionDeGrupo("Damon Hill", "Pilotos de F1 con 1 DWC");
        Opcion opcion5 = new OpcionDeGrupo("Fernando Alonso", "Pilotos de F1 con mas de 1 DWC");


        List<Opcion> solucion = new ArrayList<Opcion>();
        solucion.add(opcion1);
        solucion.add(opcion2);
        solucion.add(opcion3);
        solucion.add(opcion4);
        solucion.add(opcion5);

        TipoDePregunta groupChoice = new GroupChoice(solucion);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        Pregunta pregunta = new Pregunta(enunciado, opciones, groupChoice);

    }

}
