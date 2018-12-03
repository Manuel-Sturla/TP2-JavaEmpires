package Jugador;

import Exceptions.UnidadesMaximasException;
import Ubicables.Ubicable;

import java.util.ArrayList;

public class Poblacion {

    int cantHabitantes;

    public void agregarHabitante() throws UnidadesMaximasException {

        if(cantHabitantes == 50){
            throw new UnidadesMaximasException();
        }
        cantHabitantes++;
    }

    public int getPoblacion() {
        return cantHabitantes;
    }

    public void actualizarPoblacion(Faccion faccion) {
        ArrayList miembros = faccion.getMiembros();
        for(int i = 0; i < miembros.size(); i++){
            Ubicable miembro = (Ubicable)miembros.get(i);
            if(miembro.estaMuerto()){
                cantHabitantes--;
                faccion.borrarMiembro(miembro);
            }
        }
    }
}
