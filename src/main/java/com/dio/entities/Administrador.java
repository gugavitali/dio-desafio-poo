package com.dio.entities;

import com.dio.service.ChamadoService;

import java.util.List;
import java.util.Scanner;

/**
 * Representa um usuário com permissões administrativas no sistema, permitindo
 * visualizar chamados e atribuir chamados a técnicos.
 */
public class Administrador extends Usuario {

    private static final Scanner scanner = new Scanner(System.in); // Scanner reutilizado

    /**
     * Construtor da classe Administrador. Inicializa os atributos herdados da classe Usuario.
     *
     * @param telefone O telefone do administrador.
     * @param email O email do administrador.
     * @param nome O nome do administrador.
     */
    public Administrador(String telefone, String email, String nome) {
        super(telefone, email, nome);
    }

    /**
     * Método que permite ao administrador visualizar os chamados em diferentes ordens e estados.
     * O usuário pode escolher entre visualizar os chamados em ordem de inserção, por prioridade ou
     * os chamados fechados.
     *
     * @param chamados Instância do serviço de chamados, responsável pela manipulação dos chamados.
     */
    @Override
    public void visualizarChamados(ChamadoService chamados) {
        int entrada;

        // Menu de opções para o administrador visualizar os chamados
        do {
            mostrarMenu();

            entrada = scanner.nextInt();
            processarOpcao(entrada, chamados);
        } while (entrada != 4); // O menu continua até que a opção 4 (sair) seja selecionada
    }

    /**
     * Exibe o menu de opções para o administrador.
     */
    private void mostrarMenu() {
        System.out.println("\nEscolha a visualização dos chamados:\n" +
                "1 - Em ordem de inserção\n" +
                "2 - Em ordem de prioridade\n" +
                "3 - Chamados fechados\n" +
                "4 - Sair");
    }

    /**
     * Processa a opção escolhida pelo administrador no menu.
     *
     * @param entrada A opção escolhida no menu.
     * @param chamados Instância do serviço de chamados, responsável pela manipulação dos chamados.
     */
    private void processarOpcao(int entrada, ChamadoService chamados) {
        switch (entrada) {
            case 1:
                exibirChamadosPorInsercao(chamados);
                break;
            case 2:
                exibirChamadosPorPrioridade(chamados);
                break;
            case 3:
                exibirChamadosFechados(chamados);
                break;
            case 4:
                break;
            default:
                System.out.println("\nInsira uma opção válida\n");
        }
    }

    /**
     * Exibe os chamados ordenados por ordem de inserção.
     *
     * @param chamados Instância do serviço de chamados.
     */
    private void exibirChamadosPorInsercao(ChamadoService chamados) {
        StringBuilder str = new StringBuilder("\nChamados ordenados por ordem de inserção\n");
        str.append(chamados.getChamados());
        System.out.println(str + "\n");
    }

    /**
     * Exibe os chamados ordenados por prioridade.
     *
     * @param chamados Instância do serviço de chamados.
     */
    private void exibirChamadosPorPrioridade(ChamadoService chamados) {
        List<Chamado> chamadosOrdenados = chamados.listarChamadosOrdenados();

        if (chamadosOrdenados.isEmpty()) {
            System.out.println("\nLista de chamados vazia.");
            return;
        }

        System.out.println("\nChamados ordenados por prioridade");
        chamadosOrdenados.forEach(System.out::println);
    }

    /**
     * Exibe os chamados fechados.
     *
     * @param chamados Instância do serviço de chamados.
     */
    private void exibirChamadosFechados(ChamadoService chamados) {
        StringBuilder str = new StringBuilder("\nChamados fechados\n");
        str.append(chamados.getChamadosFechados());
        System.out.println(str + "\n");
    }

    /**
     * Método responsável por atribuir um chamado a um técnico.
     *
     * @param chamado O chamado que será atribuído.
     * @param tecnico O técnico responsável pelo chamado.
     */
    public void atribuirChamado(Chamado chamado, Tecnico tecnico) {
        chamado.setResponsavel(tecnico); // Atribui o técnico responsável pelo chamado
        System.out.println(chamado.toString()); // Exibe o chamado atualizado
    }
}
