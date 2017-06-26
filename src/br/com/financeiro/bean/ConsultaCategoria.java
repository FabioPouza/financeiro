package br.com.financeiro.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.financeiro.dao.CategoriaDao;
import br.com.financeiro.model.CategoriaLancamentoCaixa;

/**
 * Servlet implementation class ConsultaCategoria
 */
@WebServlet("/ConsultaCategoria")
public class ConsultaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		CategoriaDao dao = new CategoriaDao();
		
		List<CategoriaLancamentoCaixa> cat = dao.consulta();
		JSONObject categoria = new JSONObject();
		JSONArray categorias = new JSONArray();

		for(CategoriaLancamentoCaixa c : cat){
			JSONObject json = new JSONObject();
			json.put("ID", c.getId());
			json.put("DESCRICAO", c.getDescricao());
			categorias.put(json);
		}
		out.print(categorias.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

}
