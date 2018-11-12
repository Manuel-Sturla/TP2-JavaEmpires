import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnidadTest {

    @Test
    void moverUnidadUnaPosicionTest() {
        Unidad unidad = new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad, 0,0);
        unidad.moverHaciaDerecha(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(1,0));
    }
}
