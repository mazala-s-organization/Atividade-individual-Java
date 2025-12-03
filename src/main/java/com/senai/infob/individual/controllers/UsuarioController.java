package com.senai.infob.individual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.individual.models.Usuario;
import com.senai.infob.individual.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;
    
    
    @PostMapping("/login")
    public Usuario login(@RequestParam String email,@RequestParam String senha) {
        return usuarioService.login(email, senha);
    }
    
    @PostMapping("/cadastro")
    public Usuario cadastro(@RequestBody Usuario usuario, @RequestParam String confirmarSenha) {
        return usuarioService.cadastrarUsuario(usuario, confirmarSenha);
    }
    @GetMapping("/buscar/{id}")
    public Usuario buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }
    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if(usuarioService.atualizar(usuario, id)) {
            return usuario;
        }
        return null;
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        Boolean deletou = usuarioService.delete(id);
        if (deletou) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover o usuário";
    }


}