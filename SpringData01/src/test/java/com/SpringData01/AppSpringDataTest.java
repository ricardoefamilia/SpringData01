package com.SpringData01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringData01.dao.InterfaceSpringDataUser;
import com.SpringData01.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

	//interface para realizar os métodos de CRUD do spring.
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		//System.out.println("Iniciou o Spring com sucesso!!!");
		Usuario usuario = new Usuario();
		usuario.setEmail("ricardo@gmail.com");
		usuario.setIdade(51);
		//usuario.setId(1L);
		usuario.setLogin("ricardo");
		usuario.setNome("Ricardo Lima Amaral");
		usuario.setSenha("r1234");
		
		interfaceSpringDataUser.save(usuario);
		
		//System.out.println("Cadastrados: " + interfaceSpringDataUser.count());
	}
	
}
