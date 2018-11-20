package Tablero;

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
/*
    public ArrayList verificarCeldasAdyacentesEnRango(int rango){
        ArrayList adyacentes = new ArrayList();
        if(rango < 0){
            return adyacentes;
        }
        for (int i = 0; i < conjuntoCeldas.size(); i++) {
            adyacentes.addAll(conjuntoCeldas.get(i).verificarCeldasAdyacentesEnRango(rango-1));
        }
        return adyacentes;
    }
    */
}
