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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Tb_Lancamento_Caixa")
public class LancamentoCaixa implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Lancamento_Caixa_Id")
	private int id;

	@OneToMany(mappedBy = "lancamentoCaixa", targetEntity = StatusLancamentoCaixa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StatusLancamentoCaixa> statusLancamento;

	@ManyToOne
	@JoinColumn(name = "Conta_Id")
	@JsonProperty("conta")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Conta conta;

	@Column(name = "Tipo_Lancamento_Caixa_Id")
	@Enumerated(EnumType.ORDINAL)
	private TipoLancamentoCaixa tipoLancamentoCaixa;

	@ManyToOne
	@JoinColumn(name = "Categoria_Lancamento_Caixa_Id")
	@JsonProperty("categoria")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

	@JsonProperty("conta")
	public Conta getConta() {
		return conta;
	}

	@JsonProperty("conta")
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@JsonProperty("tipo")
	public TipoLancamentoCaixa getTipoLancamentoCaixa() {
		return tipoLancamentoCaixa;
	}

	@JsonProperty("tipo")
	public void setTipoLancamentoCaixa(TipoLancamentoCaixa tipoLancamentoCaixa) {
		this.tipoLancamentoCaixa = tipoLancamentoCaixa;
	}
	
	@JsonProperty("categoria")
	public CategoriaLancamentoCaixa getCategoriaLancamentoCaixa() {
		return categoriaLancamentoCaixa;
	}

	@JsonProperty("categoria")
	public void setCategoriaLancamentoCaixa(CategoriaLancamentoCaixa categoriaLancamentoCaixa) {
		this.categoriaLancamentoCaixa = categoriaLancamentoCaixa;
	}

	@JsonProperty("formaPagamento")
	public TipoFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	@JsonProperty("formaPagamento")
	public void setFormaPagamento(TipoFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@JsonProperty("valor")
	public double getValor() {
		return valor;
	}

	@JsonProperty("valor")
	public void setValor(double valor) {
		this.valor = valor;
	}

	@JsonProperty("data")
	public Calendar getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Calendar data) {
		this.data = data;
	}

	@JsonProperty("descricao")
	public String getDescricao() {
		return descricao;
	}

	@JsonProperty("descricao")
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@JsonProperty("obs")
	public String getObservacoes() {
		return observacoes;
	}

	@JsonProperty("obs")
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
