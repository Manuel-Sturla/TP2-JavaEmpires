package Modelo.Jugador;

import Modelo.Ubicables.Edificios.Castillo;
import Modelo.Ubicables.Unidades.Aldeano;
import Modelo.Ubicables.Ubicable;
import java.util.ArrayList;

public class Faccion {
    ArrayList miembros;
    Castillo castillo;

    public Faccion(){
        miembros = new ArrayList();
    }

    public boolean perteneceFaccion(Ubicable objetivo) {
        return miembros.contains(objetivo);
    }

    public void agregarMiembro(Ubicable miembro) {
        miembros.add(miembro);
    }

    public void borrarMiembro(Ubicable miembro){
        miembros.remove(miembro);
    }

    public void agregarCastillo(Castillo castilloRecibido){
        castillo = castilloRecibido;
        miembros.add(castillo);
    }

    public Ubicable obtenerUbicable(int numeroDeUbicable) {
        return (Ubicable)miembros.get(numeroDeUbicable);
    }

    public ArrayList obtenerAldeanos() {
        ArrayList aldeanos = new ArrayList();
        for (int i = 0; i < miembros.size(); i++) {
            if(miembros.get(i) instanceof Aldeano){
                aldeanos.add(miembros.get(i));

            }
        }
        return aldeanos;
    }

    public void desocuparUnTurnoTodosLosElementos() {
        for (int i = 0; i < miembros.size(); i++) {
            Ubicable miembro = (Ubicable)miembros.get(i);
            miembro.desocuparUnTurno();
        }
    }

    public ArrayList getDesocupados() {
        ArrayList desocupados = new ArrayList();
        for (int i = 0; i < miembros.size(); i++) {
            Ubicable miembro = (Ubicable)miembros.get(i);
            if(!miembro.estaOcupado()){
                desocupados.add(miembro);
            }
        }
        return desocupados;
    }

    public void ocuparUnTurnoTodosLosElementosDesocupados() {
        ArrayList desocupados = getDesocupados();
        for (int i = 0; i < desocupados.size(); i++) {
            Ubicable desocupado = (Ubicable)desocupados.get(i);
            desocupado.ocuparUnTurno();
        }
    }

    public int obtenerCantidadDeAldeanosDesocupados() {
        ArrayList aldeanos = obtenerAldeanos();
        int cantidad = 0;
        for (int i = 0; i < aldeanos.size(); i++) {
            Ubicable aldeano = (Ubicable)aldeanos.get(i);
            if(!aldeano.estaOcupado()){
                cantidad++;
            }
        }
        return cantidad;
    }

    public Castillo obtenerCastillo() {
        return castillo;
    }

    public ArrayList getMiembros() {
        return miembros;
    }

    public boolean castilloFueDestruido() {
        return castillo.estaMuerto();
    }
}
