package Turnos;

public class Desocupado implements Estado {
    @Override
    public boolean estaOcupado() {
        return false;
    }
}
