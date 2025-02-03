package com.dio.service;

import com.dio.entities.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela gestão dos chamados. Permite a criação, atualização, fechamento e visualização de chamados.
 */
public class ChamadoService {

    // Lista para armazenar os chamados na ordem de inserção
    private List<Chamado> chamados = new ArrayList<>();
    // Mapa para buscar chamados por ID
    private Map<Integer, Chamado> mapaChamados = new HashMap<>();
    // Lista para armazenar os chamados fechados
    private List<Chamado> chamadosFechados = new ArrayList<>();

    /**
     * Abre um novo chamado no sistema.
     * O chamado será adicionado à lista de chamados e ao mapa de chamados por ID.
     *
     * @param prioridade  a prioridade do chamado
     * @param descricao   a descrição do chamado
     * @param solicitante o cliente que solicita o chamado
     * @param responsavel o técnico responsável pelo chamado
     * @return o chamado criado
     */
    public Chamado abrirChamado(String prioridade, String descricao, Cliente solicitante, Tecnico responsavel) {
        Chamado chamado = new Chamado(prioridade, descricao, solicitante, responsavel);

        chamados.add(chamado);
        mapaChamados.put(chamado.getId(), chamado);

        System.out.println("Chamado criado com sucesso! ID: " + chamado.getId());

        return chamado;
    }

    /**
     * Retorna todos os chamados em formato de String.
     * Se não houver chamados, retorna uma mensagem informando que a lista está vazia.
     *
     * @return lista de chamados em formato String
     */
    public String getChamados() {
        if (chamados.isEmpty()) {
            return "Lista de chamados vazia.";
        } else {
            return chamados.stream()
                    .map(Chamado::toString)
                    .collect(Collectors.joining("\n"));
        }
    }

    /**
     * Retorna a lista de chamados ordenados por prioridade.
     * A prioridade é um valor numérico, sendo que os chamados com maior prioridade aparecem primeiro.
     *
     * @return lista de chamados ordenada por prioridade
     */
    public List<Chamado> listarChamadosOrdenados() {
        List<Chamado> chamadosOrdenados = new ArrayList<>(chamados);
        chamadosOrdenados.sort(Comparator.comparingInt(Chamado::getPrioridadeNumerica));
        return chamadosOrdenados;
    }

    /**
     * Retorna todos os chamados fechados em formato de String.
     * Se não houver chamados fechados, retorna uma mensagem informando que a lista está vazia.
     *
     * @return lista de chamados fechados em formato String
     */
    public String getChamadosFechados() {
        if (chamadosFechados.isEmpty()) {
            return "Lista de chamados fechados vazia.";
        } else {
            return chamadosFechados.stream()
                    .map(Chamado::toString)
                    .collect(Collectors.joining("\n"));
        }
    }

    /**
     * Busca um chamado pelo ID.
     *
     * @param id o ID do chamado a ser buscado
     * @return o chamado encontrado, ou null se não encontrado
     */
    public Chamado buscarChamadoPorId(int id) {
        return mapaChamados.get(id);
    }

    /**
     * Atualiza um chamado, alterando seu status para "Em andamento" e adicionando uma observação técnica.
     *
     * @param id          o ID do chamado a ser atualizado
     * @param observacao  a observação a ser registrada no chamado
     */
    public void atualizarChamados(int id, String observacao) {
        Chamado atualizacao = buscarChamadoPorId(id);
        if (atualizacao != null) {
            atualizacao.setStatus("Em andamento");
            atualizacao.setObservacaoTecnico(observacao);
            System.out.println(atualizacao);
        } else {
            System.out.println("Chamado não encontrado! ID: " + id);
        }
    }

    /**
     * Fecha um chamado, definindo sua solução e alterando o status para "FECHADO".
     * O chamado é removido da lista de chamados e adicionado à lista de chamados fechados.
     *
     * @param id       o ID do chamado a ser fechado
     * @param solucao  a solução registrada para o chamado
     */
    public void fecharChamado(int id, String solucao) {
        Chamado chamadoFechado = buscarChamadoPorId(id);

        if (chamadoFechado != null) {
            chamadoFechado.setSolucao(solucao);
            chamadoFechado.setStatus("FECHADO");

            chamados.remove(chamadoFechado);
            mapaChamados.remove(id);
            chamadosFechados.add(chamadoFechado);

            System.out.println("Chamado fechado com sucesso! ID: " + id);
        } else {
            System.out.println("Chamado não encontrado! ID: " + id);
        }
    }
}
