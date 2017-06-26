package br.com.financeiro.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financeiro.model.Conta;
import br.com.financeiro.util.JpaUtil;

public class ContaDao {

	public void cadastra(Conta conta){
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public ArrayList<Conta> consulta() {

		EntityManager em = new JpaUtil().getEntityManager();

		Query query = em.createQuery("select c from Conta c");

		ArrayList<Conta> res = (ArrayList<Conta>) query.getResultList();

		return res;
	}
	
	
}
