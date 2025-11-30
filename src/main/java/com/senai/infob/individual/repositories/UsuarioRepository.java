package com.senai.infob.individual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.infob.individual.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value="select * from usuario where email = :email", nativeQuery = true)
    public Usuario findByEmail(String email);
}
