package br.com.financeiro.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "Tb_Conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Conta_Id")
	private int id;
	
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

	public int getId() {
		return id;
	}

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
	public boolean isStatus() {
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

}
