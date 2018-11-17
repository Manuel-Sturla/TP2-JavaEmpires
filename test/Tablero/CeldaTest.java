package Tablero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CeldaTest {

    @Test
    void prueboCosntructorDeCelda(){
        Celda c = new Celda(0, 0);
        assertTrue(c != null);
    }
    @Test
    void creoLaCeldaEstaDesocupada(){
        Celda c = new Celda(0, 0);
        assertTrue(!c.estaOcupada());
    }
    @Test
    void ocupoUnaCelda(){
        Celda c = new Celda(0, 0);
        c.ocuparCelda();
        assertTrue(c.estaOcupada());
    }
    @Test
    void prueboQueCeldaEsteBienUbicada(){
        Celda c = new Celda(0,0);
        Posicion p = c.getPoscion();
        int x1 = p.getCoordenadaHorizontal();
        int x2 = p.getCoordenadaVertical();
        assertTrue(x1 == 0 && x2 == 0);
    }

}
