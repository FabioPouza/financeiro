package br.com.financeiro.test;

import br.com.financeiro.model.Conta;
import br.com.financeiro.model.TipoConta;

public class TestaEnum {

	
	
	public static void escolhe(TipoConta tipo) {

		Conta conta = new Conta();
		
		if (tipo == TipoConta.CORRENTE) {

			System.out.println(tipo.getConta());
			
			
		} else {

			System.out.println("Poupança");
		}

	}
	
	public static void main(String[] args) {
		escolhe(TipoConta.CORRENTE);
	}

}
