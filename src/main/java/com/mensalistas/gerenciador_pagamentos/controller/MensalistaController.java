/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensalistas.gerenciador_pagamentos.controller;

/**
 *
 * @author MASTER
 */
import com.mensalistas.gerenciador_pagamentos.model.Mensalista;
import com.mensalistas.gerenciador_pagamentos.service.MensalistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensalistas")
public class MensalistaController {

    @Autowired
    private MensalistaService service;

    @GetMapping
    public List<Mensalista> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensalista> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mensalista criar(@RequestBody Mensalista m) {
        return service.criar(m);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensalista> atualizar(
            @PathVariable Long id,
            @RequestBody Mensalista mDados) {
        try {
            Mensalista atualizado = service.atualizar(id, mDados);
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