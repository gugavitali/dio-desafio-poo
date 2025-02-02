package com.dio.service;

import com.dio.entities.*;
import jdk.dynalink.linker.ConversionComparator;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChamadoService {

    private List<Chamado> chamados = new ArrayList<>(); //Para visualizar em ordem de inserção
    private Queue<Chamado> filaPrioridade = new PriorityQueue<>(
            Comparator.comparingInt((Chamado c) -> getPrioridadeValue(c.getPrioridade()))
                    .thenComparing(Chamado::getContadorId) // Ordena pelo ID em caso de empate
                    .reversed()
    );
    private static int getPrioridadeValue(String prioridade) {
        return switch (prioridade.toUpperCase()) {
            case "ALTA" -> 2;
            case "BAIXA" -> 1;
            default -> 0;
        };
    }
    private Map<Integer, Chamado> mapaChamados = new HashMap<>();//Buscar os chamados por ID
    private List<Chamado> chamadosFechados = new ArrayList<>();

    public Chamado abrirChamado(String prioridade, String descricao, Cliente solicitante, Tecnico responsavel){
        Chamado chamado = new Chamado(prioridade, descricao, solicitante, responsavel);

        chamados.add(chamado);
        filaPrioridade.add(chamado);
        mapaChamados.put(chamado.getContadorId(), chamado);

        System.out.println("Chamado criado com sucesso! ID: " + chamado.getContadorId());

        return chamado;
    }


    public String getChamados() {
        return chamados.stream()
                .map(Chamado::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getChamadosTec() {
        return filaPrioridade.stream()
                .map(Chamado::toString)  // Converte cada chamado para o formato desejado
                .collect(Collectors.joining("\n"));  // Junta as representações dos chamados com quebras de linha
    }

    public void fecharChamado(int id, String solucao) {
        Chamado chamadoFechado = mapaChamados.get(id); // Busca pelo ID

        if (chamadoFechado != null) {
            chamadoFechado.setSolucao(solucao); // Define a solução
            chamadoFechado.setStatus("FECHADO"); // Atualiza o status

            chamados.remove(chamadoFechado); // Remove da lista geral
            filaPrioridade.remove(chamadoFechado); // Remove da fila de prioridade
            mapaChamados.remove(id); // Remove do mapa
            chamadosFechados.add(chamadoFechado); // Adiciona na lista de fechados

            System.out.println("Chamado fechado com sucesso! ID: " + id);
        } else {
            System.out.println("Chamado não encontrado! ID: " + id);
        }
    }



}
