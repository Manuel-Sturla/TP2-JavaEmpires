package PruebasUbicables.PruebasUnidades;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Jugador.Faccion;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.PlazaCentral;
import Modelo.Ubicables.Unidades.Espadachin;
import Modelo.Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EspadachinTest {

    @Test
    void elEspadachinAtacaAldeanoDeOtraFaccionEnRangoDeAtaque() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10,10);
        Posicion posEspadachin = new Posicion(mapa, 0,0);
        Posicion posAldeano = new Posicion(mapa, 1,0);
        Espadachin espadachin = new Espadachin(posEspadachin);
        espadachin.asignarFaccion(faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, null);
        aldeanoEnemigo.asignarFaccion(faccion2);
        espadachin.atacar(aldeanoEnemigo);
        assertTrue(aldeanoEnemigo.getVida() == 25); //No pasa esta prueba
    }

    @Test
    void elEspadachinNoAtacaAldeanoDeMismaFaccionEnRangoAtaque() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Faccion faccion = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posEspadachin = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 1, 0);
        Espadachin espadachin = new Espadachin(posEspadachin);
        espadachin.asignarFaccion(faccion);
        Aldeano aldeano = new Aldeano(posAldeano, null);
        aldeano.asignarFaccion(faccion);
        assertThrows(UbicableDeMismaFaccionException.class, () -> {
            espadachin.atacar(aldeano);
        });
    }

    @Test
    void elEspadachinNoAtacaAldeanoEnemigoFueraDeRangoYLevantaExcepcion() throws PosicionInvalidaException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posEspadachin = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 2, 0);
        Espadachin espadachin = new Espadachin(posEspadachin);
        espadachin.asignarFaccion(faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, null);
        aldeanoEnemigo.asignarFaccion(faccion2);

        assertThrows(UbicableFueraDeRangoException.class, () -> {
            espadachin.atacar(aldeanoEnemigo);
        });
    }

    @Test
    void atacarEdificioLeQuita10DeVida() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posEspadachin = new Posicion(mapa, 0, 0);
        Posicion posPlazaCentral = new Posicion(mapa, 1, 0);
        Espadachin espadachin = new Espadachin(posEspadachin);
        espadachin.asignarFaccion(faccion1);
        PlazaCentral plazaCentralEnemiga = new PlazaCentral(posPlazaCentral, null);
        plazaCentralEnemiga.asignarFaccion(faccion2);

        espadachin.atacar(plazaCentralEnemiga);

        assertTrue(plazaCentralEnemiga.getvida() == 435);
    }
}
