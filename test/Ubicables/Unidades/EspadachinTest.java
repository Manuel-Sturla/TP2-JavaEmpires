package Ubicables.Unidades;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Unidades.Aldeano;
import Ubicables.Unidades.Espadachin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EspadachinTest {

    @Test
    void elEspadachinAtacaAldeanoDeOtraFaccionEnRangoDeAtaque() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10,10);
        Posicion posEspadachin = new Posicion(mapa, 0,0);
        Posicion posAldeano = new Posicion(mapa, 1,0);
        Espadachin espadachin = new Espadachin(posEspadachin, faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, faccion2);
        espadachin.atacarUnidad(aldeanoEnemigo);
        assertTrue(aldeanoEnemigo.getVida() == 25); //No pasa esta prueba
    }

    @Test
    void elEspadachinNoAtacaAldeanoDeMismaFaccionEnRangoAtaque() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Faccion faccion = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posEspadachin = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 1, 0);
        Espadachin espadachin = new Espadachin(posEspadachin, faccion);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, faccion);
        espadachin.atacarUnidad(aldeanoEnemigo);
        assertTrue(aldeanoEnemigo.getVida() == 50);
    }

    @Test
    void elEspadachinNoAtacaAldeanoEnemigoFueraDeRangoYLevantaExcepcion() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posEspadachin = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 2, 0);
        Espadachin espadachin = new Espadachin(posEspadachin, faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, faccion2);
        assertThrows(PosicionFueraDeRangoException.class, () -> {
            espadachin.atacarUnidad(aldeanoEnemigo);
        });
    }
}
