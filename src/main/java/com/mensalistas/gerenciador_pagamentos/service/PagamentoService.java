/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensalistas.gerenciador_pagamentos.service;

/**
 *
 * @author MASTER
 */
import com.mensalistas.gerenciador_pagamentos.model.Pagamento;
import com.mensalistas.gerenciador_pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepo;

    public List<Pagamento> listarTodos() {
        return pagamentoRepo.findAll();
    }

    public Optional<Pagamento> buscarPorId(Long id) {
        return pagamentoRepo.findById(id);
    }

    public Pagamento criar(Pagamento p) {
        return pagamentoRepo.save(p);
    }

    public Pagamento atualizar(Long id, Pagamento pDados) {
        return pagamentoRepo.findById(id)
            .map(p -> {
                p.setValor(pDados.getValor());
                p.setDataPagamento(pDados.getDataPagamento());
                p.setMensalista(pDados.getMensalista());
                p.setJogo(pDados.getJogo());
                return pagamentoRepo.save(p);
            })
            .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public void deletar(Long id) {
        pagamentoRepo.deleteById(id);
    }
}
