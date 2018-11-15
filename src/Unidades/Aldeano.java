package Unidades;

import Tablero.ElementoFueraDeRangoException;
import Tablero.*;
import Edificios.Edificio;


public class Aldeano extends Unidad {

    public Aldeano(Posicion posicion){
        super(50,50,posicion);
    }

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
}
