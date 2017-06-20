package br.com.financeiro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_categoria_lancamento_caixa")
public class CategoriaLancamentoCaixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Categoria_Lancamento_Caixa_Id")
	private int id;

	@Column(name = "Categoria_Lancamento_Caixa_Descricao")
	private String descricao;

	@OneToMany(mappedBy = "categoriaLancamentoCaixa", targetEntity = LancamentoCaixa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LancamentoCaixa> lancamentoCaixa;

	public int getId() {
		return id;
	}

	public List<LancamentoCaixa> getLancamentoCaixa() {
		return lancamentoCaixa;
	}

	public void setLancamentoCaixa(List<LancamentoCaixa> lancamentoCaixa) {
		this.lancamentoCaixa = lancamentoCaixa;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("descricao")
	public String getDescricao() {
		return descricao;
	}

	@JsonProperty("descricao")
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
