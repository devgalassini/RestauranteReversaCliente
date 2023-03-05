package aplicacao;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import dao.ClientesDao;
import entidades.Clientes;

public class CadastroClientes {

	public static void main(String[] args) {
		while (true) {
			try {
				int id = parseInt(showInputDialog("Informe o ID:"));
				String nome = showInputDialog("Informe o nome:");
				String email = showInputDialog("Informe o email:");

				Clientes cliente = new Clientes();
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setEmail(email);

				new ClientesDao().incluirCliente(cliente);

				showMessageDialog(null, "Cliente incluido com sucesso!");
			} catch (Exception e) {
				showMessageDialog(null, "Erro: " + e.getMessage());
				e.printStackTrace();
			}
			int opcao = showConfirmDialog(null, "Deseja continuar incluindo clientes?", "Confirmação",
					JOptionPane.YES_NO_OPTION);
			if (opcao != JOptionPane.YES_OPTION)
				break;
		}
	}
}
