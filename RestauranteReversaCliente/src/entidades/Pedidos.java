package entidades;

import java.util.Date;

public class Pedidos {

	private int id;
	private int Responsavel;
	private Date data;
	private String descricao;
	private double preco;
	private  int idCliente;
	
	

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getResponsavel() {
		return Responsavel;
	}

	public void setResponsavel(int responsavel) {
		Responsavel = responsavel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return String.format("Pedidos\n \nID: %s \nIDCLIENTES: %s \nDATA: %s \nDESCRIÇÃO DO PEDIDO: %s \nPRECO PRECO DO PRODUTO: %s\n", id, Responsavel, data,
				descricao, preco);
	}

}
