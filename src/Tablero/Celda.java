package Tablero;

public class Celda {
    protected Boolean ocupado;
    private Posicion posicion;

    public Celda(int CH, int CV){
        this.ocupado = false;
        this.posicion = new Posicion(CH,CV);
    }

    public boolean estaOcupada() {
        return ocupado;
    }
    public void ocuparCelda() {
        ocupado = true;
    }

    public Posicion getPoscion() {
        return this.posicion;
    }
}
