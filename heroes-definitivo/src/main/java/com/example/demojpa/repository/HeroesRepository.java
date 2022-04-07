package com.example.demojpa.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demojpa.model.Heroes;

public interface HeroesRepository extends JpaRepository<Heroes, Integer>{

  
	@Query(nativeQuery=true,value = "select * from heroes h where h.nombre ilike CONCAT('%',:nombre,'%')")
	public List<Heroes> findByCadena(@Param(value = "nombre") String nombre);
	
	
	//añadimos ilike debido a que no sabemos si el usuario a añadido su estado en mayusculas o minusculas
	@Query(nativeQuery = true,value = "select * from heroes h where h.estado ilike '%Vivo%'")
   	public List<Heroes> findByEstadoVivo();
	
	//añadimos ilike debido a que no sabemos si el usuario a añadido su estado en mayusculas o minusculas
	@Query(nativeQuery = true,value = "select * from heroes h where h.estado ilike '%Muerto'")
	public List<Heroes> findByEstadoMuerto();

		
}
