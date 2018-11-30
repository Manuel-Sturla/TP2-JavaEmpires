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
import javafx.geometry.Pos;
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

        Posicion posicionArmaDeAsedio = new Posicion(mapa, 0,1);
        castillo.crearArmaDeAsedio();
        assertThrows(UbicableEstaOcupadoException.class, castillo::crearArmaDeAsedio);

    }
}
