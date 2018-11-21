package Jugador;

import Ubicables.Ubicable;
import Ubicables.Unidades.Unidad;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Faccion {
    ArrayList miembros;

    public Faccion(){
        miembros = new ArrayList();
    }

    public boolean perteneceFaccion(Ubicable objetivo) {
        return miembros.contains(objetivo);
    }

    public void agregarMiembro(Ubicable miembro) {
        miembros.add(miembro);
    }
}
