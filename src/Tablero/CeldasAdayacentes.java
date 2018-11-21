package Tablero;

import java.util.ArrayList;

public class CeldasAdayacentes {
    ArrayList conjuntoCeldas = new ArrayList();


    public void agregarCeldasAdayacentes(ArrayList celdasAdyacentesRecibidas){
        conjuntoCeldas.addAll(celdasAdyacentesRecibidas);
    }

    public boolean contiene(Celda celda2) {
        return conjuntoCeldas.contains(celda2);
    }
}
