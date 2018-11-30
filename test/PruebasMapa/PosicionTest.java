package PruebasMapa;

import Exceptions.PosicionInvalidaException;
import Mapa.Mapa;
import Posiciones.Posicion;
import Posiciones.PosicionEdificio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {
    int x1 = 0;
    int x2 = 0;
    private Mapa m = new Mapa(10, 10);

    private void setx1Yx2(Posicion p) {
        x1 = p.getCoordenadaHorizontal();
        x2 = p.getCoordenadaVertical();
    }
    @Test
    <x1, x2, m>
    void prueboConstructor() {

        Posicion p = new Posicion(m, x1, x2);
        assertTrue(p != null);
    }

    //PRUEBAS DE MOVIMIENTO
    @Test
    <x1, x2, m>
    void prueboMovermeDer() throws PosicionInvalidaException {
        Posicion p = new Posicion(m, 0, 0);
        p.moverDerecha();
        assertTrue(p.getCoordenadaHorizontal() == 1 && p.getCoordenadaVertical() == 0);
    }

    @Test
    <x1, x2, m>
    void prueboMoverIzq() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 1, 0);
        p.moverIzquierda();
        setx1Yx2(p);
        assertTrue(x1 == 0 && x2 == 0);
    }

    @Test
    <x1, x2, m>
    void prueboMoverArriba() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 0, 0);
        p.moverArriba();
        setx1Yx2(p);
        assertTrue(x1 == 0 && x2 == 1);
    }

    @Test
    <x1, x2, m>
    void prueboMoverAbajo() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 0, 1);
        p.moverAbajo();
        setx1Yx2(p);
        assertTrue(x1 == 0 && x2 == 0);
    }

    @Test
    <x1, x2, m>
    void prueboMovermeArribaDer() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 0, 0);
        p.moverArribaDer();
        setx1Yx2(p);
        assertTrue(x1 == 1 && x2 == 1);
    }

    @Test
    <x1, x2, m>
    void prueboMoverArribaIzq() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 1, 0);
        p.moverArribaIzq();
        setx1Yx2(p);
        assertTrue(x1 == 0 && x2 == 1);
    }
    @Test
    <x1, x2, m>
    void prueboMoverAbajoDer() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 0, 1);
        p.moverAbajoDer();
        setx1Yx2(p);
        assertTrue(x1 == 1 && x2 == 0);
    }
    @Test
    <x1, x2, m>
    void pruebaMoverAbajoIzq() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 2, 2);
        p.moverAbajoIzq();
        setx1Yx2(p);
        assertTrue(x1 == 1 && x2 == 1);
    }
    @Test
    void obtenerAdyacenteDaLaCorrecta() throws PosicionInvalidaException{
        Posicion p = new Posicion(m, 5, 5);
        boolean check = true;
        for (int i = 4; i<7; i++){
            for (int j=4; j<7; j++){
                if(i==5 && j==5){
                    continue;
                }
                Posicion posicionAdyacente = new Posicion(m,i,j);
                if(!p.esAdyacente(posicionAdyacente)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    //TEST DE SI ESTA EN RANGO
    @Test<m>
    void meFijoSiEstaARangoOtraPosicion() throws PosicionInvalidaException{
        Posicion posicion = new Posicion(m,1,1);
        Posicion posicion1 = new Posicion(m,1,2);
        PosicionEdificio posicionEdificio = new PosicionEdificio(posicion1,2);
        assertTrue(posicion.edificioEstaEnRango(posicionEdificio));
    }
    @Test<m>
    void meFijoSiEstaARangoDeOTraPosicionFalla() throws PosicionInvalidaException{
        Posicion posicion = new Posicion(m,1,1);
        Posicion posicion1 = new Posicion(m,2,3);
        PosicionEdificio posicionEdificio = new PosicionEdificio(posicion1,2);
        assertTrue(!posicion.edificioEstaEnRango(posicionEdificio));
    }

}
