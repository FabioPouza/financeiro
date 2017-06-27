package br.com.financeiro.model;

public enum TipoFormaPagamento {

	DEBITO(1), CHEQUE(2), DINHEIRO(3);

	public int pagamento;

	TipoFormaPagamento(int tipo) {
		pagamento = tipo;
	}

	public int getPagamento() {
		return pagamento;
	}

}
