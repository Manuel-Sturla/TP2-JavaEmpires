package Tablero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CeldaAndCeldasAdyacentesTest {

    // PRUEBAS DE CELDA
    @Test
    void prueboCosntructorDeCelda(){
        Celda c = new Celda();
        assertTrue(c != null);
    }
    @Test
    void creoLaCeldaEstaDesocupada(){
        Celda c = new Celda();
        assertTrue(!c.estaOcupada());
    }
    @Test
    void ocupoUnaCelda(){
        Celda c = new Celda();
        c.ocuparCelda();
        assertTrue(c.estaOcupada());
    }

    //PRUEBAS DE CELDA ADYACENTE
    

}
