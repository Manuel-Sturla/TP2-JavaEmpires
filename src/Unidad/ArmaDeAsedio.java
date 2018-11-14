package Unidad;
import Mapa.Mapa;

public class ArmaDeAsedio extends Unidad {
    int vida = 150;
    boolean montada = false;


    public void montarArma() {
        montada = true;
    }
    public void desmontarArma(){ montada = false;}

    public boolean getEstaMontada() {
        return montada;
    }

    /*
    @Override
    public void moverHaciaDerecha(Mapa mapa){
        if (this.getEstaMontada()) {
            throw new ArmaNoDesmontadaException();
        }

        Unidad unidadCopia = new Unidad();
        mapa.agregarElementoDeMapa(unidadCopia, posicionHorizontal + 1, posicionVertical);
        mapa.borrarElementoDeMapa(posicionHorizontal, posicionVertical);
    }
    */
}
