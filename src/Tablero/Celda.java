package Tablero;

public class Celda {
    protected Boolean ocupado;

    public Celda(){
        this.ocupado = false;
    }

    public boolean estaOcupada() {
        return ocupado;
    }
    public void ocuparCelda() {
        ocupado = true;
    }

    public void desocuparCelda() {
        ocupado = false;
    }
}
