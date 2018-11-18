package Jugador;

import Ubicables.Aldeano;
import Ubicables.Castillo;

import java.util.Hashtable;

public class Jugador {

    Hashtable elementosUbicables = new Hashtable();
    int contador = 0;

    public Jugador(Aldeano aldeanos[], Castillo castillo){
        elementosUbicables.put("Unidad1",aldeanos[0]);
        elementosUbicables.put("Unidad2",aldeanos[1]);
        elementosUbicables.put("Unidad3",aldeanos[2]);
        elementosUbicables.put("Edificio0", castillo);
        contador = 4;
    }

}
