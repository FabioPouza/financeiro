package br.com.financeiro.dao;

import javax.persistence.EntityManager;

import br.com.financeiro.model.CategoriaLancamentoCaixa;
import br.com.financeiro.util.JpaUtil;

public class CategoriaDao {

	public void cadastra(CategoriaLancamentoCaixa categoria){
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
