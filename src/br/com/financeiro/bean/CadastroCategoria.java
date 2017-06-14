package br.com.financeiro.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.financeiro.dao.CategoriaDao;
import br.com.financeiro.model.CategoriaLancamentoCaixa;

/**
 * Servlet implementation class CadastroCategoria
 */
@WebServlet("/CadastroCategoria")
public class CadastroCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroCategoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		request.setCharacterEncoding("UTF8");

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			/* report an error */ }

		try {
			JSONObject jsonObject = HTTP.toJSONObject(jb.toString());
			ObjectMapper mapper = new ObjectMapper();
			CategoriaLancamentoCaixa categoria = mapper.readValue(jb.toString(), CategoriaLancamentoCaixa.class);
			
			TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
			
			CategoriaDao cad = new CategoriaDao();
			cad.cadastra(categoria);
		} catch (JSONException e) {
			// crash and burn
			throw new IOException("Error parsing JSON request string");
		}

	}

}
