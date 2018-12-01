package Jugador;

import Exceptions.UnidadesMaximasException;

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
}
