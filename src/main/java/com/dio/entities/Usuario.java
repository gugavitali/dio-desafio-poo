package com.dio.entities;

import com.dio.service.ChamadoService;

import java.util.Objects;

/**
 * A classe abstrata Usuario representa um usuário do sistema, com informações essenciais como nome, email e telefone.
 * Todos os usuários do sistema herdam dessa classe e devem implementar o método visualizarChamados.
 */
public abstract class Usuario {

    // Atributos do usuário
    private String nome;
    private String email;
    private String telefone;

    /**
     * Construtor da classe Usuario.
     * Inicializa os atributos nome, email e telefone do usuário.
     *
     * @param telefone o número de telefone do usuário
     * @param email    o e-mail do usuário
     * @param nome     o nome do usuário
     */
    public Usuario(String telefone, String email, String nome) {
        setTelefone(telefone);
        setEmail(email);
        setNome(nome);
    }

    // Métodos getter e setter

    /**
     * Obtém o nome do usuário.
     *
     * @return o nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome o nome do usuário
     * @throws IllegalArgumentException se o nome for nulo
     */
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Defina um nome válido para o usuário.");
        }
    }

    /**
     * Obtém o e-mail do usuário.
     *
     * @return o e-mail do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do usuário.
     *
     * @param email o e-mail do usuário
     * @throws IllegalArgumentException se o e-mail for nulo
     */
    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Defina um e-mail válido para o usuário.");
        }
    }

    /**
     * Obtém o número de telefone do usuário.
     *
     * @return o número de telefone do usuário
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o número de telefone do usuário.
     *
     * @param telefone o número de telefone do usuário
     * @throws IllegalArgumentException se o telefone for nulo
     */
    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.trim().isEmpty()) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Defina um telefone válido para o usuário.");
        }
    }

    /**
     * Compara dois objetos Usuario para verificar se são iguais.
     * A comparação é feita com base nos atributos nome, email e telefone.
     *
     * @param object o objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true; // Verifica se é o mesmo objeto
        if (object == null || getClass() != object.getClass()) return false; // Verifica se o tipo é o mesmo
        Usuario usuario = (Usuario) object;
        return Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(telefone, usuario.telefone); // Compara os atributos principais
    }

    /**
     * Gera um código hash para o objeto Usuario, baseado nos atributos nome, email e telefone.
     *
     * @return o código hash gerado
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone); // Gera o código hash com base nos atributos
    }

    /**
     * Retorna uma representação em String do objeto Usuario.
     * A string contém os atributos nome, email e telefone do usuário.
     *
     * @return a representação em String do objeto Usuario
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    /**
     * Método abstrato que deve ser implementado pelas classes filhas para visualizar os chamados do usuário.
     * Cada tipo de usuário pode ter uma implementação diferente desse método.
     *
     * @param chamados o serviço de chamados a ser utilizado
     */
    public abstract void visualizarChamados(ChamadoService chamados);
}
