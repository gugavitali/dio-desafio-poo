package com.dio.entities;

import com.dio.service.ChamadoService;


public class Cliente extends Usuario{

    public Cliente(String telefone, String email, String nome){
        super(telefone, email, nome);
    }

    public Chamado abrirChamado(ChamadoService service, String prioridade, String descricao, Cliente solicitante, Tecnico responsavel){
        return service.abrirChamado(prioridade, descricao, solicitante, responsavel);
    }

    public void visualizarChamados(ChamadoService chamados){
        String str = "";
        str += "\nChamados ordenados por ordem de inserção\n";
        str += chamados.getChamados();
        System.out.println(str);
    }

}
