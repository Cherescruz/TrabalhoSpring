/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensalistas.gerenciador_pagamentos.repository;

/**
 *
 * @author MASTER
 */

import com.mensalistas.gerenciador_pagamentos.model.Mensalista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensalistaRepository extends JpaRepository<Mensalista, Long> {
}

