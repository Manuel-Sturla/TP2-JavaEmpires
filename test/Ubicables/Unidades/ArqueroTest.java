package Ubicables.Unidades;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Unidades.Aldeano;
import Ubicables.Unidades.Arquero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArqueroTest {

    @Test
    void elArqueroAtacaAldeanoDeOtraFaccionADistancia1DeAtaque() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
            Faccion faccion1 = new Faccion();
            Faccion faccion2 = new Faccion();
            Mapa mapa = new Mapa(10,10);
            Posicion posarquero = new Posicion(mapa, 0,0);
            Posicion posAldeano = new Posicion(mapa, 1,0);
            Arquero arquero = new Arquero(posarquero, faccion1);
            Aldeano aldeanoEnemigo = new Aldeano(posAldeano, faccion2);
            arquero.atacarUnidad(aldeanoEnemigo);
            assertTrue(aldeanoEnemigo.getVida() == 25); //No pasa esta prueba
    }

    @Test
    void elarqueroNoAtacaAldeanoDeMismaFaccionEnRangoAtaque() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Faccion faccion = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posarquero = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 1, 0);
        Arquero arquero = new Arquero(posarquero, faccion);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, faccion);
        arquero.atacarUnidad(aldeanoEnemigo);
        assertTrue(aldeanoEnemigo.getVida() == 50);
    }

    @Test
    void elarqueroNoAtacaAldeanoEnemigoFueraDeRangoYLevantaExcepcion() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10, 10);
        Posicion posarquero = new Posicion(mapa, 0, 0);
        Posicion posAldeano = new Posicion(mapa, 4, 0);
        Arquero arquero = new Arquero(posarquero, faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, faccion2);
        assertThrows(PosicionFueraDeRangoException.class, () -> {
            arquero.atacarUnidad(aldeanoEnemigo);
        });
    }

}
