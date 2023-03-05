package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Dao {

	//usada para manter a conex�o com o banco de dados
	protected Connection cn;
	
	//usado para realizar opera��oes no banco de dados
	protected PreparedStatement stmt;
	
	//usado para referenciar consultas
	protected ResultSet rs;
	
	//string de conexao
	private String conexao = "jdbc:mysql://localhost:3306/db_pedidos?useSSL=false";

	// Metodo usado para abrir a conex�o
	protected void abrirConexao() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection(conexao, "root", "Galassini@22");
	}

	protected void fecharConexao() throws Exception{
		if (cn !=null && !cn.isClosed()){
			cn.close();
		}
	}
}
