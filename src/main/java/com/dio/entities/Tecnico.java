package com.dio.entities;

import com.dio.service.ChamadoService;

import java.util.List;

public class Tecnico extends Usuario{

    public Tecnico(String telefone, String email, String nome) {
        super(telefone, email, nome);
    }

    public void resolverChamado(ChamadoService service, Chamado chamado, String solucao) {
        service.fecharChamado(chamado.getContadorId(), solucao);
    }

    public void visualizarChamados (ChamadoService chamados) {
        String str = "";
        str += "\nChamados ordenados por prioridade\n";
        str += chamados.getChamadosTec();
        /*str += "\nChamados ordenados por ordem de inserção\n";
        str += chamados.getChamados();*/
        System.out.println(str);
    }
}
