package Tablero;

import Exceptions.PosicionNoDisponibleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {

    int x1 = 0;
    int x2 = 0;
    private Mapa m = new Mapa(10,10);

    private void setx1Yx2(Posicion p){
        x1 = p.getCoordenadaHorizontal();
        x2 = p.getCoordenadaVertical();
    }

    @Test <x1,x2,m>
    void prueboConstructor(){

        Posicion p = new Posicion(m,x1,x2);
        assertTrue(p != null);
    }

    //PRUEBAS DE MOVIMIENTO
    @Test <x1,x2,m>
    void prueboMovermeDer() throws PosicionNoDisponibleException {
        Posicion p = new Posicion(m,0,0);
        p.moverDer();
        assertTrue(p.getCoordenadaHorizontal()== 1 && p.getCoordenadaVertical() == 0);
    }
/*
    @Test <x1,x2,m>
    void prueboMoverIzq(){
        Posicion p = new Posicion(m,1,0);
        p.moverIzq();
        setx1Yx2(p);
        assertTrue(x1== 0 && x2 == 0);
    }

    @Test <x1,x2,m>
    void prueboMoverArriba(){
        Posicion p = new Posicion(m,0,0);
        p.moverArriba();
        setx1Yx2(p);
        assertTrue(x1 == 0 && x2 == 1);
    }

    @Test <x1,x2,m>
    void prueboMoverAbajo(){
        Posicion p = new Posicion(m,0,1);
        p.moverAbajo();
        setx1Yx2(p);
        assertTrue(x1 == 0 && x2 == 0);
    }

    @Test <x1,x2,m>
    void prueboMovermeArribaDer(){
        Posicion p = new Posicion(m,0,0);
        p.moverArribaDer();
        setx1Yx2(p);
        assertTrue(x1 ==1 && x2== 1);
    }

    @Test <x1,x2,m>
    void prueboMoverArribaIzq(){
        Posicion p = new Posicion(m,1,0);
        p.moverArribaIzq();
        setx1Yx2(p);
        assertTrue(x1 == 0 && x2 == 1);
    }

    @Test <x1,x2,m>
    void prueboMoverAbajoDer(){
        Posicion p = new Posicion(m,0,1);
        p.moverAbajoDer();
        setx1Yx2(p);
        assertTrue(x1 == 1 && x2 == 0);
    }

    @Test <x1,x2,m>
    void pruebaMoverAbajoIzq(){
        Posicion p = new Posicion(m,2,2);
        p.moverAbajoIzq();
        setx1Yx2(p);
        assertTrue(x1 == 1 && x2 == 1);
    }
    */
}
