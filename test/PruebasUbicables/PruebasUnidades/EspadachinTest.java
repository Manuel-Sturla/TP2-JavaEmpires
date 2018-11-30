package PruebasUbicables.PruebasUnidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableFueraDeRangoException;
import Jugador.Faccion;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Unidades.Espadachin;
import Ubicables.Unidades.Aldeano;
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
        espadachin.atacarUnidad(aldeanoEnemigo);
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
            espadachin.atacarUnidad(aldeano);
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
            espadachin.atacarUnidad(aldeanoEnemigo);
        });
    }
}