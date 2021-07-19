package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";

	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcadastropessoas?useTimezone=true&serverTimezone=UTC";

	/** The user. */
	private String user = "root";

	/** The password. */
	private String password = "@Ibimirim";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void cadastrarPessoa(PacienteDAO paciente) {
		String create = "insert into pessoa (nome,sus,tipo,data_nasc, fone) values (?,?,?,?,?)";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, paciente.getNome());
			pst.setString(2, paciente.getSus());
			pst.setString(3, paciente.getTipo());
			pst.setString(4, paciente.getData_nasc());
			pst.setString(5, paciente.getFone());;

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public ArrayList<PacienteDAO> listarPessoas(){
		ArrayList<PacienteDAO> pessoas = new ArrayList<>();
		String list = "select * from pessoa order by id";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(list);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString(1);		
				String nome = rs.getString(2);
				String sus = rs.getString(3);
				String tipo = rs.getString(4);
				String data_nasc = rs.getString(5);
				String fone = rs.getString(6);
			
				pessoas.add(new PacienteDAO(id,nome,sus,tipo,data_nasc,fone));
			
			}
			con.close();
			return pessoas;
			
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarContato(PacienteDAO paciente) {
		String list2 = "select * from pessoa where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(list2);
			pst.setString(1, paciente.getId());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				paciente.setId(rs.getString(1));
				paciente.setNome(rs.getString(2));
				paciente.setSus(rs.getString(3));
				paciente.setTipo(rs.getString(4));
				paciente.setData_nasc(rs.getString(5));
				paciente.setFone(rs.getString(6));
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editarContato(PacienteDAO paciente) {
		String alterar = "update pessoa set nome=?,sus=?,tipo=?,data_nasc=?,fone=? where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(alterar);
			pst.setString(1, paciente.getNome());
			pst.setString(2, paciente.getSus());
			pst.setString(3, paciente.getTipo());
			pst.setString(4, paciente.getData_nasc());
			pst.setString(5, paciente.getFone());
			pst.setString(6, paciente.getId());
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void removerPessoa(PacienteDAO paciente) {
		String deletar = "delete from pessoa where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(deletar);
			pst.setString(1, paciente.getId());
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void login(UsuarioDAO usuario) {
		String list3 = "select from usuario where usuario=? senha=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(list3);
			pst.setString(1, usuario.getUsuario());
			pst.setString(2, usuario.getSenha());
			ResultSet rs = pst.executeQuery();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
	}
	
	public ArrayList<PacienteDAO> listarPessoasAniversariantes(){
		ArrayList<PacienteDAO> pessoas1 = new ArrayList<>();
		String list1 = "SELECT * FROM pessoa WHERE MONTH(data_nasc) = MONTH(CURRENT_DATE()) and DAY(data_nasc) = DAY(current_date());";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(list1);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString(1);		
				String nome = rs.getString(2);
				String sus = rs.getString(3);
				String tipo = rs.getString(4);
				String data_nasc = rs.getString(5);
				String fone = rs.getString(6);
			
				pessoas1.add(new PacienteDAO(id,nome,sus,tipo,data_nasc,fone));
			
			}
			con.close();
			return pessoas1;
			
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
