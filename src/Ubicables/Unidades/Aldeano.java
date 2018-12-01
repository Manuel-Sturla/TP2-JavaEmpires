package Ubicables.Unidades;

import Estados.Ocupado;
import Estados.Reparando;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeOtraFaccionException;
import Exceptions.UbicableEstaOcupadoException;
import Exceptions.UbicableFueraDeRangoException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Ubicables.Edificios.Edificio;
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
            estado = new Ocupado(100);
        }
    }

    public void reparar(Edificio edificio) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        if (edificio.estaEnConstruccion()){
            return; //no hace nadaaaa
         }
        if (!posicion.estaEnRango(edificio.getPosicion())){
            throw new UbicableFueraDeRangoException();
        }
        if (!faccion.perteneceFaccion(edificio)){
            throw  new UbicableDeOtraFaccionException();
        }
        estado = new Reparando(edificio);
        edificio.reparar();
    }

    public int getVida(){return vida;}

    public Posicion getPosicion(){
        return posicion;
    }


}
