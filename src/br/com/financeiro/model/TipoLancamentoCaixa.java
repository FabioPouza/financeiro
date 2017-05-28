package br.com.financeiro.model;

public enum TipoLancamentoCaixa {

	ENTRADA(1),SAIDA(2);
	
	public int lancamento;
	
	TipoLancamentoCaixa(int tipo) {
		lancamento = tipo;
	}

	public int getCLancamento(){
		return lancamento;
	}
}
