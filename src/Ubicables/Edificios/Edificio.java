package Ubicables.Edificios;

import Exceptions.PosicionInvalidaException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Posiciones.PosicionEdificio;
import Ubicables.Ubicable;
import Ubicables.Unidades.ArmaDeAsedio;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Espadachin;

public abstract class Edificio extends Ubicable {

    protected PosicionEdificio posicion;
    protected ConstructorDeUbicables constructor;
    protected int vidaMax;
    protected int recuperacionDeVida;
    protected boolean enConstruccion = false;

    public Edificio(Posicion posicionCostruccion, int vidaRecibida, int largo, ConstructorDeUbicables constructorRecibido, int tasaRecuperacion) throws PosicionInvalidaException {
        posicion = new PosicionEdificio(posicionCostruccion, largo);
        constructor = constructorRecibido;
        if(!posicion.estanDisponible()) throw new PosicionInvalidaException();
        posicion.ocuparPosiciones(this);
        vida = vidaRecibida;
        vidaMax = vidaRecibida;
        recuperacionDeVida = tasaRecuperacion;
    }

    public void reparar(){
        enConstruccion = true;
        vida += recuperacionDeVida;
        if (vida >= vidaMax){
            vida = vidaMax;
            enConstruccion = false;
            return;
        }

    }


    public boolean estaEnConstruccion() {
        return enConstruccion;
    }

    public PosicionEdificio getPosicion(){
        return posicion;
    }

    public void recibirDanio(Espadachin espadachin){ vida -= 15; }
    public void recibirDanio(Arquero arquero){ vida -= 10;}
    public void recibirDanio(ArmaDeAsedio armaDeAsedio){ vida -= 75;}
}
