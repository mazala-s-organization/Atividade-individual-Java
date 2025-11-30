package com.senai.infob.individual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.individual.models.Endereco;
import com.senai.infob.individual.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

   public long count() {
        return enderecoRepository.count();
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Boolean  delete(Integer id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        if(endereco != null) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Endereco buscarPorId(Integer id) {
        return enderecoRepository.findById(id).get();
    }
    
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public boolean atualizar(Endereco endereco, Integer id) {
        Endereco end = buscarPorId(id);
        if (end != null) {
            endereco.setId(id);
            enderecoRepository.save(endereco);
            return true;
        }
        return false;
    }
}