package Ubicables;

import Estados.Estado;
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

    public void recibirDanio(int danioRecibido,boolean castillo){// si es un castillo faccion debera borrar castillo no miembro 
        vida -= danioRecibido;
        if(vida < 1 && !castillo ){
            //morir();
            faccion.borrarMiembro(this);
        }
        if(vida < 1 && castillo ){
            //morir();
            faccion.borrarCastillo();
        }
    }

    //public abstract void morir();

    public void recibirDanio(Castillo castillo) throws PosicionInvalidaException {recibirDanio(20,false);}

    public int getvida(){return vida;}


}
