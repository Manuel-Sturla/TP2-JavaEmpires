package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Edificios.Edificio;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.Arquero;
import Modelo.Ubicables.Unidades.Unidad;

public class Atacar implements ComandoConObjetivo {
    Arquero invocador;
    Ubicable objetivo;
    public Atacar(Arquero unidad){
        invocador=unidad;
    }

    public void agregarObjetivo(Ubicable ubicable) {
        objetivo = ubicable;
    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        if (objetivo instanceof Edificio) { invocador.atacar((Edificio)objetivo); }
        else { invocador.atacar((Unidad) objetivo);}
        //Ya se que es horrible pero acepto nuevas ideas
    }

    @Override
    public String getNombre() {
        return "Atacar";
    }
}
