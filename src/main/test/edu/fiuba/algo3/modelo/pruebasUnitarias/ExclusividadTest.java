package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExclusividadTest {

    @Test
    public void test01ExclusividadRecibeUnaListaDeRespuestaYActualizaSusPuntajes(){

        Exclusividad exclusividad = new Exclusividad();

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta mockRespuesta1 = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        respuestas.add(mockRespuesta1);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        exclusividad.asignarPuntos(respuestas);

        verify(mockRespuesta1, times(1)).actualizarPuntaje();
        verify(mockRespuesta2, times(1)).actualizarPuntaje();
        verify(mockRespuesta3, times(1)).actualizarPuntaje();
    }

    @Test
    public void test02ExclusividadUpgradeadaRecibeUnaListaDeRespuestasConUnaCorrectaYLeActualizaSusPuntos(){

        Exclusividad exclusividad = new Exclusividad();
        exclusividad.mejorarExclusividad();

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta mockRespuesta1 = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        when(mockRespuesta1.respuestaCorrecta()).thenReturn(false);
        when(mockRespuesta2.respuestaCorrecta()).thenReturn(true);
        when(mockRespuesta3.respuestaCorrecta()).thenReturn(false);
        respuestas.add(mockRespuesta1);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        exclusividad.asignarPuntos(respuestas);

        verify(mockRespuesta1, times(1)).cambiarBonificador(0);
        verify(mockRespuesta2, times(2)).cambiarBonificador(any(Integer.class));
        verify(mockRespuesta3, times(1)).cambiarBonificador(0);
    }

    @Test
    public void test03ExclusividadUpgradeadaRecibeUnaListaDeRespuestasConDosCorrectaYNoLesActualizaSusPuntos(){

        Exclusividad exclusividad = new Exclusividad();
        exclusividad.mejorarExclusividad();

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta mockRespuesta1 = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        when(mockRespuesta1.respuestaCorrecta()).thenReturn(true);
        when(mockRespuesta2.respuestaCorrecta()).thenReturn(true);
        when(mockRespuesta3.respuestaCorrecta()).thenReturn(false);
        respuestas.add(mockRespuesta1);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        exclusividad.asignarPuntos(respuestas);

        verify(mockRespuesta1, times(1)).cambiarBonificador(0);
        verify(mockRespuesta2, times(1)).cambiarBonificador(0);
        verify(mockRespuesta3, times(1)).cambiarBonificador(0);
    }

    @Test
    public void test04ExclusividadUpgradeadaRecibeUnaListaDeRespuestasConCeroCorrectaYNoLesActualizaSusPuntos(){

        Exclusividad exclusividad = new Exclusividad();
        exclusividad.mejorarExclusividad();

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta mockRespuesta1 = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        when(mockRespuesta1.respuestaCorrecta()).thenReturn(false);
        when(mockRespuesta2.respuestaCorrecta()).thenReturn(false);
        when(mockRespuesta3.respuestaCorrecta()).thenReturn(false);
        respuestas.add(mockRespuesta1);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        exclusividad.asignarPuntos(respuestas);

        verify(mockRespuesta1, times(1)).cambiarBonificador(0);
        verify(mockRespuesta2, times(1)).cambiarBonificador(0);
        verify(mockRespuesta3, times(1)).cambiarBonificador(0);
    }

    @Test
    public void test05ExclusividadUpgradeadaDosVecesRecibeUnaListaDeRespuestasConUnaCorrectaYLeActualizaSusPuntos(){
        Exclusividad exclusividad = new Exclusividad();
        exclusividad.mejorarExclusividad();
        exclusividad.mejorarExclusividad();

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta mockRespuesta1 = mock(Respuesta.class);
        Respuesta mockRespuesta2 = mock(Respuesta.class);
        Respuesta mockRespuesta3 = mock(Respuesta.class);
        when(mockRespuesta1.respuestaCorrecta()).thenReturn(false);
        when(mockRespuesta2.respuestaCorrecta()).thenReturn(true);
        when(mockRespuesta3.respuestaCorrecta()).thenReturn(false);
        respuestas.add(mockRespuesta1);
        respuestas.add(mockRespuesta2);
        respuestas.add(mockRespuesta3);

        exclusividad.asignarPuntos(respuestas);

        verify(mockRespuesta1, times(1)).cambiarBonificador(0);
        verify(mockRespuesta2, times(2)).cambiarBonificador(any(Integer.class));
        verify(mockRespuesta3, times(1)).cambiarBonificador(0);
    }
}
