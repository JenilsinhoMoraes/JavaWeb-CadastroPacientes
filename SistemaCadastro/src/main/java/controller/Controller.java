package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.PacienteDAO;
import model.UsuarioDAO;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert","/select", "/update", "/delete", "/report", "/lista","/login", "/listaAniversariante"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	PacienteDAO paciente = new PacienteDAO();
    UsuarioDAO usuario = new UsuarioDAO();
   
    public Controller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			listar(request, response);
			
		}else if (action.equals("/insert")) {
			novopessoa(request, response);
			
		}else if (action.equals("/select")) {
			listarPessoa(request, response);
			
		}else if (action.equals("/update")) {
			editarPessoa(request, response);
			
		}else if (action.equals("/delete")) {
			removerPessoa(request, response);
			
		}else if (action.equals("/report")) {
			gerarRelatorio(request, response);
			
		}else if (action.equals("/lista")) {
			listar2(request, response);
			
		}else if (action.equals("/login")) {
			login(request, response);
			
		}else if (action.equals("/listaAniversariante")) {
			listar3(request, response);
			
		}else {
			response.sendRedirect("index.html");
		}
		
	}
	//Listar pessoas
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PacienteDAO> lista = dao.listarPessoas();
		request.setAttribute("listar", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	}
	
	protected void listar2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PacienteDAO> lista1 = dao.listarPessoas();
		request.setAttribute("listar2", lista1);
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
	}
	protected void novopessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("sus"));
		//System.out.println(request.getParameter("obs"));
		//System.out.println(request.getParameter("data_nasc"));
		
		paciente.setNome(request.getParameter("nome"));
		paciente.setSus(request.getParameter("sus"));
		paciente.setTipo(request.getParameter("tipo"));
		paciente.setData_nasc(request.getParameter("data_nasc"));
		paciente.setFone(request.getParameter("fone"));
		
		dao.cadastrarPessoa(paciente);
		
		response.sendRedirect("lista");
		
	
	}
	protected void listarPessoa(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String id = request.getParameter("id");
		
		paciente.setId(id);
		
		dao.selecionarContato(paciente);
		
		request.setAttribute("id", paciente.getId());
		request.setAttribute("nome", paciente.getNome());
		request.setAttribute("sus", paciente.getSus());
		request.setAttribute("tipo", paciente.getTipo());
		request.setAttribute("data_nasc", paciente.getData_nasc());
		request.setAttribute("fone", paciente.getFone());
		
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
	
	}
	
	protected void editarPessoa(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		paciente.setId(request.getParameter("id"));
		paciente.setNome(request.getParameter("nome"));
		paciente.setSus(request.getParameter("sus"));
		paciente.setTipo(request.getParameter("tipo"));
		paciente.setData_nasc(request.getParameter("data_nasc"));
		paciente.setFone(request.getParameter("fone"));
		
		dao.editarContato(paciente);
		
		response.sendRedirect("lista");
		
		
		
	}
	
	protected void removerPessoa(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String id = request.getParameter("id");
		
		paciente.setId(id);
		
		dao.removerPessoa(paciente);
		
		response.sendRedirect("lista");
		
		
	}
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Document documento = new Document();
		
		
		try {
			response.setContentType("application/pdf");
			
			response.addHeader("content-Disposition", "inline; filename=" + "pessoas.pdf");
			
			PdfWriter.getInstance(documento, response.getOutputStream());
			
			documento.open();
			
			documento.add(new Paragraph("                                                             Relatório de cadastro"));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(5);
			PdfPCell coluna1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell coluna2 = new PdfPCell(new Paragraph("Sus"));
			PdfPCell coluna3 = new PdfPCell(new Paragraph("Tipo"));
			PdfPCell coluna4 = new PdfPCell(new Paragraph("Data de Nascimento"));
			PdfPCell coluna5 = new PdfPCell(new Paragraph("Fone"));
			
			tabela.addCell(coluna1);
			tabela.addCell(coluna2);
			tabela.addCell(coluna3);
			tabela.addCell(coluna4);
			tabela.addCell(coluna5);
			
			ArrayList<PacienteDAO> lista = dao.listarPessoas();
			
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getSus());
				tabela.addCell(lista.get(i).getTipo());
				tabela.addCell(lista.get(i).getData_nasc());
				tabela.addCell(lista.get(i).getFone());
				
				
				
				
				
			}
			
			
			
			documento.add(tabela);
			
			
			
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
		
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
			String id = request.getParameter("id");
		
			paciente.setId(id);
		
			dao.login(usuario);
		
			request.setAttribute("id", usuario.getId());
			request.setAttribute("nome", usuario.getNome());
			request.setAttribute("usuario", usuario.getUsuario());
			request.setAttribute("senha", usuario.getSenha());
			
			if ((request.getParameter("usuario")).equals((usuario.getUsuario())) && (request.getParameter("senha")).equals(usuario.getSenha())) {
				
			
			
			RequestDispatcher rd = request.getRequestDispatcher("main");
			rd.forward(request, response);
			}
	}
	
	protected void listar3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PacienteDAO> lista2 = dao.listarPessoasAniversariantes();
		request.setAttribute("listar3", lista2);
		RequestDispatcher rd = request.getRequestDispatcher("listaAniversariantes.jsp");
		rd.forward(request, response);
	}
	
}
