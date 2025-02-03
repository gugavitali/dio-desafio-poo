package com.dio.entities;

import com.dio.service.ChamadoService;

/**
 * A classe Cliente representa um usuário do tipo Cliente no sistema de suporte técnico.
 * O cliente pode abrir chamados e visualizar os chamados em que está envolvido.
 */
public class Cliente extends Usuario {

    /**
     * Construtor da classe Cliente.
     *
     * @param telefone  o número de telefone do cliente
     * @param email     o e-mail do cliente
     * @param nome      o nome do cliente
     */
    public Cliente(String telefone, String email, String nome) {
        super(telefone, email, nome); // Chama o construtor da classe pai (Usuario)
    }

    /**
     * Método para abrir um novo chamado através do ChamadoService.
     *
     * @param service      o serviço de chamados utilizado para abrir o chamado
     * @param prioridade   a prioridade do chamado (ALTA ou BAIXA)
     * @param descricao    a descrição do problema relatado
     * @param solicitante  o cliente que está criando o chamado
     * @param responsavel  o técnico responsável pelo atendimento do chamado
     * @return             o objeto Chamado criado
     */
    public Chamado abrirChamado(ChamadoService service, String prioridade, String descricao, Cliente solicitante, Tecnico responsavel) {
        // Chama o serviço para abrir um novo chamado e retorna o objeto Chamado gerado
        return service.abrirChamado(prioridade, descricao, solicitante, responsavel);
    }

    /**
     * Método para visualizar os chamados do cliente, ordenados por ordem de inserção.
     *
     * @param chamados  o serviço de chamados, utilizado para obter a lista de chamados
     */
    public void visualizarChamados(ChamadoService chamados) {
        // Constrói uma string com todos os chamados
        String str = "\nChamados ordenados por ordem de inserção\n" + chamados.getChamados();
        // Exibe os chamados no console
        System.out.println(str);
    }
}
