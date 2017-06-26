package br.com.financeiro.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Tb_Status_Lancamento_Caixa")
public class StatusLancamentoCaixa implements java.io.Serializable{

	
	@Id
	@ManyToOne
	@JoinColumn(name = "Lancamento_Caixa_Id")
	private LancamentoCaixa lancamentoCaixa;
	
	
	@Column(name = "Tipo_Status_Lancamento_Caixa_Id")
	@Enumerated(EnumType.ORDINAL)
	private TipoStatusLancamentoCaixa tipoStatusLancamento;
	
	@Column(name = "Status_Lancamento_Caixa_Data")
	@Temporal(TemporalType.DATE)
	private Calendar data;


}
