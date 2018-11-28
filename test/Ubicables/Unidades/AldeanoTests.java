package Ubicables.Unidades;

import Exceptions.MovimientoNoPermitidoException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;
import Jugador.Faccion;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AldeanoTests {
    Faccion faccion = new Faccion();

    @Test
    void crearAldeanoYUbicarloEnElMapaSeCreaCorrectamente() throws PosicionFueraDeRangoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }
    @Test
    void moverAldeanoHaciaLaDerechaOcupaLaNuevaPosicion() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverDerecha();
        Posicion posicion2 = new Posicion(mapa, 2,1);
        assertTrue(mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    void moverAldeanoHaciaAbajoOcupaLaNuevaPosicion() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));;
    }
    @Test
    void moverAldeanoFueraDelMapaNoLoMueve() throws PosicionFueraDeRangoException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 0,2);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        assertThrows(MovimientoNoPermitidoException.class , ()-> {
            aldeano.moverIzquierda();
        });
    }
    @Test
    void moverAldeanoDesocupaLaPosicionInicial() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertFalse(mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverArriba();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaIzqVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverArribaIzq();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaDerVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverArribaDer();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoAbajoIzqVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverAbajoIzq();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoAbajoDerVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverAbajoDer();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }

    @Test
    public void moverAldeanoOcupadoNoMueveNoLoMueve() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, MovimientoNoPermitidoException, PosicionNoDisponibleException {
        Mapa mapa  = new Mapa(5,5);
        Posicion posicion = new Posicion(mapa, 3,3);
        Aldeano aldeano = new Aldeano(posicion, faccion);
        aldeano.moverIzquierda();
        try{
            aldeano.moverIzquierda();
        }catch (UbicableEstaOcupadoException e){}

        Posicion posicionChequeo = new Posicion(mapa, 2,3);
        assertTrue(mapa.celdaEstaOcupada(posicionChequeo));

    }

    @Test
    public void aldaeanoCreaCuartelYNoEstaARangoDelAldeano() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,5,5);
        Posicion posicionConstruccion = new Posicion(mapa,1,1);
        Faccion faccion = new Faccion();
        Aldeano aldeano = new Aldeano(posicion,faccion);
        assertThrows( PosicionFueraDeRangoException.class , ()-> aldeano.aldaeanoCreaCuartel(posicionConstruccion));
    }
    @Test
    public void aldaeanoCreaCuartelALaIzquierdaDelAldeano() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,5,5);
        Posicion posicionConstruccion = new Posicion(mapa,4,5);
        Faccion faccion = new Faccion();
        Aldeano aldeano = new Aldeano(posicion,faccion);
        assertThrows( PosicionFueraDeRangoException.class , ()-> aldeano.aldaeanoCreaCuartel(posicionConstruccion));
    }
}
