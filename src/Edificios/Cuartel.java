package Edificios;
import Unidad.*;
public class Cuartel {
	int vida = 250;
	int costo = 50;
	int duracion = 3;
	
	 Espadachin crear_espadachin(){
			
		Espadachin unidad = new Espadachin();
		 
		return unidad;
		
	}
	 
	 Arquero crear_arquero(){
			
		Arquero unidad = new Arquero();
		 
		return unidad;
		
	}
}
