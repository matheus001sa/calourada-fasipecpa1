package controle;

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

import modelo.DataAccessObject;
import modelo.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/login", "/insert", "/main", "/report"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1l;
	DataAccessObject dao = new DataAccessObject();
	JavaBeans ingressos = new JavaBeans();

    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		String action = requisicao.getServletPath();
		System.out.println(action);
		
		if (action.equals("/login")) {
			logarSistema(requisicao, resposta);
		} else if (action.equals("/insert")) {
			cadastrarIngresso(requisicao, resposta);
		} else if (action.equals("/main")) {
			historicoIngressos(requisicao, resposta);
		} else if (action.equals("/report")) {
			gerarRelatorio(requisicao, resposta);
		}
	}
	
	protected void logarSistema(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		String usuario = requisicao.getParameter("usuario");
		String senha = requisicao.getParameter("senha");
		
		if (usuario.equals("admincalourada") && senha.equals("Xkq60!2L@çmjZZ!J-")) {
			resposta.sendRedirect("ingressos.jsp");
		} else {
			resposta.sendRedirect("index.html");
		}
	}
	
	protected void cadastrarIngresso(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		ingressos.setNumeracao(requisicao.getParameter("numeracao"));
		
		String retornoStatus = dao.insertInto(ingressos);
		requisicao.setAttribute("resposta", retornoStatus);
		
		RequestDispatcher rD = requisicao.getRequestDispatcher("ingressos.jsp");
		rD.forward(requisicao, resposta);
	}
	
	protected void historicoIngressos(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.ordenarIngressos();
		requisicao.setAttribute("ordenarBilhetes", lista);
		
		RequestDispatcher rD = requisicao.getRequestDispatcher("historico.jsp");
		rD.forward(requisicao, resposta);
	}
	
	protected void gerarRelatorio(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		Document documento = new Document();
		
		try {
			resposta.setContentType("application/pdf");
			resposta.addHeader("Content-Disposition", "inline; filename=" + "ingressos.pdf");
			PdfWriter.getInstance(documento, resposta.getOutputStream());
			
			documento.open();
			documento.add(new Paragraph("Lista de ingressos:"));
			documento.add(new Paragraph("Total de ingressos vendidos:"));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(2);
			PdfPCell coluna1 = new PdfPCell(new Paragraph("Numeração"));
			PdfPCell coluna2 = new PdfPCell(new Paragraph("Data/Hora"));
			
			tabela.addCell(coluna1);
			tabela.addCell(coluna2);
			
			ArrayList<JavaBeans> lista = dao.ordenarIngressos();
			
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNumeracao());
				tabela.addCell(lista.get(i).getDatahora());
			}
			documento.add(tabela);
			documento.close();
			
		} catch (Exception erro) {
			System.out.println(erro);
			documento.close();
		}
	}
}
