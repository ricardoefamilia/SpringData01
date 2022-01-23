package com.SpringData01.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SpringData01.model.Usuario;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<Usuario, Long>{	
	
	//métodos customizados 
	@Query(value = "select u from Usuario u where u.nome like %?1%")
	public List<Usuario> buscaPorNome(String nome);
	
	@Query(value = "select u from Usuario u where u.nome = :paramNome")
	public Usuario buscaUsuarioPorNomeParam(@Param("paramNome") String paramNome);
	
	//sobrescrevendo método, processando qq coisa antes de savar no BD
	default <S extends Usuario> S saveAtual(S entity) {
		//processa qq coisa
		return save(entity);
	}
	
	//modificar o BD e iniciar uma ação transactional
	@Modifying
	@Transactional
	@Query("delete from Usuario u where u.nome = ?1")
	public void deletePorNome(String nome);
	
	
	@Modifying
	@Transactional
	@Query("update Usuario set email = ?1 where nome = ?2")
	public void updateEmailPorNome(String email, String nome);
}
