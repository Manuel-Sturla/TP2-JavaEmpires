package Unidad;

import Mapa.Mapa;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArmaDeAsedioTest {

    @Test
    void inicioDeMontarARA(){
        ArmaDeAsedio ARA = new ArmaDeAsedio();
        ARA.montarArma();
        assertTrue(ARA.getEstaMontada());
    }

    @Test
    void inicioDeMontarADAyTraraDeMoverse(){

        Assertions.assertThrows(ArmaNoDesmontadaException.class, ()->{
            ArmaDeAsedio ARA = new ArmaDeAsedio();
            Mapa mapa = new Mapa();
            ARA.montarArma();
            ARA.moverHaciaDerecha(mapa);
        });
    }

}
