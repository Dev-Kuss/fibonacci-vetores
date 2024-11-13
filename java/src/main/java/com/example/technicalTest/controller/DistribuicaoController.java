package com.example.technicalTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicalTest.dto.DistribuicaoDTO;
import com.example.technicalTest.service.DistribuicaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/distribuicao")
@Tag(name = "Distribuição", description = "API para cálculo de distribuição percentual por estado")
public class DistribuicaoController {

    @Autowired
    private DistribuicaoService distribuicaoService;

    @Operation(summary = "Calcula a distribuição percentual do faturamento por estado")
    @GetMapping
    public List<DistribuicaoDTO> calcularDistribuicao() {
        return distribuicaoService.calcularDistribuicao();
    }
}