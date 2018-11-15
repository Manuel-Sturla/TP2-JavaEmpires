package Edificios;
import Tablero.ElementoDeMapa;
import Tablero.Posicion;

public abstract class Edificio implements ElementoDeMapa {
        protected int vida,vidaTotal;
        protected Posicion posicion;

        public Edificio(int vida, int vidaTotal, Posicion posicion){
                this.vida = vida;
                this.vidaTotal = vidaTotal;
                this.posicion = posicion;
        }

        public Posicion getPosicion() {
                return posicion;
        }

        public void reparar() {

        }
}
