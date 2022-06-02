package com.qriculum.qriculum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qriculum.qriculum.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
