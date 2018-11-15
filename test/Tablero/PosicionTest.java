package Tablero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {
    Mapa m = new Mapa();

    @Test
    void creoPosicionYSusCordenadasSonCorrectas(){
        Posicion p = new Posicion(m,0,0);
        assertTrue(p != null);
        assertTrue(p.getCoordenadaHorizontal() == 0 && p.getCoordenadVertical() == 0);
    }


}
