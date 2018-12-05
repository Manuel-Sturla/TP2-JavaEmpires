package Modelo.Ubicables.Edificios;

import Modelo.Estados.Muerto;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Posiciones.Posicion;
import Modelo.Posiciones.PosicionEdificio;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.ArmaDeAsedio;
import Modelo.Ubicables.Unidades.Arquero;
import Modelo.Ubicables.Unidades.Espadachin;

import java.util.ArrayList;

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
    public ArrayList<Comando> getAcciones(){
        return null;
    }

    public boolean estaEnConstruccion() {
        return enConstruccion;
    }

    public PosicionEdificio getPosicion(){
        return posicion;
    }

    public void recibirDanio(Espadachin espadachin) throws PosicionInvalidaException {
        super.recibirDanio(15);
    }

    public void recibirDanio(Arquero arquero) throws PosicionInvalidaException {
        super.recibirDanio(10);
    }
    public void recibirDanio(ArmaDeAsedio armaDeAsedio) throws PosicionInvalidaException {
        super.recibirDanio(75);
    }

    public void recibirDanio(Castillo castillo) throws PosicionInvalidaException {
        super.recibirDanio(20);
    }

    public void morir() throws PosicionInvalidaException {
        posicion.desocuparPosiciones();
        estado = new Muerto();
    }
}
