package Modelo.Estados;

public class Desocupado implements Estado {
    @Override
    public boolean estaOcupado() {
        return false;
    }

    @Override
    public Estado desocuparUnTurno() {
        return this;
    }
}
