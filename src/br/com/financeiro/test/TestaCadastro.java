package br.com.financeiro.test;

import java.util.Calendar;

import br.com.financeiro.dao.Cadastrar;
import br.com.financeiro.model.Conta;
import br.com.financeiro.model.TipoConta;

public class TestaCadastro {

	public static void main(String[] args) {
		
		Cadastrar cad = new Cadastrar();
		
		Conta conta = new Conta();
		
		Calendar c = Calendar.getInstance();
		
		TipoConta tipo = TipoConta.CORRENTE;
		
		
		
		conta.setNome("Lucas");
		conta.setAgencia("09876");
		conta.setBanco("Bradesco");
		conta.setDataCadastro(c);
		conta.setNumero("123");
		conta.setStatus(1);
		conta.setTipoConta(TipoConta.POUPANCA);
		
		cad.cadastra(conta);
		
		
	}
	
}
