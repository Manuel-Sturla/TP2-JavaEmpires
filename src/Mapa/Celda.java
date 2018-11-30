package Mapa;

import Ubicables.Ubicable;

import java.util.ArrayList;

public class Celda {
    protected boolean ocupado;
    protected Ubicable ubicable;
    private CeldasAdayacentes celdasAdyacentes = new CeldasAdayacentes();

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

    public void setCeldasAdyacentes(ArrayList celdasAdyacentesRecibidas) {
        celdasAdyacentes.agregarCeldasAdayacentes(celdasAdyacentesRecibidas);
    }

    public boolean esAdyacente(Celda celda2) {
        return celdasAdyacentes.contiene(celda2);
    }

    public ArrayList obtenerCeldasAdyacentesEnRango(int rango){
        return celdasAdyacentes.obtenerCeldasAdyacentesEnRango(rango);

    }
}
