import com.dio.entities.Chamado;
import com.dio.entities.Cliente;
import com.dio.entities.Tecnico;
import com.dio.entities.Usuario;
import com.dio.service.ChamadoService;

public class Main {

    public static void main(String[] args) {
        ChamadoService ChamadosService = new ChamadoService();

        Cliente Cli = new Cliente("(19) 90000-0000", "cliente@gmail.com", "Cli");
        System.out.println(Cli.toString());

        Tecnico Tec = new Tecnico("(19) 91111-1111", "tecnico@gmail.com", "Tec");
        System.out.println(Tec.toString());

        Chamado chamado1 = Cli.abrirChamado(ChamadosService, "alta", "Teste 1", Cli, Tec);
        Chamado chamado2 = Cli.abrirChamado(ChamadosService, "baixa", "SLA", Cli, Tec);
        Chamado chamado3 = Cli.abrirChamado(ChamadosService, "alta", "Teste 3", Cli, Tec);

        Tec.visualizarChamados(ChamadosService);

        Tec.resolverChamado(ChamadosService, chamado2, "Reinstalação do software resolveu o problema.");

        Tec.visualizarChamados(ChamadosService);
    }
}
