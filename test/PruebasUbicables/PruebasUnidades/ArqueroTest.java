package PruebasUbicables.PruebasUnidades;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Jugador.Faccion;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.PlazaCentral;
import Modelo.Ubicables.Unidades.Arquero;
import Modelo.Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArqueroTest {

    @Test
    void elArqueroAtacaAldeanoDeOtraFaccionADistancia1DeAtaque() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10,10);
        Posicion posAquero = new Posicion(mapa, 0,0);
        Posicion posAldeano = new Posicion(mapa, 1,0);
        Arquero arquero = new Arquero(posAquero);
        arquero.asignarFaccion(faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, null);
        aldeanoEnemigo.asignarFaccion(faccion2);
        arquero.atacar(aldeanoEnemigo);
        assertTrue(aldeanoEnemigo.getVida() == 35); //No pasa esta prueba
    }

    @Test
    void elarqueroNoAtacaAldeanoDeMismaFaccionEnRangoAtaque() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Faccion faccion = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posarquero = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 1, 0);
        Arquero arquero = new Arquero(posarquero);
        arquero.asignarFaccion(faccion);
        Aldeano aldeano = new Aldeano(posAldeano, null);
        aldeano.asignarFaccion(faccion);
        assertThrows(UbicableDeMismaFaccionException.class, () -> {
            arquero.atacar(aldeano);
        });
    }

    @Test
    void elarqueroNoAtacaAldeanoEnemigoFueraDeRangoYLevantaExcepcion() throws PosicionInvalidaException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posarquero = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 4, 0);
        Arquero arquero = new Arquero(posarquero);
        arquero.asignarFaccion(faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, null);
        aldeanoEnemigo.asignarFaccion(faccion2);
        assertThrows(UbicableFueraDeRangoException.class, () -> {
            arquero.atacar(aldeanoEnemigo);
        });
    }

    @Test
    void atacarEdificioLeQuita10DeVida() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posarquero = new Posicion(mapa, 0, 0);
        Posicion posPlazaCentral = new Posicion(mapa, 3, 0);
        Arquero arquero = new Arquero(posarquero);
        arquero.asignarFaccion(faccion1);
        PlazaCentral plazaCentralEnemiga = new PlazaCentral(posPlazaCentral, null);
        plazaCentralEnemiga.asignarFaccion(faccion2);

        arquero.atacar(plazaCentralEnemiga);

        assertTrue(plazaCentralEnemiga.getvida() == 440);
    }
}
