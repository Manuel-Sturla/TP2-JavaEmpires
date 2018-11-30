package PruebasUbicables.PruebasUnidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableFueraDeRangoException;
import Jugador.Faccion;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArqueroTest {

    @Test
    void elArqueroAtacaAldeanoDeOtraFaccionADistancia1DeAtaque() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Mapa mapa = new Mapa(10,10);
        Posicion posarquero = new Posicion(mapa, 0,0);
        Posicion posAldeano = new Posicion(mapa, 1,0);
        Arquero arquero = new Arquero(posarquero);
        arquero.asignarFaccion(faccion1);
        Aldeano aldeanoEnemigo = new Aldeano(posAldeano, null);
        aldeanoEnemigo.asignarFaccion(faccion2);
        arquero.atacarUnidad(aldeanoEnemigo);
        assertTrue(aldeanoEnemigo.getVida() == 25); //No pasa esta prueba
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
            arquero.atacarUnidad(aldeano);
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
            arquero.atacarUnidad(aldeanoEnemigo);
        });
    }
}
