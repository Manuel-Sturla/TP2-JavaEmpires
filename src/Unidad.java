public class Unidad implements ElementoDeMapa{

    int posicionHorizontal = 0;
    int posicionVertical = 0;

    public void moverHaciaDerecha(Mapa mapa){
        Unidad unidadCopia = new Unidad();
        mapa.agregarElementoDeMapa(unidadCopia, posicionHorizontal + 1, posicionVertical);
        mapa.borrarElementoDeMapa(posicionHorizontal, posicionVertical);
    }

    @Override
    public void actualizarPosicion(int coordenadaHorizontal, int coordenadaVertical) {
        posicionHorizontal = coordenadaHorizontal;
        posicionVertical = coordenadaVertical;
    }

    /*
    public void moverHaciaIzquierda(Mapa mapa){
        Unidad unidadCopia = new Unidad;
        mapa.agregarElementoDeMapa(unidadCopia,posicionHorizontal - 1, posicionVertical);

    }*/

}
