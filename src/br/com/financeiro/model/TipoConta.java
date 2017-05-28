package br.com.financeiro.model;

public enum TipoConta {

	CORRENTE(1),
	
	
	POUPANCA(2);

	private final int conta;

	TipoConta(int tipo) {
		conta = tipo;
	}
	
	public int getConta(){
		return conta;
	}
}
