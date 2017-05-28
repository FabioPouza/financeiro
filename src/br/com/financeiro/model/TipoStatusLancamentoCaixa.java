package br.com.financeiro.model;

public enum TipoStatusLancamentoCaixa {

	PENDENTE(1), PAGO(2);

	public int status;

	TipoStatusLancamentoCaixa(int tipo) {
		status = tipo;
	}
	
	public int getStatus(){
		return status;
	}

}
