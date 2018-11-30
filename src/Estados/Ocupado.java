package Estados;

public class Ocupado implements Estado {
    int cantidadDeTurnos;

    public Ocupado(int cantidadDeTurnosRecibida){
        cantidadDeTurnos = cantidadDeTurnosRecibida;
    }

    @Override
    public boolean estaOcupado() {
        return true;
    }

    public Estado desocuparUnTurno(){
        cantidadDeTurnos--;
        if(cantidadDeTurnos < 1){
            return(new Desocupado());
        }
        return this;
    }
}
