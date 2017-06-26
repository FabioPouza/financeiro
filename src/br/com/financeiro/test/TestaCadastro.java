package br.com.financeiro.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	
		List<CategoriaLancamentoCaixa> desc = daoC.consulta();
		ArrayList<Object> id = new ArrayList<>();
		
		CategoriaLancamentoCaixa cat = desc.get(0);
		
		for (CategoriaLancamentoCaixa c : desc){			
			id.add(c.getId());
		}
		System.out.println(id.get(0));
		
		ContaDao contaDao = new ContaDao();
		
		List<Conta> conta = contaDao.consulta();
		ArrayList<Object> idC = new ArrayList<>();
		
		Conta con = conta.get(0);
		
		for (Conta c : conta){			
			idC.add(c.getId());
		}
		System.out.println(idC.get(0));
		//System.out.println(daoC.consulta());

		
		LancamentoCaixa lancamento = new LancamentoCaixa();
//		
//		CategoriaLancamentoCaixa cattegoria = new CategoriaLancamentoCaixa();
//		
		LancamentoDao dao = new LancamentoDao();
//		
//		ContaDao daoConta = new ContaDao();
//		
//		cattegoria.setDescricao("TestaLancamento");
//		daoC.cadastra(cattegoria);
//		
//		Conta conta = new Conta();
//		conta.setAgencia("testeLancamento");
//		
//		daoConta.cadastra(conta);
//		
		Calendar calendar = Calendar.getInstance();
//		
		lancamento.setCategoriaLancamentoCaixa(cat);
		lancamento.setConta(con);
		lancamento.setData(calendar);
		lancamento.setDescricao("Buscando do banco");
		lancamento.setFormaPagamento(TipoFormaPagamento.CHEQUE);
		lancamento.setTipoLancamentoCaixa(TipoLancamentoCaixa.ENTRADA);
		lancamento.setValor(20);
		dao.cadastra(lancamento);
	}
	
}
