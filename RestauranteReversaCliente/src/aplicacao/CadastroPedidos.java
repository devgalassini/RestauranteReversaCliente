package aplicacao;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ClientesDao;
import dao.PedidosDao;
import entidades.Clientes;
import entidades.Pedidos;

public class CadastroPedidos {

	public static void main(String[] args) {
		List<Clientes> listaClientes = null;
		try {
			listaClientes = new ClientesDao().listarClientes();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			try {
				int id = parseInt(showInputDialog("Informe o ID do pedido:"));
				String dataStr = showInputDialog("Informe a data:");
				Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
				String descricao = showInputDialog("Informe a descrição:");
				double preco = parseDouble(showInputDialog("Informe o valor:"));

				Clientes cliente = (Clientes) showInputDialog(null, "Selecione o cliente", "Clientes", DEFAULT_OPTION,
						null, listaClientes.toArray(), null);

				Pedidos pedido = new Pedidos();
				pedido.setId(id);
				pedido.setData(data);
				pedido.setDescricao(descricao);
				pedido.setPreco(preco);
				pedido.setResponsavel(id);
				pedido.setIdCliente(cliente.getId());

				new PedidosDao().incluirCliente(pedido);

				showMessageDialog(null, "Pedido incluido com sucesso!");
			} catch (Exception e) {
				showMessageDialog(null, "Erro: " + e.getMessage());
				e.printStackTrace();
			}
			int opcao = showConfirmDialog(null, "Deseja continuar incluindo pedidos?", "Confirmação",
					JOptionPane.YES_NO_OPTION);
			if (opcao != JOptionPane.YES_OPTION)
				break;
		}
	}
}