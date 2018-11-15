package Edificios;
import Tablero.Posicion;
import Unidades.ArmaDeAsedio;


public class Castillo extends Edificio{
	private int daño;

	public Castillo(Posicion pos){
		super(1000,1000,pos);
		this.daño = 20;
	}

    public ArmaDeAsedio crearArmaDeAsedio(){
			
		ArmaDeAsedio unidad = new ArmaDeAsedio(posicion);
		 
		return unidad;
		
	}

}
