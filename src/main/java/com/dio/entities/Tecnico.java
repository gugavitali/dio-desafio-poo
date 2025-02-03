package com.dio.entities;

import com.dio.service.ChamadoService;

import java.util.List;

/**
 * A classe Tecnico representa um usuário do tipo Técnico no sistema de suporte técnico.
 * O técnico pode resolver chamados, visualizar chamados ordenados e atualizar o status dos chamados.
 */
public class Tecnico extends Usuario {

    /**
     * Construtor da classe Tecnico.
     *
     * @param telefone  o número de telefone do técnico
     * @param email     o e-mail do técnico
     * @param nome      o nome do técnico
     */
    public Tecnico(String telefone, String email, String nome) {
        super(telefone, email, nome); // Chama o construtor da classe pai (Usuario)
    }

    /**
     * Método para resolver um chamado, fornecendo a solução.
     * O chamado será fechado após a solução ser registrada.
     *
     * @param service  o serviço de chamados utilizado para fechar o chamado
     * @param chamado  o chamado a ser resolvido
     * @param solucao  a solução do problema relatado no chamado
     */
    public void resolverChamado(ChamadoService service, Chamado chamado, String solucao) {
        // Chama o serviço para fechar o chamado com a solução fornecida
        service.fecharChamado(chamado.getId(), solucao);
    }

    /**
     * Método para visualizar os chamados do técnico, ordenados por prioridade.
     * Exibe todos os chamados, caso existam.
     *
     * @param chamadosService  o serviço de chamados, utilizado para listar os chamados
     */
    public void visualizarChamados(ChamadoService chamadosService) {
        // Obtém a lista de chamados ordenados por prioridade
        List<Chamado> chamadosOrdenados = chamadosService.listarChamadosOrdenados();

        // Verifica se existem chamados para exibir
        if (chamadosOrdenados.isEmpty()) {
            System.out.println("\nLista de chamados vazia.");
            return;
        }

        // Exibe os chamados ordenados
        System.out.println("\nChamados ordenados por prioridade");
        chamadosOrdenados.forEach(System.out::println);
    }

    /**
     * Método para atualizar o status de um chamado para "Em andamento" e adicionar uma observação técnica.
     *
     * @param chamados  o serviço de chamados, utilizado para buscar e atualizar o chamado
     * @param id        o ID do chamado a ser atualizado
     * @param observacao a observação do técnico para o chamado
     */
    public void atualizarChamados(ChamadoService chamados, int id, String observacao) {
        // Busca o chamado pelo ID
        Chamado atualizacao = chamados.buscarChamadoPorId(id);

        // Atualiza o status e a observação do chamado
        atualizacao.setStatus("Em andamento");
        atualizacao.setObservacaoTecnico(observacao);

        // Exibe o chamado atualizado
        System.out.println(atualizacao);
    }
}
