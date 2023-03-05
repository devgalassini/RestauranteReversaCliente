package entidades;


import java.io.Serializable;
import java.util.List;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String email;
	private List<Pedidos> pedidos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pedidos> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	@Override
	public String toString() {
		return String.format("%s - %s", id, nome, email, pedidos);
	}
	public String mostraAtributos() {
		return String.format("Reservas\n \nID: %s \nNOME: %s  \nE-MAIL: %s  \nPEDIDOS: %s\n", id, nome, email, pedidos);
	}
	
	
}
