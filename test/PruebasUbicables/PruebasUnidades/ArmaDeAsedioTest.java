package PruebasUbicables.PruebasUnidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableEstaOcupadoException;
import Exceptions.UbicableFueraDeRangoException;
import Jugador.Faccion;
import Posiciones.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.ArmaDeAsedio;
import org.junit.jupiter.api.Test;
import Mapa.Mapa;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmaDeAsedioTest {

    @Test
    void crearArmaDeAsedioSeCreaCorrectamente() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        Faccion faccion = new Faccion();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.asignarFaccion(faccion);
        assertTrue(mapa.celdaEstaOcupada(posicion));
        assertTrue(faccion.perteneceFaccion(armaDeAsedio));
    }

    @Test
    public void creoUnArmaDeAsedioIniciaDesmontada() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,2,2);
        Posicion posicion1 = new Posicion(mapa, 3,2);
        Faccion faccion = new Faccion();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.moverDerecha();
        assertTrue(mapa.celdaEstaOcupada(posicion1));
    }

    @Test
    public void creoUnArmaDeAsedioSeMonta() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,2,2);
        Faccion faccion = new Faccion();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.montarArma();
        assertThrows(UbicableEstaOcupadoException.class ,()-> armaDeAsedio.moverDerecha());
    }

    @Test
    void moverArmaALaDerechaCuandoNoEstaMontadaALaMueve() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.moverDerecha();
        Posicion posicionLlegada = new Posicion(mapa, 4,3);
        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }
    
    @Test
    void moverArmaArribaADerechaCuandoNoEstaMontadaALaMueve() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.moverArribaDer();
        Posicion posicionLlegada = new Posicion(mapa, 4,4);
        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }

    @Test
    void moverArmaAbajoAIzquierdaCuandoNoEstaMontadaALaMueve() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.moverAbajoIzq();
        Posicion posicionLlegada = new Posicion(mapa, 2,2);
        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }

    @Test
    void moverArmaCuandoEstaMontadaNoSeMueve() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.montarArma();
        Posicion posicionLlegada = new Posicion(mapa, 4,3);
        assertTrue(!mapa.celdaEstaOcupada(posicionLlegada));
        assertTrue(mapa.celdaEstaOcupada(posicion));

    }

    @Test
    void atacarEdificioLeQuita75DeVida() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.montarArma();
        Faccion faccion = new Faccion();
        Faccion faccion2 = new Faccion();
        armaDeAsedio.asignarFaccion(faccion);

        Posicion posicion2 = new Posicion(mapa, 5,5);
        Cuartel cuartel = new Cuartel(posicion2, null);
        cuartel.asignarFaccion(faccion2);

        armaDeAsedio.atacar(cuartel);
        assertTrue(cuartel.getvida() == 175);

    }
/* Esta No se puede descomentar porque el metodo armaDeAsedio.atacer(Unidad) no esta implementado
    eso esta bien así (creo) porque no le permite al arma de asedio atacar unidades.

    @Test
    void atacerUnidadLevantaExcepcion() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        armaDeAsedio.montarArma();
        Faccion faccion = new Faccion();
        Faccion faccion2 = new Faccion();
        armaDeAsedio.asignarFaccion(faccion);

        Posicion posicion2 = new Posicion(mapa, 5,5);
        Aldeano aldeano = new Aldeano(posicion2, null);
        aldeano.asignarFaccion(faccion2);

        armaDeAsedio.atacar(aldeano);
    }*/

    @Test
    void atacarConArmaNoMontadaNoLeQuitaVida() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa, 3,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);

        Faccion faccion = new Faccion();
        Faccion faccion2 = new Faccion();
        armaDeAsedio.asignarFaccion(faccion);

        Posicion posicion2 = new Posicion(mapa, 5,5);
        Cuartel cuartel = new Cuartel(posicion2, null);
        cuartel.asignarFaccion(faccion2);

        armaDeAsedio.atacar(cuartel);
        assertTrue(cuartel.getvida() == 250);
    }

}
