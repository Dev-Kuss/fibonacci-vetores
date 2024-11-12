package com.example.technicalTest.controller;

import com.example.technicalTest.dto.FaturamentoDTO;
import com.example.technicalTest.exception.FaturamentoNotFoundException;
import com.example.technicalTest.service.FaturamentoService;
import com.example.technicalTest.util.FaturamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faturamento")
public class FaturamentoController {
    
    @Autowired
    private FaturamentoService faturamentoService;

    @GetMapping("/menor")
    public double getMenorValor() {
        return faturamentoService.menorValor();
    }

    @GetMapping("/maior")
    public double getMaiorValor() {
        return faturamentoService.maiorValor();
    }

    @GetMapping("/dias-acima-media")
    public long getDiasAcimaMedia() {
        return faturamentoService.diasAcimaMedia();
    }

    @PostMapping
    public FaturamentoDTO adicionarFaturamento(@RequestBody FaturamentoDTO dto) {
        return FaturamentoMapper.toDTO(faturamentoService.salvarFaturamento(FaturamentoMapper.toEntity(dto)));
    }

    @GetMapping("/{id}")
    public FaturamentoDTO obterFaturamento(@PathVariable Long id) {
        return faturamentoService.obterFaturamento(id)
            .map(FaturamentoMapper::toDTO)
            .orElseThrow(() -> new FaturamentoNotFoundException("Faturamento não encontrado com ID: " + id));
    }
}