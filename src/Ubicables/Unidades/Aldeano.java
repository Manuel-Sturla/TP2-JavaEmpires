package Ubicables.Unidades;

import Exceptions.*;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;
import Ubicables.Edificios.Cuartel;
import Ubicables.Edificios.PlazaCentral;

public class Aldeano extends Unidad {
    Faccion faccion;

    public Aldeano(Posicion posicionRecibida, Faccion faccionRecibida) throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        super(50,posicionRecibida);
        faccion = faccionRecibida;
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
        faccion.agregarMiembro(this);
    }

    public PlazaCentral crearPlazaCentral(Posicion posicionConstruccion) throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
        return new PlazaCentral(posicionConstruccion, faccion);
    }

    public Cuartel aldaeanoCreaCuartel(Posicion posicionConstruccion) throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        if(!posicion.edificioEstaEnRango(posicionConstruccion)) throw new PosicionFueraDeRangoException();
        Cuartel cuartel = new Cuartel(posicionConstruccion, faccion);
        estado = new Ocupado(3);
        return cuartel;
    }


    public void recibirDanio(int danioRecibido) {
        vida -= danioRecibido;
        if(vida < 1){
            estado = new Ocupado(100); //estado = new Muerto(); EL ESTADO MUERTO NO ESTA POR AHORA NO PARECE SER NECESARIO
        }
    }

    public int getVida(){return vida;}

    @Override
    public boolean estaMuerto() {
        return vida<1; //estado.estaMuerto();
    }

    public Posicion getPosicion(){
        return posicion;
    }
}



