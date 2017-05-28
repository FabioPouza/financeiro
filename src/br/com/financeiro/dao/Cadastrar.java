package br.com.financeiro.dao;

import javax.persistence.EntityManager;

import br.com.financeiro.model.Conta;
import br.com.financeiro.util.JpaUtil;

public class Cadastrar {

	public void cadastra(Conta conta){
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
}
