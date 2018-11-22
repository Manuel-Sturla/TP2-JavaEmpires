package Ubicables.Unidades;

import Exceptions.*;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;

public class Aldeano extends Unidad {
    Faccion faccion;

    public Aldeano(Posicion posicionRecibida, Faccion faccionRecibida) throws PosicionFueraDeRangoException {
        super(50,posicionRecibida);
        faccion = faccionRecibida;
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
        faccion.agregarMiembro(this);
    }

    public Aldeano(Posicion posicionRecibida) throws PosicionFueraDeRangoException {
        super(50,posicionRecibida);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }

    public void crearPlazaCentral(Posicion posicionConstruccion) throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
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
}



