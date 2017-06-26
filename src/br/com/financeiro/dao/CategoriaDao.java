package br.com.financeiro.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financeiro.model.CategoriaLancamentoCaixa;
import br.com.financeiro.util.JpaUtil;

public class CategoriaDao {

	public void cadastra(CategoriaLancamentoCaixa categoria) {

		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		em.close();

	}

	public ArrayList<CategoriaLancamentoCaixa> consulta() {

		EntityManager em = new JpaUtil().getEntityManager();

		Query query = em.createQuery("select c from CategoriaLancamentoCaixa c");

		ArrayList<CategoriaLancamentoCaixa> res = (ArrayList<CategoriaLancamentoCaixa>) query.getResultList();

		return res;
	}

}
