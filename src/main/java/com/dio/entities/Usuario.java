package com.dio.entities;

import com.dio.service.ChamadoService;

import java.util.List;
import java.util.Objects;

public abstract class Usuario {
    private String nome;
    private String email;
    private String telefone;

    public Usuario(String telefone, String email, String nome) {
        setTelefone(telefone);
        setEmail(email);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Defina um nome para o usuário.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Defina um e-mail para o usuário.");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null){
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Defina um telefone para o usuário.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public abstract void visualizarChamados(ChamadoService chamados);
}
