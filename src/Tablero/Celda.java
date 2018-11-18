package Tablero;

import Unidades.Ubicable;

public class Celda {
    protected boolean ocupado;
    protected Ubicable ubicable;

    public Celda(){
        this.ocupado = false;
    }

    public boolean estaOcupada() {
        return ocupado;
    }
    public void ocuparCelda(Ubicable elementoMapa) {
        if(this.estaOcupada()) return;
        ubicable = elementoMapa;
        ocupado = true;
    }

    public void desocuparCelda() {
        ubicable = null;
        ocupado = false;
    }

    public Ubicable getElemento() {
        return ubicable;
    }
}
