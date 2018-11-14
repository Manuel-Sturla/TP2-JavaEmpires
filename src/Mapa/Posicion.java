package Mapa;

import Edificios.Edificios;
import Unidad.Aldeano;

public class Posicion {
    int coordenadaHorizontal;
    int coordenadaVertical;
    Mapa mapa;

    public boolean estaContigua(Edificios edificio) {
        Posicion posicion2 = edificio.getPosicion();
        return mapa.sonContiguos(this, posicion2);
    }

    public boolean esIgual(Posicion posicion2) {
        boolean resultado = coordenadaHorizontal == posicion2.getCoordenadaHorizontal();
        resultado &= coordenadaVertical == posicion2.getCoordenadVertical();
        return resultado;
    }

    private int getCoordenadaHorizontal() {
        return coordenadaHorizontal;
    }

    private int getCoordenadVertical() {
        return coordenadaVertical;
    }

    public Posicion[] obtenerContiguas() {
        // Esto funciona solo para unidades (que tienen tamaño u1)
        Posicion[] contiguas;
        for (int i = 0; i<8; i++ ){
            Posicion contiguaNueva = new Posicion;
        }
    }
}
