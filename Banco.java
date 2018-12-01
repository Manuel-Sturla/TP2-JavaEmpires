package Jugador;

import Exceptions.OroInsuficienteException;

public class Banco {
    int oro;

    public Banco(int cantidadDeOro){
        oro = cantidadDeOro;
    }

    public void gastarOro(int costo) throws OroInsuficienteException {
        if (oro < 50){
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
}
