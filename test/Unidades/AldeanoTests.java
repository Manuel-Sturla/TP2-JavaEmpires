package Unidades;

import Exceptions.MovimientoNoPermitidoException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AldeanoTests {

    @Test
    void crearAldeanoYUbicarloEnElMapaSeCreaCorrectamente() throws PosicionFueraDeRangoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion);
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }
    @Test
    void moverAldeanoHaciaLaDerechaOcupaLaNuevaPosicion() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        Posicion posicion2 = new Posicion(mapa, 2,1);
        assertTrue(mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    void moverAldeanoHaciaAbajoOcupaLaNuevaPosicion() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));;
    }
    @Test
    void moverAldeanoFueraDelMapaNoLoMueve() throws PosicionFueraDeRangoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 0,2);
        Aldeano aldeano = new Aldeano(posicion);
        assertThrows(MovimientoNoPermitidoException.class , ()-> {
            aldeano.moverIzquierda();
        });
    }
    @Test
    void moverAldeanoDesocupaLaPosicionInicial() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertFalse(mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverArriba();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaIzqVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverArribaIzq();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaDerVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverArribaDer();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoAbajoIzqVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverAbajoIzq();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoAbajoDerVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverAbajoDer();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
}
