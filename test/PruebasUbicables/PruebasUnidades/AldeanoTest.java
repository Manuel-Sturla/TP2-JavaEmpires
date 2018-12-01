package PruebasUbicables.PruebasUnidades;

import Exceptions.*;
import Jugador.Faccion;
import Posiciones.Posicion;
import Ubicables.Edificios.Cuartel;
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

    @Test
    void repararEdificioOcupaAlAldeano1TurnoCompleto() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 4, 3);

        Cuartel cuartel = new Cuartel(posicion2, null);
        Faccion faccion1 = new Faccion();
        aldeano.asignarFaccion(faccion1);
        cuartel.asignarFaccion(faccion1);

        cuartel.recibirDanio(50);
        aldeano.reparar(cuartel);
        assertTrue(aldeano.estaOcupado());
        aldeano.desocuparUnTurno();
        assertTrue(!aldeano.estaOcupado());

    }

    @Test
    void repararEdificioOcupaAlAldeano3TurnoCompletos() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        Mapa mapa = new Mapa(15, 15);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 4, 3);

        Cuartel cuartel = new Cuartel(posicion2, null);
        Faccion faccion1 = new Faccion();
        aldeano.asignarFaccion(faccion1);
        cuartel.asignarFaccion(faccion1);

        cuartel.recibirDanio(150);
        aldeano.reparar(cuartel);
        assertTrue(aldeano.estaOcupado());
        aldeano.desocuparUnTurno();
        assertTrue(aldeano.estaOcupado());
        aldeano.desocuparUnTurno();
        assertTrue(!aldeano.estaOcupado());

    }

    @Test
    void repararEdificioFueraDeRangoLevantaExcepcion() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(15, 15);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 10, 10);

        Cuartel cuartel = new Cuartel(posicion2, null);
        Faccion faccion1 = new Faccion();
        aldeano.asignarFaccion(faccion1);
        cuartel.asignarFaccion(faccion1);

        cuartel.recibirDanio(150);
        assertThrows(UbicableFueraDeRangoException.class, ()->aldeano.reparar(cuartel));
    }

    @Test
    void soloPuedeRepararUnAldeanoALaVez() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        Mapa mapa = new Mapa(15, 15);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 4, 3);

        Cuartel cuartel = new Cuartel(posicion2, null);
        Faccion faccion1 = new Faccion();
        aldeano.asignarFaccion(faccion1);
        cuartel.asignarFaccion(faccion1);

        cuartel.recibirDanio(150);
        aldeano.reparar(cuartel);

        Posicion posicion3 = new Posicion(mapa, 3, 4);
        Aldeano aldeano2 = new Aldeano(posicion3, null);

        aldeano2.reparar(cuartel);

        assertTrue(aldeano.estaOcupado());
        assertTrue(!aldeano2.estaOcupado());
    }

    @Test
    void luegoDeUnTurnoSoloPuedeSeguirReparandoElAldeanoQueLoComenzo() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        Mapa mapa = new Mapa(15, 15);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 4, 3);

        Cuartel cuartel = new Cuartel(posicion2, null);
        Faccion faccion1 = new Faccion();
        aldeano.asignarFaccion(faccion1);
        cuartel.asignarFaccion(faccion1);


        cuartel.recibirDanio(150);
        aldeano.reparar(cuartel);

        Posicion posicion3 = new Posicion(mapa, 3, 4);
        Aldeano aldeano2 = new Aldeano(posicion3, null);

        aldeano.desocuparUnTurno();
        aldeano2.desocuparUnTurno();
        cuartel.desocuparUnTurno();

        aldeano2.reparar(cuartel);
        assertTrue(aldeano.estaOcupado());
        assertTrue(!aldeano2.estaOcupado());
    }
    @Test
    void elEdificioSePuedeRepararPorOtroAldeanoSiElPrimeroDejoDeConstruir() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        Mapa mapa = new Mapa(15, 15);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 4, 3);

        Cuartel cuartel = new Cuartel(posicion2, null);
        Faccion faccion1 = new Faccion();
        aldeano.asignarFaccion(faccion1);
        cuartel.asignarFaccion(faccion1);


        cuartel.recibirDanio(50);
        aldeano.reparar(cuartel);

        Posicion posicion3 = new Posicion(mapa, 3, 4);
        Aldeano aldeano2 = new Aldeano(posicion3, null);

        aldeano2.asignarFaccion(faccion1);


        aldeano.desocuparUnTurno();
        aldeano2.desocuparUnTurno();
        cuartel.desocuparUnTurno();

        cuartel.recibirDanio(50);
        aldeano2.reparar(cuartel);
        assertTrue(!aldeano.estaOcupado());
        assertTrue(aldeano2.estaOcupado());
    }

    @Test
    void repararDosVecesNoCambiaLaVelocidadDeReparacion() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        Mapa mapa = new Mapa(15, 15);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 4, 3);
        Cuartel cuartel = new Cuartel(posicion2, null);
        Faccion faccion1 = new Faccion();
        aldeano.asignarFaccion(faccion1);
        cuartel.asignarFaccion(faccion1);


        cuartel.recibirDanio(150);
        aldeano.reparar(cuartel);
        assertTrue(cuartel.estaEnConstruccion());
        aldeano.desocuparUnTurno();
        aldeano.reparar(cuartel);
        assertTrue(cuartel.estaEnConstruccion());
        aldeano.desocuparUnTurno();
        aldeano.reparar(cuartel);
        assertTrue(!cuartel.estaEnConstruccion());
    }


    @Test
    void repararEdificioDeOtraFaccionNoEstaPermitido() throws PosicionInvalidaException, UbicableFueraDeRangoException {
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion, null);
        Posicion posicion2 = new Posicion(mapa, 4, 3);
        Cuartel cuartel = new Cuartel(posicion2, null);
        cuartel.recibirDanio(50);
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();

        aldeano.asignarFaccion(faccion1);
        aldeano.asignarFaccion(faccion2);



        assertThrows(UbicableDeOtraFaccionException.class,()->aldeano.reparar(cuartel));
        assertTrue(!aldeano.estaOcupado());

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
