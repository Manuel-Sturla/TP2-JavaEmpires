package Modelo.Estados;

public class Muerto implements Estado {
    @Override
    public boolean estaOcupado() {
        return true;
    }

    @Override
    public Estado desocuparUnTurno() {
        return this;
    }
}
