package com.dio;

import com.dio.entities.*;
import com.dio.service.ChamadoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ChamadoService chamadoService = new ChamadoService();

        // Criando alguns usuários
        Cliente cliente1 = new Cliente("1234-5678", "cliente1@email.com", "Cliente 1");
        Cliente cliente2 = new Cliente("9876-5432", "cliente2@email.com", "Cliente 2");
        Tecnico tecnico1 = new Tecnico("1111-2222", "tecnico1@email.com", "Técnico 1");
        Tecnico tecnico2 = new Tecnico("3333-4444", "tecnico2@email.com", "Técnico 2");
        Administrador admin = new Administrador("5555-6666", "admin@email.com", "Admin");

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar Chamado");
            System.out.println("2 - Atribuir Chamado");
            System.out.println("3 - Visualizar Chamados (Administrador)");
            System.out.println("4 - Visualizar Chamados (Técnico)");
            System.out.println("5 - Resolver Chamado");
            System.out.println("6 - Fechar Chamado");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // limpar a entrada inválida
            }
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1: {
                    System.out.print("Digite a prioridade do chamado (ALTA/BAIXA): ");
                    String prioridade = scanner.nextLine();
                    System.out.print("Digite a descrição do chamado: ");
                    String descricao = scanner.nextLine();
                    cliente1.abrirChamado(chamadoService, prioridade, descricao, cliente1, tecnico1);
                    break;
                }

                case 2: {
                    System.out.print("Digite o ID do chamado: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Chamado chamado = chamadoService.buscarChamadoPorId(id);
                    if (chamado != null) {
                        System.out.print("Digite o nome do técnico responsável: ");
                        String nomeTecnico = scanner.nextLine();
                        Tecnico tecnicoResponsavel = buscarTecnicoPorNome(nomeTecnico, tecnico1, tecnico2);

                        if (tecnicoResponsavel != null) {
                            admin.atribuirChamado(chamado, tecnicoResponsavel);
                        } else {
                            System.out.println("Técnico não encontrado.");
                        }
                    } else {
                        System.out.println("Chamado não encontrado.");
                    }
                    break;
                }

                case 3: {
                    admin.visualizarChamados(chamadoService);
                    break;
                }

                case 4: {
                    tecnico1.visualizarChamados(chamadoService);
                    break;
                }

                case 5: {
                    System.out.print("Digite o ID do chamado para resolver: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Chamado chamadoResolver = chamadoService.buscarChamadoPorId(id);
                    if (chamadoResolver != null) {
                        System.out.print("Digite a solução: ");
                        String solucao = scanner.nextLine();
                        tecnico1.resolverChamado(chamadoService, chamadoResolver, solucao);
                    } else {
                        System.out.println("Chamado não encontrado.");
                    }
                    break;
                }

                case 6: {
                    System.out.print("Digite o ID do chamado para fechar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Chamado chamadoFechar = chamadoService.buscarChamadoPorId(id);
                    if (chamadoFechar != null) {
                        System.out.print("Digite a solução para fechar o chamado: ");
                        String solucao = scanner.nextLine();
                        chamadoService.fecharChamado(id, solucao);
                    } else {
                        System.out.println("Chamado não encontrado.");
                    }
                    break;
                }

                case 7: {
                    System.out.println("Saindo...");
                    break;
                }

                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 7);
    }

    /**
     * Método para buscar um técnico pelo nome.
     *
     * @param nomeTecnico o nome do técnico a ser buscado
     * @param tecnico1    o primeiro técnico
     * @param tecnico2    o segundo técnico
     * @return o técnico encontrado ou null caso não exista
     */
    public static Tecnico buscarTecnicoPorNome(String nomeTecnico, Tecnico tecnico1, Tecnico tecnico2) {
        if (nomeTecnico.equals(tecnico1.getNome())) {
            return tecnico1;
        } else if (nomeTecnico.equals(tecnico2.getNome())) {
            return tecnico2;
        }
        return null;
    }
}
