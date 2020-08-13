package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.OpcionComun;
import edu.fiuba.algo3.modelo.OpcionDeGrupo;
import edu.fiuba.algo3.modelo.OpcionOrdenada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpcionOrdenadaTest {

    @Test
    public void test01DosOpcionesOrdenadasQuePoseenLaMismaInformacionYPoseenElMismoIndiceSonIguales(){

        //Enunciado = Grilla de Partida del gran premio de inglaterra 2020
        OpcionOrdenada unaOpcion = new OpcionOrdenada("Hamilton", 1);
        OpcionOrdenada otraOpcion = new OpcionOrdenada("Hamilton", 1);

        assertTrue(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test02DosOpcionesOrdenadasQuePoseenDistintaInformacionYDistintoIndiceSonDistintas(){

        //Enunciado = Grilla de Partida del gran premio de inglaterra 2020
        OpcionOrdenada unaOpcion = new OpcionOrdenada("Hamilton", 1);
        OpcionOrdenada otraOpcion = new OpcionOrdenada("Bottas", 2);

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test03DosOpcionesOrdenadasQuePoseenDistintaInformacionYMismoIndiceSonDistintas(){

        //Enunciado = Grilla de Partida del gran premio de inglaterra 2020
        OpcionOrdenada unaOpcion = new OpcionOrdenada("Hamilton", 1);
        OpcionOrdenada otraOpcion = new OpcionOrdenada("Bottas", 1);

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test04DosOpcionesOrdenadasQuePoseenMismaInformacionYDistintoIndiceSonDistintas(){

        //Enunciado = Grilla de Partida del gran premio de inglaterra 2020
        OpcionOrdenada unaOpcion = new OpcionOrdenada("Hamilton", 1);
        OpcionOrdenada otraOpcion = new OpcionOrdenada("Hamilton", 2);

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test05UnaOpcionOrdenadaYUnaOpcionComunNoSonIgualesAlNoPoseerElMismoIndice(){

        //Enunciado = Grilla de Partida del gran premio de inglaterra 2020
        OpcionOrdenada unaOpcion = new OpcionOrdenada("Hamilton", 1);
        OpcionComun otraOpcion = new OpcionComun("Hamilton");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test06UnaOpcionOrdenadaYUnaOpcionDeGrupoNoSonIgualesAlNoPoseerElMismoIndice(){

        //Enunciado = Grilla de Partida del gran premio de inglaterra 2020
        OpcionOrdenada unaOpcion = new OpcionOrdenada("Hamilton", 1);
        OpcionDeGrupo otraOpcion = new OpcionDeGrupo("Bottas", "Mercedes");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }
}
