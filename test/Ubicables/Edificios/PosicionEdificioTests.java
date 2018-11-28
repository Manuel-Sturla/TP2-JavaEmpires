package Ubicables.Edificios;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Ubicables.Unidades.Aldeano;
import Ubicables.Ubicable;
import org.junit.jupiter.api.Test;
import Jugador.Faccion;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionEdificioTests {
    Faccion faccion = new Faccion();

    @Test
    void PosicionDeEdificioOcupaUnCuadradoDe4DeLado() throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 0, 0);
        PosicionEdificio posEdificio = new PosicionEdificio(posicion, 2);
        Ubicable ubicable = new Aldeano(posicion, faccion);
        posEdificio.ocuparPosiciones(ubicable);
        boolean check = true;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Posicion posMapa = new Posicion(mapa, 1, 0);
                if (!mapa.celdaEstaOcupada(posMapa)) {
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void crearEdificioCuandoNoHayEspacioLevantaExcepcion() throws PosicionFueraDeRangoException{
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 9, 0);
        assertThrows(PosicionFueraDeRangoException.class, ()-> new PosicionEdificio(posicion, 2));
    }

}
