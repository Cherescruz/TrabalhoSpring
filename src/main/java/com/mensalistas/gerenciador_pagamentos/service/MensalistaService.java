/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensalistas.gerenciador_pagamentos.service;

/**
 *
 * @author MASTER
 */

import com.mensalistas.gerenciador_pagamentos.model.Mensalista;
import com.mensalistas.gerenciador_pagamentos.repository.MensalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensalistaService {

    @Autowired
    private MensalistaRepository mensalistaRepo;

    public List<Mensalista> listarTodos() {
        return mensalistaRepo.findAll();
    }

    public Optional<Mensalista> buscarPorId(Long id) {
        return mensalistaRepo.findById(id);
    }

    public Mensalista criar(Mensalista m) {
        return mensalistaRepo.save(m);
    }

    public Mensalista atualizar(Long id, Mensalista mDados) {
        return mensalistaRepo.findById(id)
            .map(m -> {
                m.setNome(mDados.getNome());
                m.setTelefone(mDados.getTelefone());
                m.setEmail(mDados.getEmail());
                m.setStatusAtivo(mDados.isStatusAtivo());
                return mensalistaRepo.save(m);
            })
            .orElseThrow(() -> new RuntimeException("Mensalista não encontrado"));
    }

    public void deletar(Long id) {
        mensalistaRepo.deleteById(id);
    }
}

