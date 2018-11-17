package Tablero;

public class Posicion {
    private int coordenadaHorizontal;
    private int coordenadaVertical;
    private Mapa mapa;

    //constructor
    public Posicion(Mapa mapaRecibido, int CH, int CV) {
        this.coordenadaHorizontal = CH;
        this.coordenadaVertical = CV;
        mapa = mapaRecibido;
    }

    //getters
    public int getCoordenadaHorizontal() {
        return this.coordenadaHorizontal;
    }
    public int getCoordenadaVertical() {
        return coordenadaVertical;
    }

    // metodos de movimiento
    public void moverDer() {
        coordenadaHorizontal += 1;
    }
    public void moverIzq() {
        coordenadaHorizontal -= 1;
    }
    public void moverArriba() {
        coordenadaVertical += 1;
    }
    public void moverAbajo() {
        coordenadaVertical -= 1;
    }

    public void moverArribaDer() {
        moverArriba();
        moverDer();
    }
    public void moverArribaIzq() {
        moverArriba();
        moverIzq();
    }
    public void moverAbajoDer() {
        moverAbajo();
        moverDer();
    }
    public void moverAbajoIzq() {
        moverAbajo();
        moverIzq();
    }
}
