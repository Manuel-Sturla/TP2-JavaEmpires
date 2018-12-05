package PruebasIntegracion;

import Modelo.Exceptions.FinDelJuego;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Jugador.Faccion;
import Modelo.Jugador.Jugador;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Cuartel;
import Modelo.Ubicables.Unidades.Aldeano;
import Modelo.Ubicables.Unidades.ArmaDeAsedio;
import Modelo.Ubicables.Unidades.Arquero;
import Modelo.Ubicables.Unidades.Espadachin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AtaqueTest {

    private Mapa mapa = new Mapa(50,50);
    private Posicion posicion = new Posicion(mapa,2,2);
    private Posicion posicion1 = new Posicion(mapa,2,3);
    private Faccion faccion = new Faccion();
    private Faccion faccion1 = new Faccion();

    @Test
    void atacarConUnEspadachin() throws PosicionInvalidaException, UbicableDeMismaFaccionException, UbicableFueraDeRangoException {
        Espadachin espadachin = new Espadachin(posicion);
        Arquero arquero = new Arquero(posicion1);

        espadachin.asignarFaccion (faccion);
        arquero.asignarFaccion(faccion1);


        espadachin.atacar(arquero);
        assertTrue(arquero.getvida() == 50);
        assertTrue(espadachin.estaOcupado());
    }

    @Test
    void atacarFueraDerangoConEspadachin() throws PosicionInvalidaException {
        Posicion posicion2 = new Posicion(mapa,8,8);
        Espadachin espadachin = new Espadachin(posicion);
        Arquero arquero = new Arquero(posicion2);
        espadachin.asignarFaccion (faccion);
        arquero.asignarFaccion(faccion1);
        assertThrows(UbicableFueraDeRangoException.class, ()-> espadachin.atacar(arquero));
    }

    @Test
    void atacoUnEdificioConUnArmaDeAsedio() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        Cuartel cuartel = new Cuartel(posicion1,null);
        armaDeAsedio.asignarFaccion(faccion);
        cuartel.asignarFaccion(faccion1);

        armaDeAsedio.montarArma();
        armaDeAsedio.atacar(cuartel);
        assertTrue(cuartel.getvida() == 175);
    }

    @Test
    void atacarUnCuartelConUnArmaDeAsedio4VecesLoMataYDesocupaEsaPosicion() throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        Posicion posicion2 = new Posicion(mapa,2,4);
        Posicion posicion3 = new Posicion(mapa,3,3);
        Posicion posicion4 = new Posicion(mapa,3,4);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
        Cuartel cuartel = new Cuartel(posicion1,null);
        armaDeAsedio.asignarFaccion(faccion);
        cuartel.asignarFaccion(faccion1);

        armaDeAsedio.montarArma();
        armaDeAsedio.atacar(cuartel);
        armaDeAsedio.atacar(cuartel);
        armaDeAsedio.atacar(cuartel);
        armaDeAsedio.atacar(cuartel);
        assertFalse(mapa.celdaEstaOcupada(posicion1));
        assertFalse(mapa.celdaEstaOcupada(posicion2));
        assertFalse(mapa.celdaEstaOcupada(posicion3));
        assertFalse(mapa.celdaEstaOcupada(posicion4));

    }

    @Test
    void atacarConUnEspadachinAUnArquero3VecesLoMataYSeDesocupaEsaPosicion() throws PosicionInvalidaException, UbicableDeMismaFaccionException, UbicableFueraDeRangoException {
        Arquero arquero = new Arquero(posicion);
        Espadachin espadachin = new Espadachin(posicion1);

        espadachin.asignarFaccion (faccion);

        arquero.asignarFaccion(faccion1);

        espadachin.atacar(arquero);
        espadachin.atacar(arquero);
        espadachin.atacar(arquero);
        assertFalse(mapa.celdaEstaOcupada(posicion));
    }

    @Test
    void aldeanoMuere() throws PosicionInvalidaException, FinDelJuego {
        Mapa mapa = new Mapa(40,30);
        Jugador jugador = new Jugador(mapa);
        jugador.inicializarJugador(1);
        Posicion posicion = new Posicion(mapa,7,10);

        assertTrue( jugador.getPoblacion() == 3);
        ArrayList aldeanos = jugador.obtenerAldeanos();
        Aldeano aldeano = (Aldeano) aldeanos.get(0);
        aldeano.recibirDanio(999);
        jugador.terminarTurno();
        jugador.iniciarTurno();
        assertEquals(2, jugador.getPoblacion());
    }

    @Test
    void muereAldeanoEnsegundoTurnoCobraMenosOro() throws PosicionInvalidaException, FinDelJuego {
        Mapa mapa = new Mapa(40,30);
        Jugador jugador = new Jugador(mapa);
        jugador.inicializarJugador(1);
        Posicion posicion = new Posicion(mapa,7,10);
        jugador.iniciarTurno();
        assertEquals( jugador.getOro() , 100);
        ArrayList aldeanos = jugador.obtenerAldeanos();
        Aldeano aldeano = (Aldeano) aldeanos.get(0);
        aldeano.recibirDanio(999);
        jugador.terminarTurno();
        jugador.iniciarTurno();

        assertEquals(jugador.getOro(),140);
    }
}
