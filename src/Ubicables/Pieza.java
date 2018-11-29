package Ubicables;

import Jugador.Faccion;
import Turnos.Estado;

public abstract class Pieza implements Ubicable{
    protected int vida;
    protected int precio;
    protected Faccion faccion;
    protected Estado estado;
    //Banco banco;



    @Override
    public boolean estaMuerto() {
        return vida <1;
    }

    @Override
    public void recibirDanio(int danioRecibido) {
        vida -= danioRecibido;
        if(this.estaMuerto()){
            faccion.eliminarMiembro((Ubicable)this);
        }
    }
    public void desocuparUnTurno() {
        estado = estado.desocuparUnTurno();
    }
    public boolean estaOcupado() {
        return estado.estaOcupado();
    }
    public void crear(Ubicable elemento){
        //banco.gastar(precio);
        faccion.agregarMiembro(elemento);

    }

}
