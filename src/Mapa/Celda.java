package Mapa;

import Ubicables.Ubicable;

import java.util.ArrayList;
import java.util.Observable;

public class Celda extends Observable {
    protected boolean ocupado;
    protected Ubicable ubicable;
    private CeldasAdyacentes celdasAdyacentes = new CeldasAdyacentes();

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
        setChanged();
        notifyObservers(ubicable);
    }

    public void desocuparCelda() {
        ubicable = null;
        ocupado = false;
        setChanged();
        notifyObservers();
    }

    public Ubicable getElemento() {
        return ubicable;
    }

    public void setCeldasAdyacentes(ArrayList celdasAdyacentesRecibidas) {
        celdasAdyacentes.agregarCeldasAdyacentes(celdasAdyacentesRecibidas);
    }

    public boolean esAdyacente(Celda celda2) {
        return celdasAdyacentes.contiene(celda2);
    }

    public ArrayList obtenerCeldasAdyacentesEnRango(int rango){
        return celdasAdyacentes.obtenerCeldasAdyacentesEnRango(rango);

    }
}
