package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpcionComunTest {

    @Test
    public void test01DosOpcionesComunesQuePoseenLaMismaInformacionSonIguales(){

        //Enunciado = ¿Quien gano el gran premio de Austria de 2019?
        OpcionComun unaOpcion = new OpcionComun("Verstappen");
        OpcionComun otraOpcion = new OpcionComun("Verstappen");

        assertTrue(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test02DosOpcionesComunesQuePoseenDistintaInformacionSonDistintas(){

        //Enunciado = ¿Quien gano el gran premio de inglaterra de 2020?
        OpcionComun unaOpcion = new OpcionComun("Verstappen");
        OpcionComun otraOpcion = new OpcionComun("Hamilton");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test03CuandoAUnaOpcionComunSeLePideSiEsIgualAUnaOpcionDeGrupoSiPoseenLaMismaDescripcionLoSon() {


        OpcionComun unaOpcion = new OpcionComun("unaOpcion");
        OpcionDeGrupo otraOpcion = new OpcionDeGrupo("unaOpcion", "1");

        assertTrue(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test04CuandoAUnaOpcionComunSeLePideSiEsIgualAUnaOpcionDeGrupoSiPoseenDistintaDescripcionSonDistintas() {


        OpcionComun unaOpcion = new OpcionComun("unaOpcion");
        OpcionDeGrupo otraOpcion = new OpcionDeGrupo("otraOpcion", "1");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test05CuandoAUnaOpcionComunSeLePideSiEsIgualAUnaOpcionOrdenadaSiPoseenLaMismaDescripcionSonIguales() {


        OpcionComun unaOpcion = new OpcionComun("unaOpcion");
        OpcionOrdenada otraOpcion = new OpcionOrdenada("unaOpcion", 1);

        assertTrue(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test06CuandoAUnaOpcionComunSeLePideSiEsIgualAUnaOpcionOrdenadaSiPoseenDistintaDescripcionSonDistintas() {


        OpcionComun unaOpcion = new OpcionComun("unaOpcion");
        OpcionOrdenada otraOpcion = new OpcionOrdenada("otraOpcion", 1);

        assertFalse(unaOpcion.igualA(otraOpcion));
    }
}