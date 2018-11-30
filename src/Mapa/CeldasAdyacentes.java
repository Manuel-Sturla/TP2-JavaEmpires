package Mapa;

import Mapa.Celda;

import java.util.ArrayList;

public class CeldasAdyacentes {
    ArrayList<Celda> conjuntoCeldas = new ArrayList();

    public void agregarCeldasAdyacentes(ArrayList celdasAdyacentesRecibidas){
        conjuntoCeldas.addAll(celdasAdyacentesRecibidas);
    }

    public boolean contiene(Celda celda2) {
        return conjuntoCeldas.contains(celda2);
    }

    public ArrayList <Celda> obtenerCeldasAdyacentesEnRango(int rango) {

        ArrayList adyacentes = new ArrayList(conjuntoCeldas);
        if(rango < 2){
            return adyacentes;
        }
        for (int i = 0; i < conjuntoCeldas.size(); i++) {
            adyacentes.addAll(conjuntoCeldas.get(i).obtenerCeldasAdyacentesEnRango(rango-1));
        }
        return adyacentes;
    }
}
