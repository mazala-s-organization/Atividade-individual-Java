package com.senai.infob.individual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.individual.models.Endereco;
import com.senai.infob.individual.models.Usuario;
import com.senai.infob.individual.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

 
    public Usuario cadastrarUsuario(Usuario usuario, String confirmarSenha) {
        if (!usuario.getSenha().equals(confirmarSenha)) {
            return null;
        }

        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return null;
        }

        if (!usuario.getSenha().equals(senha)) {
            System.out.println("Senha incorreta!");
            return null;
        }

        return usuario;
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).get();
    }

     public Boolean  delete(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        if(usuario != null) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public boolean atualizar(Usuario usuario, Integer id) {
        Usuario usu = usuarioRepository.findById(id).get();
        if (usu != null) {
            usuario.setId(id);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }
}