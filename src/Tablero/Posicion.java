package Tablero;

import Edificios.Edificio;
import Unidades.Unidad;

public class Posicion {
    int coordenadaHorizontal;
    int coordenadaVertical;
    static Mapa mapa;

    public Posicion(Mapa mapa, int CooH,int CooV){
        this.coordenadaHorizontal = CooH;
        this.coordenadaVertical = CooV;
        this.mapa = mapa;
    }

    public int getCoordenadaHorizontal() {
        return coordenadaHorizontal;
    }

    public int getCoordenadVertical() {
        return coordenadaVertical;
    }

    public boolean estaContigua(Edificio edificio) {
        Posicion P2 = edificio.getPosicion();
        return mapa.sonContiguos(this.coordenadaHorizontal, this.coordenadaVertical, P2.getCoordenadaHorizontal(), P2.getCoordenadVertical());
    }

    public boolean esIgual(Posicion posicion2) {
        boolean resultado = coordenadaHorizontal == posicion2.getCoordenadaHorizontal();
        resultado &= coordenadaVertical == posicion2.getCoordenadVertical();
        return resultado;
    }

    public boolean ubicarElementoDeMapa(Unidad unidad){
        int generador=0;
        while(mapa.agregarElementoDeMapa(unidad,this,coordenadaHorizontal+1,coordenadaVertical+generador)){
            generador += 1;
        }
        return true;
    }

    public void actualizarPosicion(int nuevaCoordenadaHorizontal, int nuevaCoordenadaVertical) {
        coordenadaHorizontal = nuevaCoordenadaHorizontal;
        coordenadaVertical = nuevaCoordenadaVertical;
    }
/*
    public Posicion[] obtenerContiguas() {
        // Esto funciona solo para unidades (que tienen tamaño u1)
        Posicion[] contiguas;
        for (int i = 0; i<8; i++ ){
            Posicion contiguaNueva = new Posicion();
        }
    }*/
}
