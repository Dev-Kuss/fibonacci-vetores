package com.example.technicalTest.controller;

import com.example.technicalTest.dto.FaturamentoDTO;
import com.example.technicalTest.exception.FaturamentoNotFoundException;
import com.example.technicalTest.service.FaturamentoService;
import com.example.technicalTest.util.FaturamentoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/faturamento")
@Tag(name = "Faturamento", description = "API para gerenciamento de faturamento")
public class FaturamentoController {
    
    @Autowired
    private FaturamentoService faturamentoService;

    @Operation(summary = "Obtém o menor valor de faturamento")
    @GetMapping("/menor")
    public double getMenorValor() {
        return faturamentoService.menorValor();
    }

    @Operation(summary = "Obtém o maior valor de faturamento")
    @GetMapping("/maior")
    public double getMaiorValor() {
        return faturamentoService.maiorValor();
    }

    @Operation(summary = "Obtém a quantidade de dias com faturamento acima da média")
    @GetMapping("/dias-acima-media")
    public long getDiasAcimaMedia() {
        return faturamentoService.diasAcimaMedia();
    }

    @Operation(summary = "Adiciona um novo faturamento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Faturamento salvo com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public FaturamentoDTO adicionarFaturamento(@RequestBody FaturamentoDTO dto) {
        return FaturamentoMapper.toDTO(faturamentoService.salvarFaturamento(FaturamentoMapper.toEntity(dto)));
    }

    @Operation(summary = "Obtém um faturamento por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Faturamento encontrado"),
        @ApiResponse(responseCode = "404", description = "Faturamento não encontrado")
    })
    @GetMapping("/{id}")
    public FaturamentoDTO obterFaturamento(@PathVariable Long id) {
        return faturamentoService.obterFaturamento(id)
            .map(FaturamentoMapper::toDTO)
            .orElseThrow(() -> new FaturamentoNotFoundException("Faturamento não encontrado com ID: " + id));
    }

    @Operation(summary = "Adiciona múltiplos faturamentos em lote")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Faturamentos salvos com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping("/bulk")
    public List<FaturamentoDTO> adicionarFaturamentoEmLote(@RequestBody List<FaturamentoDTO> dtos) {
        return dtos.stream()
                .map(FaturamentoMapper::toEntity)
                .map(faturamentoService::salvarFaturamento)
                .map(FaturamentoMapper::toDTO)
                .collect(Collectors.toList());
    }
}