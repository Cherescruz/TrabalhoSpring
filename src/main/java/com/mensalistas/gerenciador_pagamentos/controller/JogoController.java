/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensalistas.gerenciador_pagamentos.controller;

/**
 *
 * @author MASTER
 */
import com.mensalistas.gerenciador_pagamentos.model.Jogo;
import com.mensalistas.gerenciador_pagamentos.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    public List<Jogo> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jogo criar(@RequestBody Jogo j) {
        return service.criar(j);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(
            @PathVariable Long id,
            @RequestBody Jogo jDados) {
        try {
            Jogo atualizado = service.atualizar(id, jDados);
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
