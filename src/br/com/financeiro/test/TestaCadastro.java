package br.com.financeiro.test;

import java.util.Calendar;

import br.com.financeiro.dao.ContaDao;
import br.com.financeiro.model.Conta;
import br.com.financeiro.model.TipoConta;

public class TestaCadastro {

	public static void main(String[] args) {
		
		ContaDao cad = new ContaDao();
		
		Conta conta = new Conta();
		
		Calendar c = Calendar.getInstance();
		
		TipoConta tipo = TipoConta.CORRENTE;
		
		
		
		conta.setNome("Luis");
		conta.setAgencia("09876");
		conta.setBanco("Bradesco");
		conta.setDataCadastro(c);
		conta.setNumero("123");
		conta.setStatus(true);
		conta.setTipoConta(TipoConta.POUPANCA);
		
		cad.cadastra(conta);
		
		
	}
	
}
