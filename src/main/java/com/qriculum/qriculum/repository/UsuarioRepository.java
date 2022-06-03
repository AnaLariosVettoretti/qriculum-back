package com.qriculum.qriculum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.qriculum.qriculum.beans.Usuario;



public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
