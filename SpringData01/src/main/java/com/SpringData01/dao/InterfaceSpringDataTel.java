package com.SpringData01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.SpringData01.model.Telefone;

public interface InterfaceSpringDataTel extends CrudRepository<Telefone, Long>{

	//métodos customizados 
	/*@Query(value = "select t from telefone t where t.usuario_id like %?1%")
	public List<Telefone> buscaPorKey(Long id);*/
}
