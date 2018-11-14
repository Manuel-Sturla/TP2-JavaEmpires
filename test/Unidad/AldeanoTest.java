package Unidad;

import Edificios.Cuartel;
import Mapa.ElementoFueraDeRangoException;
import Mapa.Mapa;
import org.junit.jupiter.api.Test;
public class AldeanoTest {

    @Test
    void repararEdificioNoContiguoLevantaExcepcion(){
        Mapa mapa = new Mapa();
        Aldeano aldeano = new Aldeano;
        mapa.agregarElementoDeMapa(aldeano, 1,1);
        Cuartel cuartel = new Cuartel;
        mapa.agregarElementoDeMapa(cuartel, 5,5);

        assertThrows(ElementoFueraDeRangoException.class,()->{
            aldeano.repararEdificio(cuartel);
        });
    }
}
