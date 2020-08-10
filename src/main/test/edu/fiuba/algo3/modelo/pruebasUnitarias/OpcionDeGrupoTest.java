package edu.fiuba.algo3.modelo.pruebasUnitarias;

import edu.fiuba.algo3.modelo.OpcionComun;
import edu.fiuba.algo3.modelo.OpcionDeGrupo;
import edu.fiuba.algo3.modelo.OpcionOrdenada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpcionDeGrupoTest {

    @Test
    public void test01DosOpcionesDeGrupoQuePoseenLaMismaInformacionYPertenecenAlMismoGrupoSonIguales(){

        //Enunciado = A que grupo pertenecen estos motores
        //Grupos = Motores Rotativos | Motores a piston
        OpcionDeGrupo unaOpcion = new OpcionDeGrupo("Wankel de 3 rotores", "Rotativos");
        OpcionDeGrupo otraOpcion = new OpcionDeGrupo("Wankel de 3 rotores", "Rotativos");

        assertTrue(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test02DosOpcionesDeGrupoQuePoseenDistintaInformacionYNoPertenecenAlMismoGrupoSonDistintas(){

        //Enunciado = A que grupo pertenecen estos motores
        //Grupos = Motores Rotativos | Motores a piston
        OpcionDeGrupo unaOpcion = new OpcionDeGrupo("Wankel de 3 rotores", "Rotativos");
        OpcionDeGrupo otraOpcion = new OpcionDeGrupo("6 - en linea", "Piston");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test03DosOpcionesDeGrupoQuePoseenDistintaInformacionPeroMismoGrupoSonDistintas(){

        //Enunciado = Poner en el grupo correcto los autos
        //Grupos = Autos para repartir Tofu | Autos comunes
        OpcionDeGrupo unaOpcion = new OpcionDeGrupo("AE86", "Tofu");
        OpcionDeGrupo otraOpcion = new OpcionDeGrupo("Subaru Imprezza", "Tofu");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test04DosOpcionesDeGrupoQuePoseenIgualInformacionPeroDistintoGrupoSonDistintas(){

        //Enunciado = Poner en el grupo correcto los autos
        //Grupos = Autos para repartir Tofu | Autos comunes
        OpcionDeGrupo unaOpcion = new OpcionDeGrupo("Subaru Imprezza", "Tofu");
        OpcionDeGrupo otraOpcion = new OpcionDeGrupo("Subaru Imprezza", "Comun");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test05UnaOpcionDeGrupoYUnaOpcionComunQuePoseenIgualInformacionPeroDistintoGrupoSonDistintas(){

        //Enunciado = Poner en el grupo correcto los autos
        //Grupos = Autos para repartir Tofu | Autos comunes
        OpcionDeGrupo unaOpcion = new OpcionDeGrupo("Subaru Imprezza", "Tofu");
        OpcionComun otraOpcion = new OpcionComun("Subaru Imprezza");

        assertFalse(unaOpcion.igualA(otraOpcion));
    }

    @Test
    public void test06UnaOpcionDeGrupoYUnaOpcionOrdenadaQuePoseenIgualInformacionPeroDistintoGrupoSonDistintas(){

        //Enunciado = Poner en el grupo correcto los autos
        //Grupos = Autos para repartir Tofu | Autos comunes
        OpcionDeGrupo unaOpcion = new OpcionDeGrupo("Subaru Imprezza", "Tofu");
        OpcionOrdenada otraOpcion = new OpcionOrdenada("Subaru Imprezza", 1);

        assertFalse(unaOpcion.igualA(otraOpcion));
    }



}
