import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AldeanoTests {

    @Test
    void crearAldeanoYUbicarloEnElMapaSeCreaCorrectamente(){
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }

    @Test
    void moverAldeanoHaciaLaDerechaOcupaLaNuevaPosicion() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        Posicion posicion2 = new Posicion(mapa, 2,1);
        assertTrue(mapa.celdaEstaOcupada(posicion2));
    }

    @Test
    void moverAldeanoHaciaAbajoOcupaLaNuevaPosicion() throws PosicionNoDisponibleException, UbicableEstaOcupadoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,1);
        assertTrue(mapa.celdaEstaOcupada(posicion2) && !mapa.celdaEstaOcupada(posicion));;
    }

    @Test
    void moverAldeanoFueraDelMapaNoLoMueve() throws PosicionNoDisponibleException, UbicableEstaOcupadoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 0,2);
        Aldeano aldeano = new Aldeano(posicion);
        assertThrows(PosicionNoDisponibleException.class , ()-> {
            aldeano.moverIzquierda();
        });
    }

    @Test
    void moverAldeanoDesocupaLaPosicionInicial() throws PosicionNoDisponibleException, UbicableEstaOcupadoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertFalse(mapa.celdaEstaOcupada(posicion2));
    }

    //Faltan pruebas en algunas direcciones pero son equivalentes
    /*
    void contruirEdificioLoCrea
    */
}
