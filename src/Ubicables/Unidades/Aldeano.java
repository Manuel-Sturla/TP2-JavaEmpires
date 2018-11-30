package Ubicables.Unidades;

import Estados.Ocupado;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Ubicables.Edificios.PlazaCentral;

public class Aldeano extends Unidad {
    ConstructorDeUbicables constructor;

    public Aldeano(Posicion posicionRecibida, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(50, posicionRecibida);
        constructor = constructorRecibido;
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }

    public void crearPlazaCentral() throws PosicionInvalidaException, UbicableEstaOcupadoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
        Posicion posicionConstruccion = new Posicion(posicion.getMapa(), posicion.getCoordenadaHorizontal() + 1,posicion.getCoordenadaVertical()); //Parche
        PlazaCentral plaza = constructor.crearPlazaCentral(posicionConstruccion);
        plaza.asignarFaccion(faccion);
    }

    public void recibirDanio(int danioRecibido) {
        vida -= danioRecibido;
        if(vida < 1){
            estado = new Ocupado(100); //estado = new Muerto(); EL ESTADO MUERTO NO ESTA POR AHORA NO PARECE SER NECESARIO
        }
    }

    public int getVida(){return vida;}

    public Posicion getPosicion(){
        return posicion;
    }
}
