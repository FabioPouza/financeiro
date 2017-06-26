package br.com.financeiro.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.financeiro.dao.ContaDao;
import br.com.financeiro.model.Conta;

/**
 * Servlet implementation class ConsultaConta
 */
@WebServlet("/ConsultaConta")
public class ConsultaConta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultaConta() {
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

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		ContaDao dao = new ContaDao();

		TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
		
		List<Conta> desc = dao.consulta();

		JSONArray conta = new JSONArray();
		JSONObject contas = new JSONObject();
		SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");

		for (Conta c : desc) {
			JSONObject json = new JSONObject();
			json.put("ID", c.getId());
			json.put("NOME", c.getNome());
			json.put("NUMERO", c.getNumero());
			json.put("AGENCIA", c.getAgencia());
			json.put("BANCO", c.getBanco());
			String date = s.format(c.getDataCadastro().getTime());	
			json.put("DATA", date);
			json.put("TIPO", c.getTipoConta());
			json.put("STATUS", c.getStatus());

			conta.put(json);
		}
		contas.put("CONTAS", conta);
		System.out.println(contas);
		out.print(conta.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
