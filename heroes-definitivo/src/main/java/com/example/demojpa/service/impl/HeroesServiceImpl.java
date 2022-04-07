package com.example.demojpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.model.Heroes;
import com.example.demojpa.repository.HeroesRepository;
import com.example.demojpa.service.HeroesService;



@Service
public class HeroesServiceImpl implements HeroesService {

	@Autowired
	private HeroesRepository heroesRepository;

	
	@Override
	public List<Heroes> listadoHeroes() {
		return heroesRepository.findAll();
	}
	
	@Override
	public Heroes obtenerHeroes(Integer id) {
		return heroesRepository.findById(id).get();
	}
	
	@Override
	public Heroes guardar(Heroes heroe) {
		return heroesRepository.save(heroe);
	}
	
	@Override
	public List<Heroes> buscarCadena(String cadena){
		return heroesRepository.findByCadena(cadena);
	}
	
	@Override
	public List<Heroes> buscarPorEstadoVivo(){
		return heroesRepository.findByEstadoVivo();
	}
	
	@Override
	public List<Heroes> buscarPorEstadoMuerto(){
		return heroesRepository.findByEstadoMuerto();
	}

	@Override
	public void eliminar(Integer idHeroes) {
		heroesRepository.deleteById(idHeroes);
			
	}

	@Override
	public Heroes guardarAMuerto(Integer id) {
		Heroes heroe=heroesRepository.findById(id).get();
		heroe.setEstado("Muerto");
		heroesRepository.save(heroe);
		return heroe;
	}



	
}
