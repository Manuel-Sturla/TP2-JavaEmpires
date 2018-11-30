package PruebasUbicables.PruebasEdificios;

import Exceptions.PosicionInvalidaException;
import Jugador.ConstructorDeUbicables;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Edificios.Castillo;
import org.junit.jupiter.api.Test;

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
}
