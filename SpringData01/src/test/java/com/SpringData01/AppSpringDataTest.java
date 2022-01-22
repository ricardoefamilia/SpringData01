package com.SpringData01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringData01.dao.InterfaceSpringDataUser;
import com.SpringData01.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	//interface para realizar os métodos de CRUD do spring.
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;

	@Test
	public void testeInsert() {

		Usuario usuario = new Usuario();

		usuario.setEmail("ricardo@gmail.com");
		usuario.setIdade(31);
		usuario.setLogin("ricardo");
		usuario.setSenha("r123");
		usuario.setNome("Ricardo Lima Amaral");

		interfaceSpringDataUser.save(usuario);

		System.out.println("Usuarios cadastrados -> " + interfaceSpringDataUser.count());

	}

	
}
