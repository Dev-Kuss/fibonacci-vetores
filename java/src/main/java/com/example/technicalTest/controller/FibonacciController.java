package com.example.technicalTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicalTest.service.FibonacciService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/fibonacci")
@Tag(name = "Fibonacci", description = "API para cálculos com sequência de Fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @Operation(summary = "Verifica se um número pertence à sequência de Fibonacci")
    @GetMapping("/verificar/{numero}")
    public String verificarNumero(
            @Parameter(description = "Número a ser verificado") 
            @PathVariable long numero) {
        return fibonacciService.verificarNumero(numero);
    }

    @Operation(summary = "Gera a sequência de Fibonacci até um limite")
    @GetMapping("/sequencia/{limite}")
    public List<Long> gerarSequencia(
            @Parameter(description = "Limite máximo para a sequência") 
            @PathVariable long limite) {
        return fibonacciService.gerarSequencia(limite);
    }
}
