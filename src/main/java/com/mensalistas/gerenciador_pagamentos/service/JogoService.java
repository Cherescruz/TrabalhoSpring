/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensalistas.gerenciador_pagamentos.service;

/**
 *
 * @author MASTER
 */
import com.mensalistas.gerenciador_pagamentos.model.Jogo;
import com.mensalistas.gerenciador_pagamentos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepo;

    public List<Jogo> listarTodos() {
        return jogoRepo.findAll();
    }

    public Optional<Jogo> buscarPorId(Long id) {
        return jogoRepo.findById(id);
    }

    public Jogo criar(Jogo j) {
        return jogoRepo.save(j);
    }

    public Jogo atualizar(Long id, Jogo jDados) {
        return jogoRepo.findById(id)
            .map(j -> {
                j.setData(jDados.getData());
                j.setLocal(jDados.getLocal());
                j.setDescricao(jDados.getDescricao());
                return jogoRepo.save(j);
            })
            .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    public void deletar(Long id) {
        jogoRepo.deleteById(id);
    }
}
