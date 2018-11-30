package Jugador;

public class Banco {
    int oro;

    public Banco(int cantidadDeOro){
        oro = cantidadDeOro;
    }

    public void gastarOro(int costo) {
        oro -= costo;
    }

    public int getCantidadDeOro() {
        return oro;
    }

    public void agregarOro(int cantidadDeOro) {
        oro += cantidadDeOro;
    }
}
