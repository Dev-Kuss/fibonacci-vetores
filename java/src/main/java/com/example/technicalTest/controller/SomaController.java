package com.example.technicalTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicalTest.service.SomaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/soma")
@Tag(name = "Soma", description = "API para cálculo de soma sequencial")
public class SomaController {

    @Autowired
    private SomaService somaService;

    @Operation(summary = "Calcula a soma sequencial até o índice 13")
    @GetMapping
    public int calcularSoma() {
        return somaService.calcularSoma();
    }

    @Operation(summary = "Retorna o processo de cálculo detalhado")
    @GetMapping("/detalhado")
    public String calcularSomaDetalhada() {
        return somaService.calcularSomaDetalhada();
    }
} 