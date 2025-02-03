package com.dio.entities;

import java.time.LocalDateTime;

/**
 * Classe que representa um chamado técnico no sistema.
 * Cada chamado contém informações como prioridade, descrição,
 * status, solução e prazos.
 */
public class Chamado {
    private static int contadorId = 0; // Contador para geração de IDs únicos
    private int id;
    private String status;
    private String prioridade;
    private String descricao;
    private String solucao;
    private String observacaoTecnico;
    private Cliente solicitante;
    private Tecnico responsavel;
    private LocalDateTime abertura;
    private LocalDateTime prazoMaximo;

    /**
     * Construtor do chamado. Inicializa o chamado com prioridade, descrição,
     * solicitante e responsável, e define os campos de abertura e prazo máximo.
     *
     * @param prioridade A prioridade do chamado (ALTA ou BAIXA).
     * @param descricao A descrição do chamado.
     * @param solicitante O cliente que solicitou o chamado.
     * @param responsavel O técnico responsável pelo chamado.
     */
    public Chamado(String prioridade, String descricao, Cliente solicitante, Tecnico responsavel) {
        this.id = ++contadorId; // Gera um ID único para cada chamado
        this.status = "EM ESPERA"; // Status inicial do chamado
        setPrioridade(prioridade);
        setDescricao(descricao);
        setSolicitante(solicitante);
        setResponsavel(responsavel);
        this.abertura = LocalDateTime.now(); // Define a data de abertura como o momento atual
        this.prazoMaximo = abertura.plusDays(5); // Define o prazo máximo como 5 dias após a abertura
    }

    // Validações de dados
    private boolean isPrioridadeValida(String prioridade) {
        return prioridade != null &&
                (prioridade.equalsIgnoreCase("ALTA") || prioridade.equalsIgnoreCase("BAIXA"));
    }

    private boolean isStatusValido(String status) {
        return status != null &&
                (status.equalsIgnoreCase("ABERTO") ||
                        status.equalsIgnoreCase("EM ANDAMENTO") ||
                        status.equalsIgnoreCase("FECHADO"));
    }

    // Métodos de acesso (getters) e modificação (setters)

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Modifica o status do chamado, se válido.
     *
     * @param status O novo status (ABERTO, EM ANDAMENTO, FECHADO).
     * @throws IllegalArgumentException Se o status não for válido.
     */
    public void setStatus(String status) {
        if (isStatusValido(status)) {
            this.status = status.toUpperCase(); // Converte para maiúsculas
        } else {
            throw new IllegalArgumentException("Status inválido! Use ABERTO, EM ANDAMENTO ou FECHADO.");
        }
    }

    public String getPrioridade() {
        return prioridade;
    }

    /**
     * Modifica a prioridade do chamado, se válida.
     *
     * @param prioridade A nova prioridade (ALTA ou BAIXA).
     * @throws IllegalArgumentException Se a prioridade não for válida.
     */
    public void setPrioridade(String prioridade) {
        if (isPrioridadeValida(prioridade)) {
            this.prioridade = prioridade.toUpperCase(); // Converte para maiúsculas
        } else {
            throw new IllegalArgumentException("Prioridade inválida! Use ALTA ou BAIXA.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Modifica a descrição do chamado, se não for nula ou vazia.
     *
     * @param descricao A nova descrição.
     * @throws IllegalArgumentException Se a descrição for nula ou vazia.
     */
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

    /**
     * Modifica a solução do chamado, se válida.
     *
     * @param solucao A solução fornecida.
     * @throws IllegalArgumentException Se a solução for nula ou vazia.
     */
    public void setSolucao(String solucao) {
        if (solucao != null && !solucao.trim().isEmpty()) {
            this.solucao = solucao;
        } else {
            throw new IllegalArgumentException("A solução não pode estar vazia.");
        }
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    /**
     * Modifica o solicitante do chamado.
     *
     * @param solicitante O cliente solicitante do chamado.
     * @throws IllegalArgumentException Se o solicitante for nulo.
     */
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

    /**
     * Modifica o responsável pelo chamado.
     *
     * @param responsavel O técnico responsável pelo chamado.
     * @throws IllegalArgumentException Se o responsável for nulo.
     */
    public void setResponsavel(Tecnico responsavel) {
        if (responsavel != null) {
            this.responsavel = responsavel;
        } else {
            throw new IllegalArgumentException("O responsável não pode ser nulo.");
        }
    }

    public LocalDateTime getAbertura() {
        return abertura;
    }

    public LocalDateTime getPrazoMaximo() {
        return prazoMaximo;
    }

    public String getObservacaoTecnico() {
        return observacaoTecnico;
    }

    /**
     * Modifica a observação do técnico, se válida.
     *
     * @param observacaoTecnico A observação fornecida pelo técnico.
     * @throws IllegalArgumentException Se a observação for nula ou vazia.
     */
    public void setObservacaoTecnico(String observacaoTecnico) {
        if (observacaoTecnico != null && !observacaoTecnico.trim().isEmpty()) {
            this.observacaoTecnico = observacaoTecnico;
        } else {
            throw new IllegalArgumentException("A observação não pode estar vazia.");
        }
    }

    /**
     * Retorna uma representação em string detalhada do chamado.
     *
     * @return A string representando o chamado.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nChamado ID#").append(id).append("\n")
                .append("-----------------------------------\n")
                .append("Status       : ").append(status).append("\n")
                .append("Prioridade   : ").append(prioridade).append("\n")
                .append("Descrição    : ").append(descricao).append("\n")
                .append("Observação   : ").append(observacaoTecnico != null ? observacaoTecnico : "").append("\n")
                .append("Solução      : ").append(solucao != null ? solucao : "Não resolvido").append("\n")
                .append("Solicitante  : ").append(solicitante).append("\n")
                .append("Responsável  : ").append(responsavel).append("\n")
                .append("Abertura     : ").append(abertura).append("\n")
                .append("Prazo Máximo : ").append(prazoMaximo).append("\n")
                .append("-----------------------------------");
        return str.toString();
    }

    /**
     * Retorna a prioridade do chamado como um valor numérico, onde 1 é alta e 2 é baixa.
     *
     * @return O valor numérico da prioridade.
     */
    public int getPrioridadeNumerica() {
        return this.prioridade.equalsIgnoreCase("ALTA") ? 1 : 2;
    }
}
