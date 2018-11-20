package EdificioTests;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Edificios.Castillo;
import org.junit.jupiter.api.Test;

public class CastilloTests {

    @Test
    void crearCastilloOcupa16CeldasEnElMapa() throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicion = new Posicion(mapa, 0,0);
        Castillo castillo = new Castillo(posicion);
        boolean check = true;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Posicion posMapa = new Posicion(mapa, 1, 0);
                if(!mapa.celdaEstaOcupada(posMapa)){
                    check = false;
                }
            }
        }
    }


}
