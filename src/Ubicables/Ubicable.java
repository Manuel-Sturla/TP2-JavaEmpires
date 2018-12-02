package Ubicables;

import Estados.Estado;
import Estados.Ocupado;
import Jugador.Faccion;
import Ubicables.Edificios.Castillo;

public abstract class Ubicable {
    protected Estado estado;
    protected int vida;
    protected Faccion faccion;

    public void asignarFaccion(Faccion faccionRecibida){
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }

    public void desocuparUnTurno(){
        estado = estado.desocuparUnTurno();
    }

    public boolean estaOcupado(){
        return estado.estaOcupado();
    }

    public void ocuparUnTurno(){
        estado = new Ocupado(1);
    }

    public void recibirDanio(int danioRecibido){
        vida -= danioRecibido;
        if(vida < 1){
            //morir();
        }
    }

    //public abstract void morir();

    public void recibirDanio(Castillo castillo) {recibirDanio(20);}

    public int getvida(){return vida;}


}