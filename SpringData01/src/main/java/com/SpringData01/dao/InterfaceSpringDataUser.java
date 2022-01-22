package com.SpringData01.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.SpringData01.model.Usuario;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<Usuario, Long>{	
	
}
