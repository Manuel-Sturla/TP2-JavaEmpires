package Unidades;
import Tablero.Posicion;

public class ArmaDeAsedio extends Unidad {
    boolean montada = false;

    public ArmaDeAsedio(Posicion posicion){
        super(150,150,posicion);
    }


    public void montarArma() {
        montada = true;
    }
    public void desmontarArma(){ montada = false;}

    public boolean getEstaMontada() {
        return montada;
    }

    /*
    @Override
    public void moverHaciaDerecha(Tablero mapa){
        if (this.getEstaMontada()) {
            throw new ArmaNoDesmontadaException();
        }

        Unidades unidadCopia = new Unidades();
        mapa.agregarElementoDeMapa(unidadCopia, posicionHorizontal + 1, posicionVertical);
        mapa.borrarElementoDeMapa(posicionHorizontal, posicionVertical);
    }
    */
}
