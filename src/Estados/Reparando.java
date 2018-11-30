package Estados;

import Ubicables.Edificios.Edificio;

public class Reparando extends Ocupado {
    Edificio edificioEnReparacion;

    public Reparando(Edificio edificio) {
        super(1);
        edificioEnReparacion = edificio;
    }

    @Override
    public Estado desocuparUnTurno(){

        edificioEnReparacion.reparar();
        if (!edificioEnReparacion.estaEnConstruccion()){
            return new Desocupado();
        }
        return  new Reparando(edificioEnReparacion);
    }

}
