package br.com.financeiro.dao;

import org.junit.Test;

import br.com.financeiro.model.Conta;
import br.com.financeiro.validators.CategoriaValid;
import junit.framework.Assert;

public class ContaDaoTest {

	@Test
	public void testCadastra() {
		
		Conta conta = new Conta();
		conta.setNome("");
		
		CategoriaValid val = new CategoriaValid();
		
		Assert.assertEquals(true, val.verifica(conta));
		
	}

}
