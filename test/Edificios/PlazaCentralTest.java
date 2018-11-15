package Edificios;

import Tablero.*;
import Unidades.Aldeano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlazaCentralTest {
    @Test
    void CreoAldeano(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,0,0);
        PlazaCentral PC = new PlazaCentral(p);
        assertTrue(PC.crearAldeano());
    }
}