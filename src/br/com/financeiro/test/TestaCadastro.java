package br.com.financeiro.test;

import br.com.financeiro.dao.CategoriaDao;
import br.com.financeiro.model.CategoriaLancamentoCaixa;

public class TestaCadastro {

	public static void main(String[] args) {
		
		CategoriaLancamentoCaixa categoria = new CategoriaLancamentoCaixa();
		
		categoria.setDescricao("Educação");
		
		CategoriaDao cad = new CategoriaDao();
		
		cad.cadastra(categoria);
		
	}
	
}
