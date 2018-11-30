package PruebasUbicables.PruebasUnidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Posiciones.Posicion;
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

}
