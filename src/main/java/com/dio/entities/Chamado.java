package com.dio.entities;

import java.time.LocalDateTime;

public class Chamado {
    private static int contadorId=0;
    private String status;
    private String prioridade;
    private String descricao;
    private String solucao;
    private Cliente solicitante;
    private Tecnico responsavel;
    private LocalDateTime abertura;
    private LocalDateTime prazoMaximo;

    public Chamado(String prioridade, String descricao, Cliente solicitante, Tecnico responsavel) {
        contadorId++;
        this.status = "EM ESPERA";
        setPrioridade(prioridade);
        setDescricao(descricao);
        setSolicitante(solicitante);
        setResponsavel(responsavel);
        this.abertura = LocalDateTime.now();
        this.prazoMaximo = abertura.plusDays(5);
    }

    private boolean isPrioridadeValida(String prioridade) {
        return prioridade != null &&
                (prioridade.equalsIgnoreCase("ALTA") ||
                        prioridade.equalsIgnoreCase("BAIXA"));
    }

    private boolean isStatusValido(String status) {
        return status != null &&
                (status.equalsIgnoreCase("ABERTO") ||
                        status.equalsIgnoreCase("EM ANDAMENTO") ||
                        status.equalsIgnoreCase("FECHADO"));
    }

    public int getContadorId() {
        return contadorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        if (isPrioridadeValida(prioridade)) {
            this.prioridade = prioridade.toUpperCase();
        } else {
            throw new IllegalArgumentException("Prioridade inválida! Use ALTA ou BAIXA.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("A descrição não pode estar vazia.");
        }
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        if (solucao != null) {
            this.solucao = solucao;
        } else {
            throw new IllegalArgumentException("A solução não deve está vazia.");
        }
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Cliente solicitante) {
        if (solicitante != null) {
            this.solicitante = solicitante;
        } else {
            throw new IllegalArgumentException("O solicitante não pode ser nulo.");
        }
    }

    public Tecnico getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Tecnico responsavel) {
        if (responsavel != null) {
            this.responsavel = responsavel;
        } else {
            throw new IllegalArgumentException("O responsavel não pode ser nulo.");
        }
    }

    public LocalDateTime getAbertura() {
        return abertura;
    }

    public LocalDateTime getPrazoMaximo() {
        return prazoMaximo;
    }

    @Override
    public String toString() {
        return "\nChamado: \n" +
                "-----------------------------------\n" +
                "Status       : " + status + "\n" +
                "Prioridade   : " + prioridade + "\n" +
                "Descrição    : " + descricao + "\n" +
                "Solução      : " + (solucao != null ? solucao : "Não resolvido") + "\n" +
                "Solicitante  : " + solicitante + "\n" +
                "Responsável  : " + responsavel + "\n" +
                "Abertura     : " + abertura + "\n" +
                "Prazo Máximo : " + prazoMaximo + "\n" +
                "-----------------------------------";
    }
}
