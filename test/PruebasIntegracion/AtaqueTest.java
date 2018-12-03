package PruebasIntegracion;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableFueraDeRangoException;
import Jugador.Faccion;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.ArmaDeAsedio;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Espadachin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(espadachin.estaOcupado());// no se pone como ocupado
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
}
