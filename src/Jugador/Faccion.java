package Jugador;

import Ubicables.Pieza;
import Ubicables.Ubicable;

import java.util.ArrayList;

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

    public void eliminarMiembro(Ubicable pieza) {
        miembros.remove(pieza);
    }
}
