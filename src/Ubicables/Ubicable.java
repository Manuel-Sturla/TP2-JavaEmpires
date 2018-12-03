package Ubicables;

import Estados.Estado;
import Estados.Muerto;
import Estados.Ocupado;
import Exceptions.PosicionInvalidaException;
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

    public void recibirDanio(int danioRecibido) throws PosicionInvalidaException {
        vida -= danioRecibido;
        if(vida < 1 ){
            morir();
        }
    }

    protected abstract void morir() throws PosicionInvalidaException;

    public void recibirDanio(Castillo castillo) throws PosicionInvalidaException {recibirDanio(20);}

    public int getvida(){return vida;}


    public boolean estaMuerto(){
        return estado instanceof Muerto;
    }
}
