package PruebasUbicables.PruebasEdificios;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Banco;
import Jugador.ConstructorDeUbicables;
import Jugador.Faccion;
import Jugador.Poblacion;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Edificios.Castillo;
import Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CastilloTest {

    @Test
    void crearCastilloOcupa16CeldasEnElMapa() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicion = new Posicion(mapa, 0,0);
        ConstructorDeUbicables constructor = new ConstructorDeUbicables(null, null);
        Castillo castillo = new Castillo(posicion, constructor);
        boolean check = true;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Posicion posMapa = new Posicion(mapa, 1, 0);
                if(!mapa.celdaEstaOcupada(posMapa)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void crearArmaDeAsedioLaCrea() throws PosicionInvalidaException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Banco banco = new Banco(200);
        Poblacion poblacion = new Poblacion();
        ConstructorDeUbicables constructor = new ConstructorDeUbicables(banco, poblacion);

        Posicion posicion = new Posicion(mapa, 1,0);
        Castillo castillo = new Castillo(posicion, constructor);
        castillo.asignarFaccion(faccion);

        Posicion posicionArmaDeAsedio = new Posicion(mapa, 0,1);
        castillo.crearArmaDeAsedio();
        assertTrue(mapa.celdaEstaOcupada((posicionArmaDeAsedio)));

    }

    @Test
    void crear2ArmasDeAsedioEnElMismoTurnoLevantaExcepcionPorqueEstaOcupado() throws PosicionInvalidaException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Banco banco = new Banco(200);
        Poblacion poblacion = new Poblacion();
        ConstructorDeUbicables constructor = new ConstructorDeUbicables(banco, poblacion);

        Posicion posicion = new Posicion(mapa, 1,0);
        Castillo castillo = new Castillo(posicion, constructor);
        castillo.asignarFaccion(faccion);


        castillo.crearArmaDeAsedio();
        assertThrows(UbicableEstaOcupadoException.class, castillo::crearArmaDeAsedio);

    }

    @Test
    void atacarAUnaUnidadEnemigaLeQuita20DeVida() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Faccion faccion2 = new Faccion();
        Posicion posicion = new Posicion(mapa, 1,0);
        Posicion posicion2 = new Posicion(mapa, 0,0);
        Castillo castillo = new Castillo(posicion, null);
        castillo.asignarFaccion(faccion);

        Aldeano aldeano = new Aldeano(posicion2, null);
        aldeano.asignarFaccion(faccion2);
        castillo.atacar();
        assertTrue(aldeano.getVida()==30);
    }

    @Test
    void atacarNoAtacaAUnidadAliada() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Posicion posicion = new Posicion(mapa, 1,0);
        Posicion posicion2 = new Posicion(mapa, 0,0);
        Castillo castillo = new Castillo(posicion, null);
        castillo.asignarFaccion(faccion);

        Aldeano aldeano = new Aldeano(posicion2, null);
        aldeano.asignarFaccion(faccion);
        castillo.atacar();
        assertTrue(aldeano.getVida()==50);
    }

    @Test
    void atacarAtacaEnElRangoCorrecto() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Faccion faccion2 = new Faccion();
        Posicion posicion = new Posicion(mapa, 0,0);
        Posicion posicion2 = new Posicion(mapa, 6,0);
        Posicion posicion3 = new Posicion(mapa, 7,0);
        Castillo castillo = new Castillo(posicion, null);
        castillo.asignarFaccion(faccion);

        Aldeano aldeano = new Aldeano(posicion2, null);
        Aldeano aldeano2 = new Aldeano(posicion3, null);

        aldeano.asignarFaccion(faccion2);
        aldeano2.asignarFaccion(faccion2);
        castillo.atacar();
        assertTrue(aldeano.getVida()==30);
        assertTrue(aldeano2.getVida()==50);
    }


}
