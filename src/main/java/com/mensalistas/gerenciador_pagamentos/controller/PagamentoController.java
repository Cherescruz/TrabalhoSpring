/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensalistas.gerenciador_pagamentos.controller;

/**
 *
 * @author MASTER
 */
import com.mensalistas.gerenciador_pagamentos.model.Pagamento;
import com.mensalistas.gerenciador_pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public List<Pagamento> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento p) {
        return service.criar(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(
            @PathVariable Long id,
            @RequestBody Pagamento pDados) {
        try {
            Pagamento atualizado = service.atualizar(id, pDados);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
