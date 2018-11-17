import Tablero.Mapa;
import Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AldeanoTest1 {

    @Test
    void elAldeanoSeMueveHaciaLaDerecha(){
        Mapa mapaAOE = new Mapa();
        Aldeano aldeano = new Aldeano(mapaAOE, 0 , 0);
        aldeano.moverAldeanoHaciaDerecha();
        assertTrue(mapaAOE.estaOcupadoElCasillero(1, 0));
    }
}
