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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.financeiro.util.EntityIdResolver;

@Entity
@Table(name = "Tb_Conta")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope=Conta.class)
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Conta_Id")
	@JsonValue
	private int id;

	@OneToMany(mappedBy = "conta", targetEntity = LancamentoCaixa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LancamentoCaixa> lancamento;

	@Column(name = "Tipo_Conta_Id")
	@Enumerated(EnumType.ORDINAL)
	private TipoConta tipoConta;

	@Column(name = "Conta_Numero")
	private String numero;

	@Column(name = "Conta_Status")
	private boolean status;

	@Column(name = "Conta_Nome")
	private String nome;

	@Column(name = "Conta_Banco")
	private String banco;

	@Column(name = "Conta_Agencia")
	private String agencia;

	@Column(name = "Conta_Data_Inicial")
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("tipo")
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	@JsonProperty("tipo")
	public void setTipoConta(TipoConta tipo) {
		this.tipoConta = tipo;
	}

	@JsonProperty("nome")
	public String getNome() {
		return nome;
	}

	@JsonProperty("nome")
	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonProperty("banco")
	public String getBanco() {
		return banco;
	}

	@JsonProperty("banco")
	public void setBanco(String banco) {
		this.banco = banco;
	}

	@JsonProperty("agencia")
	public String getAgencia() {
		return agencia;
	}

	@JsonProperty("agencia")
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	@JsonProperty("numero")
	public String getNumero() {
		return numero;
	}

	@JsonProperty("numero")
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@JsonProperty("status")
	public boolean getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(boolean status) {
		this.status = status;
	}

	@JsonProperty("data")
	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	@JsonProperty("data")
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public List<LancamentoCaixa> getLancamento() {
		return lancamento;
	}

	public void setLancamento(List<LancamentoCaixa> lancamento) {
		this.lancamento = lancamento;
	}

}
