package com.senai.infob.individual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infob.individual.models.Endereco;

@Repository
public interface  EnderecoRepository  extends JpaRepository<Endereco, Integer>  {

}