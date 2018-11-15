package Edificios;
import Unidades.*;
import Tablero.Posicion;

public class Cuartel extends Edificio{
	int vida = 250;
	int costo = 50;
	int duracion = 3;

	public Cuartel(Posicion pos){
		super(250,250,pos);
	}


	public Espadachin crear_espadachin(){
		Espadachin unidad = new Espadachin(posicion);
		return unidad;
	}
	 public Arquero crear_arquero(){
		Arquero unidad = new Arquero(posicion);
		return unidad;
	}
}
