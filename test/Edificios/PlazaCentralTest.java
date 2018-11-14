package Edificios;

import Unidad.Aldeano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlazaCentralTest {
    @Test
    void CreoAldeano(){
        PlazaCentral PC = new PlazaCentral();
        Aldeano aldeano = PC.crearAldeano();
        assertTrue(aldeano != null);
    }
}