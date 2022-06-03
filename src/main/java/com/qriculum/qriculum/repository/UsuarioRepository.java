package com.qriculum.qriculum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.qriculum.qriculum.beans.Usuario;



public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	@Query("{usuario: ?0, contrasenia: ?1}")
    //@Query("{$and :[{author: ?0},{cost: ?1}] }")
    Usuario getUsuarioByUsuarioAndContrasenia(String usuario, String contrasenia);
	
}
