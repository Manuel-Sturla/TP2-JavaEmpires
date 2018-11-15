package Unidades;

import Tablero.Mapa;
import Tablero.Posicion;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArmaDeAsedioTest {

    @Test
    void inicioDeMontarARA(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,0,0);
        ArmaDeAsedio ARA = new ArmaDeAsedio(p);
        ARA.montarArma();
        assertTrue(ARA.getEstaMontada());
    }
/*
    @Test
    void inicioDeMontarADAyTraraDeMoverse(){

        Assertions.assertThrows(ArmaNoDesmontadaException.class, ()->{
            ArmaDeAsedio ARA = new ArmaDeAsedio();
            Mapa mapa = new Mapa();
            ARA.montarArma();
            ARA.moverHaciaDerecha(mapa);
        });
    }*/

}
