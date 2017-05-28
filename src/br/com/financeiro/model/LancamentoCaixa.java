package br.com.financeiro.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class LancamentoCaixa {

	private int id;
	private Conta conta;
	private TipoLancamentoCaixa tipoLancamentoCaixa;
	private CategoriaLancamentoCaixa categoriaLancamentoCaixa;
	private TipoFormaPagamento formaPagamento;
	private BigDecimal valor;
	private Calendar data;
	private String descricao;
	private String observacoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoLancamentoCaixa getTipoLancamentoCaixa() {
		return tipoLancamentoCaixa;
	}

	public void setTipoLancamentoCaixa(TipoLancamentoCaixa tipoLancamentoCaixa) {
		this.tipoLancamentoCaixa = tipoLancamentoCaixa;
	}

	public CategoriaLancamentoCaixa getCategoriaLancamentoCaixa() {
		return categoriaLancamentoCaixa;
	}

	public void setCategoriaLancamentoCaixa(CategoriaLancamentoCaixa categoriaLancamentoCaixa) {
		this.categoriaLancamentoCaixa = categoriaLancamentoCaixa;
	}

	public TipoFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(TipoFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
