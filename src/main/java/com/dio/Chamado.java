package com.dio;

import java.time.LocalDateTime;
import java.util.Optional;

public class Chamado {
    private static int contadorId=1;
    private String status;
    private String prioridade;
    private String descricao;
    private Optional<String> solucao;
    private Responsavel solicitante;
    private Responsavel responsavel;
    private LocalDateTime abertura;
    private LocalDateTime prazoMaximo;

    public Chamado(String prioridade, String descricao, Optional<String> solucao, Responsavel solicitante, Responsavel responsavel) {
        contadorId++;

        this.status = "EM ESPERA";

        if (isPrioridadeValida(prioridade)) {
            this.prioridade = prioridade.toUpperCase();
        } else {
            throw new IllegalArgumentException("Prioridade inválida! Use ALTA, MÉDIA ou BAIXA.");
        }

        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("A descrição não pode estar vazia.");
        }

        if (solucao.isPresent()) {
            this.solucao = solucao;
        } else {
            this.solucao = Optional.empty();
        }

        if (solicitante != null) {
            this.solicitante = solicitante;
        } else {
            throw new IllegalArgumentException("O solicitante não pode ser nulo.");
        }

        if (responsavel != null) {
            this.responsavel = responsavel;
        } else {
            throw new IllegalArgumentException("O responsavel não pode ser nulo.");
        }

        this.abertura = LocalDateTime.now();

        if (responsavel instanceof Tecnico) {
            Tecnico tecnico = (Tecnico) responsavel;
            this.prazoMaximo = abertura.plusDays(tecnico.calcularRETORNO_PADRAO());
        } else {
            this.prazoMaximo = abertura.plusDays(7);
        }

    }

    private boolean isPrioridadeValida(String prioridade) {
        return prioridade != null &&
                (prioridade.equalsIgnoreCase("ALTA") ||
                        prioridade.equalsIgnoreCase("MÉDIA") ||
                        prioridade.equalsIgnoreCase("BAIXA"));
    }

    private boolean isStatusValido(String status) {
        return status != null &&
                (status.equalsIgnoreCase("ABERTO") ||
                        status.equalsIgnoreCase("EM ANDAMENTO") ||
                        status.equalsIgnoreCase("FECHADO"));
    }
}
