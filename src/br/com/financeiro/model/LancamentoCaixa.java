package br.com.financeiro.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Tb_Lancamento_Caixa")
public class LancamentoCaixa implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Lancamento_Caixa_Id")
	private int id;

	@OneToMany(mappedBy = "lancamentoCaixa", targetEntity = StatusLancamentoCaixa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StatusLancamentoCaixa> statusLancamento;

	@ManyToOne
	@JoinColumn(name = "Conta_Id")
	private Conta conta;

	@Column(name = "Tipo_Lancamento_Caixa_Id")
	@Enumerated(EnumType.ORDINAL)
	private TipoLancamentoCaixa tipoLancamentoCaixa;

	@ManyToOne
	@JoinColumn(name = "Categoria_Lancamento_Caixa_Id")
	private CategoriaLancamentoCaixa categoriaLancamentoCaixa;

	@Column(name = "Forma_Pagamento_Id")
	@Enumerated(EnumType.ORDINAL)
	private TipoFormaPagamento formaPagamento;

	@Column(name = "Lancamento_Caixa_Valor")
	private double valor;

	@Column(name = "Lancamento_Caixa_Data")
	@Temporal(TemporalType.DATE)
	private Calendar data;

	@Column(name = "Lancamento_Caixa_Descricao")
	private String descricao;

	@Column(name = "Lancamento_Caixa_Observacoes")
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
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

	public TipoStatusLancamentoCaixa getTipoStatusLancamento() {
		return getTipoStatusLancamento();
	}

	public void setTipoStatusLancamento(List<StatusLancamentoCaixa> tipoStatusLancamento) {
		this.statusLancamento = tipoStatusLancamento;
	}
}
