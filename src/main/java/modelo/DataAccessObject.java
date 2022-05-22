package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataAccessObject {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/calourada?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "Axq76665pB22269";
	
	private Connection conectar() {
		Connection conexao = null;
		
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch (Exception erro) {
			System.out.println(erro);
			return null;
		}
	}
	
	public String insertInto(JavaBeans ingressos) {
		String insert = "INSERT INTO ingressos (numeracao) VALUES (?)";
		String resposta;
		
		try {
			Connection conexao = conectar();
			PreparedStatement prepararConsulta = conexao.prepareStatement(insert);
			
			prepararConsulta.setString(1, ingressos.getNumeracao());
			prepararConsulta.executeUpdate();
			conexao.close();
			
			resposta = "[SUCESSO] Ingresso cadastrado no sistema!";
			return resposta;
		} catch (Exception erro) {
			System.out.println(erro);
			resposta = "[ERRO] Ingresso já cadastrado no sistema!";
			return resposta;
		}
	}
	
	public ArrayList<JavaBeans> ordenarIngressos() {
		ArrayList<JavaBeans> ordenarBilhetes = new ArrayList<>();
		String read = "SELECT * FROM ingressos ORDER BY numeracao";
		
		try {
			Connection conexao = conectar();
			PreparedStatement prepararConsulta = conexao.prepareStatement(read);
			ResultSet resultSet = prepararConsulta.executeQuery();
			
			while (resultSet.next()) {
				String numeracao = resultSet.getString(1);
				String datahora = resultSet.getString(2);
				
				ordenarBilhetes.add(new JavaBeans(numeracao, datahora));
			}
			conexao.close();
			return ordenarBilhetes;
			
		} catch (Exception erro) {
			System.out.println(erro);
			return null;
		}
	}
}