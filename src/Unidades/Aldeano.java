package Unidades;

import Exceptions.ElementoFueraDeRangoException;
import Tablero.*;
import Edificios.Edificio;


public class Aldeano{
    Posicion posicion;

    public Aldeano(Mapa mapa , int cooordenadaHorizontal, int coordenadaVertical){
        Posicion posicion = new Posicion(mapa, cooordenadaHorizontal, coordenadaVertical);
    }

    public void moverAldeanoHaciaDerecha() {
        posicion.moverPosicion(1,0);
    }

    /*
    public void repararEdificio( Edificio edificio) throws ElementoFueraDeRangoException {
        if (!posicion.estaContigua(edificio)){
            throw new ElementoFueraDeRangoException();
        }
        edificio.reparar();
        // estado.ocupar(3 turnos);

        // OTRAA OPCION
        /*
        if (!mapa.estanContiguos
        (this, edificio)){
            throw new ElementoFueraDeRangoException();
        }
        edificio.reparar();


        */
}
