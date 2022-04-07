package com.example.demojpa.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.example.demojpa.model.Heroes;

public class TestUtils {

	public static final Integer UNO = 1;
	
	

	private static Heroes GenerarHeroe(int id, String nombre, String estado) {
		Heroes heroe = new Heroes();
		heroe.setId_heroes(id);
	    heroe.setNombre(nombre);
	    heroe.setEstado(estado);
		return heroe;
	}
	
	public static Optional<Heroes> obtenerHeroe() {
		return Optional.of(GenerarHeroe(1, "IronMan", "Vivo"));
	}
	
	public static List<Heroes> obtenerHeroes() {
		 List<Heroes>  heroes = new ArrayList<Heroes>();
		
		 heroes.add(GenerarHeroe(1, "IronMan", "Vivo"));
		 heroes.add(GenerarHeroe(1, "Superman", "Muerto"));
		 heroes.add(GenerarHeroe(1, "Viuda Negra", "Muerto"));
		
		return heroes;
	}

	public static void guardarHeroe() {
		 List<Heroes>  heroes = new ArrayList<Heroes>();
		 heroes.add(GenerarHeroe(1, "IronMan", "Vivo"));
	}


}
