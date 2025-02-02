package com.dio.entities;

import com.dio.service.ChamadoService;

import java.util.List;

public class Administrador extends Usuario {

    public Administrador(String telefone, String email, String nome) {
        super(telefone, email, nome);
    }

    @Override
    public void visualizarChamados(ChamadoService chamados) {

    }

    public void atribuirChamado(Chamado chamado, Tecnico tecnico){

    }
}
