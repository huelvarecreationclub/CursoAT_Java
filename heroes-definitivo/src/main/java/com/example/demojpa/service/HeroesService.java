package com.example.demojpa.service;

import java.util.List;

import com.example.demojpa.model.Heroes;




public interface HeroesService {


	List<Heroes> listadoHeroes();

	Heroes obtenerHeroes(Integer id);

	Heroes guardar(Heroes heroes);
	
	List<Heroes> buscarPorEstadoVivo();
	
	List<Heroes> buscarPorEstadoMuerto();

	void eliminar(Integer idHeroes);

	List<Heroes> buscarCadena(String cadena);

	Heroes guardarAMuerto(Integer id);

}
