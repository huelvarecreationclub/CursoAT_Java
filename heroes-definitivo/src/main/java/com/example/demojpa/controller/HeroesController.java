package com.example.demojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demojpa.model.Heroes;
import com.example.demojpa.service.HeroesService;


@RestController
public class HeroesController {

    @Autowired
	private HeroesService heroesService;

	
    @GetMapping(value="heroes",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Heroes> listarHeroes() {
		return heroesService.listadoHeroes();
	} 

    
    @GetMapping(value = "heroes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Heroes listarHeroes(@PathVariable Integer id) {
		return heroesService.obtenerHeroes(id);
	}
	
    
	@GetMapping(value = "heroes/vivo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Heroes> buscarporEstadoVivo(){
			return heroesService.buscarPorEstadoVivo(); 
	}
	 
	
	@GetMapping(value = "heroes/muerto", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Heroes> buscarporEstadoMuerto(){
			return heroesService.buscarPorEstadoMuerto();
	}
	
	@GetMapping(value = "heroes/cadena/{cadena}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Heroes> buscarporCadena(@PathVariable String cadena) {
			return heroesService.buscarCadena(cadena);
	}
	
	@PostMapping(value = "heroes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Heroes crearHeroes(@RequestBody Heroes heroes) {
		heroes.setId_heroes(null);
		return heroesService.guardar(heroes);
	}

	 
	@PutMapping(value = "heroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Heroes actualizarHeroes(@PathVariable Integer id, @RequestBody Heroes heroes) {
		heroes.setId_heroes(id);
		return heroesService.guardar(heroes);
	}
	
	@DeleteMapping(value = "heroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarHeroes(@PathVariable Integer id) {
		heroesService.eliminar(id);
	}
	

	@GetMapping(value = "heroes/actualizarmuerto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Heroes actualizarEstado(@PathVariable Integer id) {
		return heroesService.guardarAMuerto(id);
	}

}
