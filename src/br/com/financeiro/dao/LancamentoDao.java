package br.com.financeiro.dao;

import javax.persistence.EntityManager;

import br.com.financeiro.model.LancamentoCaixa;
import br.com.financeiro.util.JpaUtil;

public class LancamentoDao {

	public void cadastra(LancamentoCaixa lancamento) {

		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(lancamento);
		em.getTransaction().commit();
		em.close();

	}

}
