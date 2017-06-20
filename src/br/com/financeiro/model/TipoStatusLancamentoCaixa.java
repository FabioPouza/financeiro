package br.com.financeiro.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum TipoStatusLancamentoCaixa {

	PENDENTE(1), PAGO(2);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int status;

	TipoStatusLancamentoCaixa(int tipo) {
		status = tipo;
	}
	
	public int getStatus(){
		return status;
	}

}
