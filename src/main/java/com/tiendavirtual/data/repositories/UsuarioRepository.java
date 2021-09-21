package com.tiendavirtual.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.data.models.Usuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Long>{
	List<Usuario> findAll();

	Usuario findByEmail(String email);
}
