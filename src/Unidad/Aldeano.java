package Unidad;

import Mapa.ElementoFueraDeRangoException;
import Mapa.Posicion;
import Edificios.Edificios;


public class Aldeano extends Unidad {
    int vida = 50;
    //Estado estado = new Estado();
    Posicion posicion;

    public void repararEdificio( Edificios edificio) throws ElementoFueraDeRangoException {
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
}
