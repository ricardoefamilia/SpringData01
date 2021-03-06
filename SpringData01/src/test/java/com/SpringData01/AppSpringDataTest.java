package com.SpringData01;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringData01.dao.InterfaceSpringDataTel;
import com.SpringData01.dao.InterfaceSpringDataUser;
import com.SpringData01.model.Telefone;
import com.SpringData01.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	// interface para realizar os métodos de CRUD do spring.
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceSpringDataTel interfaceSpringDataTel;

	@Test
	public void testeInsert() {

		Usuario usuario = new Usuario();

		usuario.setEmail("fernando@gmail.com");
		usuario.setIdade(33);
		usuario.setLogin("fernando");
		usuario.setSenha("f123");
		usuario.setNome("Fernando Nascimento Rodrigues");

		interfaceSpringDataUser.save(usuario);

		System.out.println("Usuarios cadastrados -> " + interfaceSpringDataUser.count());
		testeConsultaTodos();
	}

	@Test
	public void testeConsultaId() {
		Optional<Usuario> usuario = interfaceSpringDataUser.findById(3L);
		System.out.println("Nome: " + usuario.get().getNome());
		System.out.println("E-Mail: " + usuario.get().getEmail());
		System.out.println("Idade: " + usuario.get().getIdade());
		System.out.println("Código: " + usuario.get().getId());
		System.out.println("Login: " + usuario.get().getLogin());
	}

	@Test
	public void testeConsultaTodos() {
		Iterable<Usuario> lista = interfaceSpringDataUser.findAll();
		for (Usuario usuario : lista) {
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("E-Mail: " + usuario.getEmail());
			System.out.println("Idade: " + usuario.getIdade());
			System.out.println("Código: " + usuario.getId());
			System.out.println("Login: " + usuario.getLogin());
			
			for (Telefone telefone : usuario.getListaTel()) {
				System.out.println("Telefone: " + telefone.getNumero() + " (" + telefone.getTipo() + ").");
			}
			System.out.println();
			System.out.println("------------------------------------------");			
		}
	}

	@Test
	public void testeUpdate() {

		Optional<Usuario> usuarioOptional = interfaceSpringDataUser.findById(3L);
		Usuario usuario = usuarioOptional.get();

		usuario.setEmail("Alexandre@gmail.com");
		usuario.setIdade(52);
		usuario.setLogin("Alexandre");
		usuario.setSenha("a123");
		usuario.setNome("Alexandre Amaral");

		interfaceSpringDataUser.save(usuario);

		testeConsultaTodos();

	}

	@Test
	public void testeDelete() {
		/*
		 * Optional<Usuario> usuarioOptional = interfaceSpringDataUser.findById(3L);
		 * Usuario usuario = usuarioOptional.get();
		 * 
		 * interfaceSpringDataUser.delete(usuario);
		 */
		interfaceSpringDataUser.deleteById(1L);

		testeConsultaTodos();
	}

	@Test
	public void testeConsultaPorNome() {
		List<Usuario> lista = interfaceSpringDataUser.buscaPorNome("Alex");
		for (Usuario usuario : lista) {
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("E-Mail: " + usuario.getEmail());
			System.out.println("Idade: " + usuario.getIdade());
			System.out.println("Código: " + usuario.getId());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println();
		}
	}

	@Test
	public void testeConsultaUsuarioPorNome() {
		Usuario usuario = interfaceSpringDataUser.buscaUsuarioPorNomeParam("Ricardo Lima Amaral");
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("E-Mail: " + usuario.getEmail());
		System.out.println("Idade: " + usuario.getIdade());
		System.out.println("Código: " + usuario.getId());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println();
	}
	
	
	@Test
	public void testeDeletePorNome() {
		testeConsultaTodos();
		interfaceSpringDataUser.deletePorNome("Alex Amaral");
		System.out.println("------------------------------------------");
		testeConsultaTodos();
	}
	
	@Test
	public void testeUpdateEmailPorNome() {
		testeConsultaTodos();
		interfaceSpringDataUser.updateEmailPorNome("alexamaral@hotmail.com","Alex Amaral");
		System.out.println("------------------------------------------");

	}
	
	@Test
	public void testeInsertTelefone() {
		Optional<Usuario> usuario = interfaceSpringDataUser.findById(2L);
		
		Telefone telefone = new Telefone();
		telefone.setTipo("Trabalho");
		telefone.setNumero("(61)9998-8899");
		telefone.setUsuario(usuario.get());
		
		interfaceSpringDataTel.save(telefone);
		testeConsultaTodos();
		
	}
	
	@Test
	public void testeUpdateTelefone() {
		Optional<Telefone> telefoneOptional = interfaceSpringDataTel.findById(9L);
		Telefone telefone = telefoneOptional.get();

		Optional<Usuario> usuario = interfaceSpringDataUser.findById(2L);
		
		telefone.setTipo("Celular");
		telefone.setNumero("(61)9998-8899");
		telefone.setUsuario(usuario.get());

		interfaceSpringDataTel.save(telefone);

		testeConsultaTodos();
	}

}
