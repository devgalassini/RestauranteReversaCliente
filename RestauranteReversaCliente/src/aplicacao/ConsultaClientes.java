package aplicacao;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.List;

import javax.swing.JOptionPane;

import dao.ClientesDao;
import entidades.Clientes;
import enumerados.TipoConsulta;

public class ConsultaClientes {

	public static void main(String[] args) {
		while (true) {
			try {
				TipoConsulta opcao = (TipoConsulta) showInputDialog(null, "Escolha uma opção", "Opções", DEFAULT_OPTION,
						null, TipoConsulta.values(), TipoConsulta.LISTAR);

				switch (opcao) {
				case LISTAR:
					listar();
					break;
				case BUSCAR:
					buscar();
					break;
				case SAIR:
					System.out.println("--Saindo do Sistema--");
				default:
					System.exit(0);
				}

			} catch (Exception e) {
				showMessageDialog(null, "Erro: " + e.getMessage());
				e.printStackTrace();
			}
			System.out.println("-------------");
			int opcao = showConfirmDialog(null, "Deseja continuar ?", "Confirmação", JOptionPane.YES_NO_OPTION);
			if (opcao != JOptionPane.YES_OPTION)
				break;
		}
	}

	private static void buscar() throws Exception {
		int id = parseInt(showInputDialog("Informe o ID:"));
		Clientes cliente = new ClientesDao().buscarCliente(id);
		if (cliente == null) {
			System.out.println("Nenhum cliente com esse ID");
		} else {
			System.out.println(cliente);
		}
	}

	private static void listar() throws Exception {
		List<Clientes> clientes = new ClientesDao().listarClientes();
		clientes.forEach(c -> System.out.println(c.mostraAtributos()));
	}
}
