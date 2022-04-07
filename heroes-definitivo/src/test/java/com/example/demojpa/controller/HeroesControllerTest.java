package com.example.demojpa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demojpa.model.Heroes;
import com.example.demojpa.repository.HeroesRepository;
import com.example.demojpa.service.HeroesService;
import com.example.demojpa.service.impl.HeroesServiceImpl;
import com.example.demojpa.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class HeroesControllerTest {

    @InjectMocks
    HeroesController heroesController;
	
	@Mock
	HeroesService heroesService;
	

    @Test
	void obtenerHeroesTest() {
    	when(heroesService.listadoHeroes()).thenReturn(TestUtils.obtenerHeroes());
    	
    	List<Heroes> heroes = heroesController.listarHeroes();
    	assertTrue(!heroes.isEmpty());
	}
    
    
  @Test
	void obtenerHeroesIdTest() {
	  
	  Heroes heroeEsperado=new Heroes();
	
	  when(heroesService.obtenerHeroes(anyInt())).thenReturn(heroeEsperado);
  	
  	  Heroes heroes = heroesController.listarHeroes(anyInt());
  	  assertNotNull(heroes);
	}
    
   
    @Test
    void buscarPorEstadoVivoTest() {
	
    List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
	
	
	when(heroesService.buscarPorEstadoVivo()).thenReturn(resultadoEsperado);

	List<Heroes> heroesActual=heroesController.buscarporEstadoVivo();
	assertEquals(resultadoEsperado.get(0).getEstado(),"Vivo");
	
    }
	
    @Test
    void buscarPorEstadoMuertoTest() {
  	
    List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
  	
    when(heroesService.buscarPorEstadoMuerto()).thenReturn(resultadoEsperado);
  	
  
  	List<Heroes> heroesActual=heroesController.buscarporEstadoMuerto();
  	assertEquals(resultadoEsperado.get(1).getEstado(),"Muerto");
 }
    
    @Test
	void guardarTest() {
  	
  	List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
  	Heroes heroe=resultadoEsperado.get(0);
  	
  	Integer heroeIdEsperado = 1;
		
		when(heroesService.guardar(Mockito.any())).thenReturn(heroe);
		Heroes heroeActual =heroesController.crearHeroes(heroe);
		
		assertNotNull(heroeActual);
  }
     
    @Test
	void actualizarHeroeTest() {
  	
  	List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
  	Heroes heroe=resultadoEsperado.get(0);
  	
  	Integer heroeIdEsperado = 1;
		
		when(heroesService.guardar(Mockito.any())).thenReturn(heroe);
		heroe.setId_heroes(heroeIdEsperado);
		Heroes heroeActual =heroesController.actualizarHeroes(heroeIdEsperado, heroe);
		
		assertNotNull(heroeActual);
  }
  
   @Test
	void buscarCadenaTest() {
    List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
    String cadena="man";
	
	when(heroesService.buscarCadena(cadena)).thenReturn(resultadoEsperado);
	
	List<Heroes> heroesActual=heroesController.buscarporCadena(cadena);
		assertNotNull(heroesActual);
		assertTrue(heroesActual.size()>0);
}

    @Test
    void eliminarTest() {
	
        Integer heroeIdParam = Integer.valueOf("3");
      
        
        doNothing().when(heroesService).eliminar(heroeIdParam);
		heroesController.eliminarHeroes(heroeIdParam);
}

    @Test
	void guardarAMuertoTest() {
 
        	java.util.Optional<Heroes> heroe = TestUtils.obtenerHeroe();
        	heroe.get().setEstado("Muerto");
        	when(heroesService.guardarAMuerto(Mockito.any())).thenReturn(heroe.get());
        	
        	
        	Heroes heroeMuerto = heroesController.actualizarEstado(heroe.get().getId_heroes());
        	
  			assertEquals(heroeMuerto.getEstado(),"Muerto"); 
		
    }
    
    
}





