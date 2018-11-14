package Edificios;

public class Edificio import Posicion {
    Posicion posicion;
    int tam;

    public void posicionarUnidad(Unidad unidad){
        int coordenadaH = posicion.obtenerCoordenadaHorizontal();
        int coordenadaV = posicion.obtenerCoordenadaVertical();

        unidad.actualizarPosicion(coordenadaH-1, coordenadaV);

    }
}
