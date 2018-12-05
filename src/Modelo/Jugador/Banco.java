package Modelo.Jugador;

import Modelo.Exceptions.OroInsuficienteException;

public class Banco {
    int oro;

    public Banco(int cantidadDeOro){
        oro = cantidadDeOro;
    }

    public void gastarOro(int costo) throws OroInsuficienteException {
        if (oro < costo){
            throw new OroInsuficienteException();
        }
        oro -= costo;
    }

    public int getCantidadDeOro() {
        return oro;
    }

    public void agregarOro(int cantidadDeOro) {
        oro += cantidadDeOro;
    }

    public boolean hayOroSuficiente(int costo){
        return oro >= costo;
    }
}

