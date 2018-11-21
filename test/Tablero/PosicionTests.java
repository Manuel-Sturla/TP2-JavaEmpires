import Exceptions.PosicionFueraDeRangoException;
import Tablero.Mapa;
import Tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTests {

    @Test
    void posicionOcupaUnEspacionEnElMapa() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 0, 0);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }
/*
    @Test
    void posicionMoverDerechaOcupaLaPosicionDerecha(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 0,0);
        posicion.moverDerecha();
        assertTrue(mapa.estaOcupado(1,0));
    }

    @Test
    void posicionMoverDerechaDesocupaLaPosicionOriginal(){
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 0,0);
        posicion.moverDerecha();
        assertFalse(mapa.estaOcupado(0,0));
    }

    @Test
    void posicionMoverAbajoDesocupaLaPosicionOriginal(){
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 1,1);
        posicion.moverAbajo();
        assertFalse(mapa.estaOcupado(0,0));
    }

    @Test
    void posicionMoverAbajoOcupaLaPosicionDeAbajo(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 1,1);
        posicion.moverAbajo();
        assertTrue(mapa.estaOcupado(1,0));
    }

    @Test
    void posicionMoverArribaDesocupaLaPosicionOriginal(){
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 0,0);
        posicion.moverArriba();
        assertFalse(mapa.estaOcupado(0,0));
    }

    @Test
    void posicionMoverArribaOcupaLaPosicionDeArriba(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 0,0);
        posicion.moverArriba();
        assertTrue(mapa.estaOcupado(0,1));
    }

    @Test
    void posicionMoverAfueraDelMapaLevantaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 0,0);
        assertThrows(PosicionFueraDeRangoException.class, ()-> {
            posicion.moverIzquierda();
        });
    }

    @Test
    void posicionCrearFueraDelMapaLevantaExcepcion(){
        Mapa mapa = new Mapa(10,10);

        assertThrows(PosicionFueraDeRangoException.class, ()-> {
            Posicion posicion = new Posicion(mapa, -1,0);
        });
    }
*/
    //Falta diagonal y algunos casos mas de arriba abajo,derecha, izq.

}
