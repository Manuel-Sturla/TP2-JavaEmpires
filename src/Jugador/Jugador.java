package Jugador;

import Ubicables.Aldeano;

import java.util.Hashtable;

public class Jugador {

    Hashtable elementosUbicables = new Hashtable();

    public Jugador(Aldeano aldeanos[]){
        elementosUbicables.put("Aldeano 1",aldeanos[0]);
        elementosUbicables.put("Aldeano 2",aldeanos[1]);
        elementosUbicables.put("Aldeano 3",aldeanos[2]);
    }
}
