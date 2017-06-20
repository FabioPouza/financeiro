package br.com.financeiro.test;

import java.util.Calendar;

import br.com.financeiro.dao.CategoriaDao;
import br.com.financeiro.dao.ContaDao;
import br.com.financeiro.dao.LancamentoDao;
import br.com.financeiro.model.CategoriaLancamentoCaixa;
import br.com.financeiro.model.Conta;
import br.com.financeiro.model.LancamentoCaixa;
import br.com.financeiro.model.TipoFormaPagamento;
import br.com.financeiro.model.TipoLancamentoCaixa;

public class TestaCadastro {

	public static void main(String[] args) {
		
		//CategoriaLancamentoCaixa categoria = new CategoriaLancamentoCaixa();
		
		//categoria.setDescricao("Educação");
		
		//CategoriaDao cad = new CategoriaDao();
		
		//cad.cadastra(categoria);
		
		CategoriaDao daoC = new CategoriaDao();
//		
//		System.out.println(dao.consulta());
		
		LancamentoCaixa lancamento = new LancamentoCaixa();
		
		CategoriaLancamentoCaixa cattegoria = new CategoriaLancamentoCaixa();
		
		LancamentoDao dao = new LancamentoDao();
		
		ContaDao daoConta = new ContaDao();
		
		cattegoria.setDescricao("TestaLancamento");
		daoC.cadastra(cattegoria);
		
		Conta conta = new Conta();
		conta.setAgencia("testeLancamento");
		
		daoConta.cadastra(conta);
		
		Calendar calendar = Calendar.getInstance();
		
		lancamento.setCategoriaLancamentoCaixa(cattegoria);
		lancamento.setConta(conta);
		lancamento.setData(calendar);
		lancamento.setDescricao("TESTE");
		lancamento.setFormaPagamento(TipoFormaPagamento.CHEQUE);
		lancamento.setTipoLancamentoCaixa(TipoLancamentoCaixa.ENTRADA);
		lancamento.setValor(20);
		dao.cadastra(lancamento);
	}
	
}
