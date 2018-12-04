package Modelo.Estados;

public interface Estado {
    boolean estaOcupado();

    Estado desocuparUnTurno();
}
