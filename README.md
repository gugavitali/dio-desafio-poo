# Sistema de Gestão de Chamados de Suporte Técnico

Este é um projeto de um Sistema de Gestão de Chamados de Suporte Técnico desenvolvido utilizando Java e Collections. O sistema permite que clientes abram chamados, técnicos sejam atribuídos a esses chamados e solucionem problemas, enquanto administradores podem gerenciar chamados e usuários.

## Funcionalidades

- **Clientes**:
  - Abrir e fechar chamados.
  - Acompanhar o status dos chamados.

- **Técnicos**:
  - Visualizar chamados atribuídos.
  - Resolver chamados e registrar soluções.

- **Administradores**:
  - Visualizar todos os chamados.
  - Atribuir técnicos aos chamados.
  - Gerenciar usuários (técnicos e clientes).

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada.
- **Collections**: Utilização de `ArrayList`, `HashMap` e `Queue` para armazenar dados e gerenciar chamados.

## Estrutura do Projeto

- `com/dio/entities/`: Contém as classes de entidades como Cliente, Tecnico, Administrador e Chamado.
- `com/dio/service/`: Contém as classes de serviço como ChamadoService e UsuarioService, responsáveis pela lógica de negócios.
- `com/dio/Main.java`: Ponto de entrada principal do programa, onde o menu e a interação com o usuário acontecem.
