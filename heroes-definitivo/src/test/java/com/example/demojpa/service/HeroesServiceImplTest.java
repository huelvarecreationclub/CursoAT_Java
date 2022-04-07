package com.example.demojpa.service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class DemoJpaApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.example.demojpa.model.Heroes;
import com.example.demojpa.repository.HeroesRepository;
import com.example.demojpa.service.impl.HeroesServiceImpl;
import com.example.demojpa.utils.TestUtils;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@ExtendWith(MockitoExtension.class)
public class HeroesServiceImplTest {

    @InjectMocks
	HeroesServiceImpl heroesService;
	
	@Mock
	HeroesRepository heroesRepository;
	
	@Test
	void listadoHeroesTest() {
    	when(heroesRepository.findAll()).thenReturn(TestUtils.obtenerHeroes());
    	
    	List<Heroes> listaHeroes = heroesService.listadoHeroes();
    	assertTrue(!listaHeroes.isEmpty());
	}

    @Test
	void obtenerHeroesTest() {
    	when(heroesRepository.findById(anyInt())).thenReturn(TestUtils.obtenerHeroe());
    	
    	Heroes heroes = heroesService.obtenerHeroes(TestUtils.UNO);
    	assertNotNull(heroes); 
	}

    @Test
    void buscarPorEstadoVivoTest() {
    	
        List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
    	
    	when(heroesRepository.findByEstadoVivo()).thenReturn(resultadoEsperado);
    	
    
    	List<Heroes> heroesActual=heroesService.buscarPorEstadoVivo();
    	assertEquals(resultadoEsperado.get(0).getEstado(),"Vivo");
   }

    @Test
    void buscarPorEstadoMuertoTest() {
    	
        List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
    	
    	when(heroesRepository.findByEstadoMuerto()).thenReturn(resultadoEsperado);
    	
    
    	List<Heroes> heroesActual=heroesService.buscarPorEstadoMuerto();
    	assertEquals(resultadoEsperado.get(1).getEstado(),"Muerto");
   }
    

    @Test
	void guardarTest() {
    	
    	List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
    	Heroes heroe=resultadoEsperado.get(0);
    	
    	Integer heroeIdEsperado = 1;
		
	
		when(heroesRepository.save(Mockito.any())).thenReturn(heroe);
		Heroes heroeActual =heroesService.guardar(resultadoEsperado.get(0));
		
		assertNotNull(heroeActual);
		assertTrue(heroeActual.getId_heroes().intValue() > -1);
		assertEquals(heroeIdEsperado, heroeActual.getId_heroes());
    }

    @Test
	void buscarCadenaTest() {
        List<Heroes> resultadoEsperado=TestUtils.obtenerHeroes();
        String cadena="man";
    	
    	when(heroesRepository.findByCadena("man")).thenReturn(resultadoEsperado);
    	
    	List<Heroes> heroesActual=heroesService.buscarCadena("man");
		assertNotNull(heroesActual);
		assertTrue(heroesActual.size()>0);
    }
    
    @Test
    void eliminarTest() {
    	
        Integer heroeIdParam = Integer.valueOf("3");
      
        
        doNothing().when(heroesRepository).deleteById(Mockito.any());
		heroesService.eliminar(heroeIdParam);

    }
    
    @Test
	void guardarAMuertoTest() {
 
        	java.util.Optional<Heroes> heroe = TestUtils.obtenerHeroe();
        	when(heroesRepository.findById(Mockito.any())).thenReturn(heroe);
        	heroe.get().setEstado("Muerto");
        	when(heroesRepository.save(Mockito.any())).thenReturn(heroe.get());
        	
        	
        	Heroes heroeMuerto = heroesService.guardarAMuerto(heroe.get().getId_heroes());
        	
  			assertEquals(heroeMuerto.getEstado(),"Muerto");
		
    }

}
