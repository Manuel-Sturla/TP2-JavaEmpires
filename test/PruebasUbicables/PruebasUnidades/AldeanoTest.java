package PruebasUbicables.PruebasUnidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Posiciones.Posicion;
import Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;
import Mapa.Mapa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AldeanoTest {
    @Test
    void crearAldeanoYUbicarloEnElMapaSeCreaCorrectamente() throws PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion, null);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }
    @Test
    void moverAldeanoHaciaLaDerechaOcupaLaNuevaPosicion() throws PosicionInvalidaException, UbicableEstaOcupadoException{
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverDerecha();
        Posicion posicion2 = new Posicion(mapa, 2,1);
        assertTrue(mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    void moverAldeanoHaciaAbajoOcupaLaNuevaPosicion() throws PosicionInvalidaException, UbicableEstaOcupadoException{
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));;
    }
    @Test
    void moverAldeanoFueraDelMapaNoLoMueve() throws PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 0,2);
        Aldeano aldeano = new Aldeano(posicion, null);
        assertThrows(PosicionInvalidaException.class , ()-> {
            aldeano.moverIzquierda();
        });
    }
    @Test
    void moverAldeanoDesocupaLaPosicionInicial() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 2,2);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverAbajo();
        Posicion posicion2 = new Posicion(mapa, 2,2);
        assertFalse(mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverArriba();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaIzqVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverArribaIzq();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoArribaDerVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverArribaDer();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoAbajoIzqVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverAbajoIzq();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }
    @Test
    public void testMoverAldeanoAbajoDerVerificaQueLaNuevaPosicionEsteOcupadaYLaAnteriorNo() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa  = new Mapa(3,3);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverAbajoDer();
        Posicion posicion2 = new Posicion(mapa, 1,1);
        assertTrue(mapa.celdaEstaOcupada(posicion) && !mapa.celdaEstaOcupada(posicion2));
    }

    @Test
    public void moverAldeanoOcupadoNoSeMueve() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa  = new Mapa(5,5);
        Posicion posicion = new Posicion(mapa, 3,3);
        Aldeano aldeano = new Aldeano(posicion, null);
        aldeano.moverIzquierda();
        try{
            aldeano.moverIzquierda();
        }catch (UbicableEstaOcupadoException e){}

        Posicion posicionChequeo = new Posicion(mapa, 2,3);
        assertTrue(mapa.celdaEstaOcupada(posicionChequeo));

    }
/*Hay que decidir como se va a hacer esto a nivel interfaz
    @Test
    public void aldaeanoCreaCuartelYNoEstaARangoDelAldeano() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,5,5);
        Posicion posicionConstruccion = new Posicion(mapa,1,1);
        null null = new null();
        Aldeano aldeano = new Aldeano(posicion,null);
        assertThrows( PosicionFueraDeRangoException.class , ()-> aldeano.aldaeanoCreaCuartel(posicionConstruccion));
    }
    @Test
    public void aldaeanoCreaCuartelALaIzquierdaDelAldeano() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,5,5);
        Posicion posicionConstruccion = new Posicion(mapa,4,5);
        null null = new null();
        Aldeano aldeano = new Aldeano(posicion,null);
        assertThrows( PosicionNoDisponibleException.class , ()-> aldeano.aldaeanoCreaCuartel(posicionConstruccion));
    }

    @Test
    public void aldeanoCreaCuartelDondeHayUnaTropa() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,5,5);
        Posicion posicionAldaeno1 = new Posicion(mapa,7,6);
        Posicion posicionConstruccion = new Posicion(mapa,6,5);
        null null = new null();
        Aldeano aldeano = new Aldeano(posicionAldeano,null);
        Aldeano aldeano1 = new Aldeano(posicionAldaeno1,null);
        assertThrows( PosicionNoDisponibleException.class , ()-> aldeano.aldaeanoCreaCuartel(posicionConstruccion));
        assertTrue(!mapa.celdaEstaOcupada(posicionConstruccion));
    }*/
}
